package simulatie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import simulatie.AbstractView;
import simulatie.SimulatorView;
import simulatie.Testor;

public class Simulator implements Runnable {

    private int numberOfFloors;
    private int numberOfRows;
    private int numberOfPlaces;
    private int numberOfOpenSpots;
    private int numberOfOpenParkingPassSpots;
    private int numberOfPresentCars;
    private Car[][][] cars;

    private static final String AD_HOC = "1";
    private static final String PARKINGPASS = "2";
    private static final String RESERVED = "3";

    private CarQueue entranceCarQueue;
    private CarQueue entrancePassQueue;
    private CarQueue paymentCarQueue;
    private CarQueue exitCarQueue;

    private int day = 0;
    private int hour = 0;
    private int minute = 0;

    private static int tickPause = 100;

    int weekDayArrivals=100;
    int weekendArrivals = 200;
    int weekDayParkingPassArrivals= 50;
    int weekendParkingPassArrivals = 5;
    int weekDayReservedArrivals= 50;
    int weekendReservedArrivals = 5;

    int enterSpeed = 3;
    int paymentSpeed = 7;
    int exitSpeed = 5;

    double turnoverTotal;

    double price;
    double priceReduced;

    public boolean run;

    private List<AbstractView> views;
	
    
    public Simulator() {
    	this.numberOfPresentCars = 0;
        this.numberOfFloors = 3;
        this.numberOfRows = 6;
        this.numberOfPlaces = 30;
        this.numberOfOpenSpots = (numberOfFloors - 1) * numberOfRows * numberOfPlaces;
        this.numberOfOpenParkingPassSpots = numberOfRows * numberOfPlaces;

        cars = new Car[numberOfFloors][numberOfRows][numberOfPlaces];
        entranceCarQueue = new CarQueue();
        entrancePassQueue = new CarQueue();
        paymentCarQueue = new CarQueue();
        exitCarQueue = new CarQueue();
        price = 2.4;
        priceReduced = 2.0;
        turnoverTotal = 0.0;

        views = new ArrayList<AbstractView>();
    }

    public void addView(AbstractView abstractView) {
        views.add(abstractView);
    }
    
    public void notifyView() {
        for(AbstractView v: views) v.updateView();
    }
    
    //Method to start the simulation
    public void start() {
    	run = true;
        new Thread(this).start();
    }

    //Method to pause the simulation
    public void pause() {
    	run = false;
    }
    
    public static void setTickPause(int i) {
    	tickPause = i;
    }
    
