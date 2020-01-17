package com.Epam.JavaCore.hw3_6_12_19;

import java.util.Vector;

public class DeliveryRoute {
    Vector<Transportation> transportationRoute;
    Cargo cargo;

    DeliveryRoute(Cargo cargo) {
        this.cargo = cargo;
    }

    public void addNewTransportation(Transportation transportation) {
        transportationRoute.add(transportation);
    }

    public Float calculateCost() {
        Float cost = 0f;
        for (Transportation transportation : transportationRoute) {
            cost += transportation.getCostOfKg() * cargo.getWeight();
        }
        return cost;
    }

    public void confirm() {
        for (Transportation transportation : transportationRoute) {
            transportation.addCargo(cargo);
        }
    }

    public Vector<Transportation> getTransportationRoute() {
        return transportationRoute;
    }

    public Cargo getCargo() {
        return cargo;
    }
}


