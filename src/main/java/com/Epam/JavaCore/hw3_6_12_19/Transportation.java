package com.Epam.JavaCore.hw3_6_12_19;

public class Transportation {
    private Route route;
    private Vehicle vehicle;
    private Float freeWeight;
    private Float freeVolume;

    public Transportation(Route route, Vehicle vehicle) {
        this.route = route;
        this.vehicle = vehicle;
        this.freeWeight = vehicle.getMaxWeight();
        this.freeVolume = vehicle.getMaxVolume();
    }

    public boolean checkFree(Cargo cargo) {
        return (freeWeight >= cargo.getWeight()) && (freeVolume >= cargo.getVolume());
    }

    public void addCargo(Cargo cargo) {
        freeWeight -= cargo.getWeight();
        freeVolume -= cargo.getVolume();
    }

    public Route getRoute() {
        return route;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Float getCostOfKg() {
        return vehicle.getMarginRate() * route.getDistance();
    }
}
