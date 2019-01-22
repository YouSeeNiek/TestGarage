package simulatie.model;

import java.awt.Color;
import java.util.Random;

/**
 * @author Niek Tillema, Jasper van Dijken, Rick Nieborg, Jason de Lijster
 * @version 17-1-2019
 */

public class ReservedCar extends Car {
    private static final Color COLOR=Color.decode("#00b300");

    public ReservedCar() {
        Random random = new Random();
        int stayMinutes = (int) (15 + random.nextFloat() * 3 * 60);
        this.setMinutesLeft(stayMinutes);
        this.setMinutesTotal(stayMinutes);
        this.setHasToPay(true);
        this.setHasReserved(true);
        this.setHasReducedPrice(false);
    }

    public Color getColor(){
        return COLOR;
    }
}