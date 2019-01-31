package simulatie;
 

import java.awt.*;

import simulatie.model.Simulator;

public class PieChartCars extends AbstractView{

    public PieChartCars(Simulator model){
        super(model);
        setSize(200,200);
    }
    
    public void paintComponent(Graphics g) {
    	g.setColor(Color.WHITE);
        g.fillRect(0, 0, 200, 200);

        int amountOfAd_Hoc = /*model.getAmountOfAd_Hoc()*/ 200;
        int amountOfPassCars = /*model.getAmountOfPassCars()*/100;
        int amountOfReservedCars = /*model.getAmountOfReservedCars()*/200;
        
        System.out.println("Check amountOfAd_Hoc = " + amountOfAd_Hoc);
        System.out.println("Check amountOfPassCars = " + amountOfPassCars);
        System.out.println("Check amountOfReservedCars = " + amountOfReservedCars);

        //360 degree circle / 540 parking spots
        float equalizer = 360f / 540f;
        int angleAd_Hoc = Math.round(amountOfAd_Hoc * equalizer);
        int anglePassCars = Math.round(amountOfPassCars * equalizer);
        int angleReservedCars = Math.round(amountOfReservedCars);
        
        //Ad_Hoc slice
        g.setColor(Color.RED);
        g.fillArc(10, 10, 180, 180, 0, angleAd_Hoc);
        //PassCars slice
        g.setColor(Color.BLUE);
        g.fillArc(10, 10, 180, 180, angleAd_Hoc, anglePassCars);
        //ReservedCars slice
        g.setColor(Color.GREEN);
        g.fillArc(10, 10, 180, 180, anglePassCars + angleAd_Hoc, angleReservedCars);
        g.setColor(Color.LIGHT_GRAY);
        g.fillArc(10, 10, 180, 180, anglePassCars + angleAd_Hoc + angleReservedCars, 360-(angleAd_Hoc + anglePassCars + angleReservedCars));
        
    }
}