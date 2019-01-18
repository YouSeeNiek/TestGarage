package simulatie.model;

import java.awt.Color;
import java.util.Random;

/**
 * Created by Timothy on 6-2-2017.
 */

public class ParkingPassCar extends Car {
    private static final Color COLOR=Color.BLUE;

    /**
     * Constructor for the ParkingPassCar class. Car stays between 15 and 195 minutes.
     */
    public ParkingPassCar() {
        Random random = new Random();
        int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setMinutesTotal(stayMinutes);
        this.setHasToPay(false);
        this.setHasReserved(false);
        this.setHasReducedPrice(true);
    }

    /**
     * @return  Colour of the car
     */
    public Color getColor(){
        return COLOR;
    }
}