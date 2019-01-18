package simulatie.model;

import java.awt.Color;

/**
 * @author Niek Tillema, Jasper van Dijken, Rick Nieborg, Jason de Lijster
 * @version 17-1-2019
 */

public abstract class Car {

    private Location location;
    private int minutesLeft;
    private int minutesTotal;
    private boolean isPaying;
    private boolean hasToPay;
    private boolean hasReserved;
    private boolean hasReducedPrice;

    public Car() {

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getMinutesTotal() {
        return minutesTotal;
    }

    public void setMinutesTotal(int minutesTotal) {
        this.minutesTotal = minutesTotal;
    }

    public int getMinutesLeft() {
        return minutesLeft;
    }

    public void setMinutesLeft(int minutesLeft) {
        this.minutesLeft = minutesLeft;
    }

    public boolean getIsPaying() {
        return isPaying;
    }

    public void setIsPaying(boolean isPaying) {
        this.isPaying = isPaying;
    }

    public boolean getHasToPay() {
        return hasToPay;
    }

    public void setHasToPay(boolean hasToPay) {
        this.hasToPay = hasToPay;
    }

    public boolean getHasReserved() {
        return hasReserved;
    }

    public void setHasReserved(boolean hasReserved) {
        this.hasReserved = hasReserved;
    }

    public boolean getHasReducedPrice() {
        return hasReducedPrice;
    }

    public void setHasReducedPrice(boolean hasReducedPrice) {
        this.hasReducedPrice = hasReducedPrice;
    }

    public void tick() {
        minutesLeft--;
    }

    public abstract Color getColor();
}