    public void run() {
        //run = true;
        
        for (int i = 0; i < 10000; i++) {
        	if (!run) {
        		return;
        	}
        	tick();
        }
        
    }
    
    
    //Calculation to get the amount of cars present in the garage
    public int getNumberOfCars() {
    	return numberOfPresentCars = (540-(numberOfOpenSpots+numberOfOpenParkingPassSpots));
    }
    
    
    public void tick() {
        advanceTime();
        handleExit();
        updateViews();
        //Calling the method in Testor to update progressBar with each Tick()
        Testor.setProgressValue(getNumberOfCars());
        try {
            Thread.sleep(tickPause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        handleEntrance();
        
    }

    private void advanceTime(){
        minute++;
        while (minute > 59) {
            minute -= 60;
            hour++;
        }
        while (hour > 23) {
            hour -= 24;
            day++;
        }
        while (day > 6) {
            day -= 7;
        }

    }

    private void handleEntrance(){
        carsArriving();
        carsEntering(entrancePassQueue);
        carsEntering(entranceCarQueue);
    }

    private void handleExit(){
        carsReadyToLeave();
        carsPaying();
        carsLeaving();
    }

    public void updateViews(){
        tick(turnoverTotal);
        notifyView();
    }

    private void carsArriving(){
        int numberOfCars=getNumberOfCars(weekDayArrivals, weekendArrivals);
        addArrivingCars(numberOfCars, AD_HOC);
        numberOfCars=getNumberOfCars(weekDayParkingPassArrivals, weekendParkingPassArrivals);
        addArrivingCars(numberOfCars, PARKINGPASS);
        numberOfCars=getNumberOfCars(weekDayReservedArrivals, weekendReservedArrivals);
        addArrivingCars(numberOfCars, RESERVED);
    }
    
    private void carsEntering(CarQueue queue){
        int i=0;
        while(queue.carsInQueue() > 0 && i<enterSpeed && ((queue.peekCar().getHasParkingPass() && getNumberOfOpenParkingPassSpots() > 0) || (!queue.peekCar().getHasParkingPass() && getNumberOfOpenParkingPassSpots() > 0) ) ) {
            if(queue.peekCar().getHasParkingPass() && getNumberOfOpenParkingPassSpots() > 0) {
                Car car = queue.removeCar();
                Location freeLocation = getFirstFreeParkingPassLocation();
                setCarAt(freeLocation, car);
                i++;
            } else if(!queue.peekCar().getHasParkingPass() && getNumberOfOpenSpots() > 0) {
                Car car = queue.removeCar();
                Location freeLocation = getFirstFreeLocation();
                setCarAt(freeLocation, car);

                if(!car.getHasToPay()) {
                    double priceTemp = priceReduced * (car.getMinutesTotal() / (double) 60);
                    turnoverTotal += priceTemp;
                }

                i++;
            }
        }
     }

    private void carsReadyToLeave(){
        Car car = getFirstLeavingCar();
        while (car!=null) {
        	if (car.getHasToPay()){
	            car.setIsPaying(true);
	            paymentCarQueue.addCar(car);
        	}
        	else {
        		carLeavesSpot(car);
        	}
            car = getFirstLeavingCar();
        }
    }

    private void carsPaying(){
        int i=0;
        while (paymentCarQueue.carsInQueue()>0 && i < paymentSpeed){
            Car car = paymentCarQueue.removeCar();

            double priceTemp = price * (car.getMinutesTotal() / (double)60);
            turnoverTotal += priceTemp;

            carLeavesSpot(car);
            i++;
        }
    }

    private void carsLeaving(){
        int i=0;
        while (exitCarQueue.carsInQueue()>0 && i < exitSpeed){
            exitCarQueue.removeCar();
            i++;
        }
    }

    private int getNumberOfCars(int weekDay, int weekend){
        Random random = new Random();

        int averageNumberOfCarsPerHour = day < 5
                ? weekDay
                : weekend;

        double standardDeviation = averageNumberOfCarsPerHour * 0.3;
        double numberOfCarsPerHour = averageNumberOfCarsPerHour + random.nextGaussian() * standardDeviation;
        return (int)Math.round(numberOfCarsPerHour / 60);
    }

    private void addArrivingCars(int numberOfCars, String type){
        switch(type) {
            case AD_HOC:
                for (int i = 0; i < numberOfCars; i++) {
                    entranceCarQueue.addCar(new AdHocCar());
                }
                break;
            case PARKINGPASS:
                for (int i = 0; i < numberOfCars; i++) {
                    entrancePassQueue.addCar(new ParkingPassCar());
                }
                break;
            case RESERVED:
                for (int i = 0; i < numberOfCars; i++) {
                    entrancePassQueue.addCar(new ReservedCar());
                }
                break;
        }
    }

    private void carLeavesSpot(Car car){
        removeCarAt(car.getLocation());
        exitCarQueue.addCar(car);
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public int getNumberOfOpenSpots(){
        return numberOfOpenSpots;
    }

    public int getNumberOfOpenParkingPassSpots(){
        return numberOfOpenParkingPassSpots;
    }

    public Car getCarAt(Location location) {
        if (!locationIsValid(location)) {
            return null;
        }
        return cars[location.getFloor()][location.getRow()][location.getPlace()];
    }

    public boolean setCarAt(Location location, Car car) {
        if (!locationIsValid(location)) {
            return false;
        }
        Car oldCar = getCarAt(location);
        if (oldCar == null) {
            cars[location.getFloor()][location.getRow()][location.getPlace()] = car;
            car.setLocation(location);
            if(car.getHasParkingPass()){
                numberOfOpenParkingPassSpots--;
            } else {
                numberOfOpenSpots--;
            }
            return true;
        }
        return false;
    }

    public Car removeCarAt(Location location) {
        if (!locationIsValid(location)) {
            return null;
        }
        Car car = getCarAt(location);
        if (car == null) {
            return null;
        }
        cars[location.getFloor()][location.getRow()][location.getPlace()] = null;
        car.setLocation(null);
        if(car.getHasParkingPass()){
            numberOfOpenParkingPassSpots++;
        } else {
            numberOfOpenSpots++;
        }
        return car;
    }

    public Location getFirstFreeLocation() {
        for (int floor = 0; floor < getNumberOfFloors()-1; floor++) {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int place = 0; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    if (getCarAt(location) == null) {
                        return location;
                    }
                }
            }
        }
        return null;
    }

    public Location getFirstFreeParkingPassLocation() {
        for (int floor = 2; floor < getNumberOfFloors(); floor++) {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int place = 0; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    if (getCarAt(location) == null) {
                        return location;
                    }
                }
            }
        }
        return null;
    }

    public Car getFirstLeavingCar() {
        for (int floor = 0; floor < getNumberOfFloors(); floor++) {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int place = 0; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    Car car = getCarAt(location);
                    if (car != null && car.getMinutesLeft() <= 0 && !car.getIsPaying()) {
                        return car;
                    }
                }
            }
        }
        return null;
    }

    public void tick(double turnoverTotal) {
        for (int floor = 0; floor < getNumberOfFloors(); floor++) {
            for (int row = 0; row < getNumberOfRows(); row++) {
                for (int place = 0; place < getNumberOfPlaces(); place++) {
                    Location location = new Location(floor, row, place);
                    Car car = getCarAt(location);
                    if (car != null) {
                        car.tick();
                    }
                }
            }
        }
        String text = String.format("%.2f", (double)turnoverTotal);
    }

    private boolean locationIsValid(Location location) {
        int floor = location.getFloor();
        int row = location.getRow();
        int place = location.getPlace();
        if (floor < 0 || floor >= numberOfFloors || row < 0 || row > numberOfRows || place < 0 || place > numberOfPlaces) {
            return false;
        }
        return true;
    }
}
