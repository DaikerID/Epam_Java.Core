package com.Epam.JavaCore.hw4_9_12_19.cargo;

import com.Epam.JavaCore.hw4_9_12_19.Entity;
import com.Epam.JavaCore.hw4_9_12_19.transportation.Transportation;

public class Cargo extends Entity {
    private String name;
    private int weight;
    private CargoType cargoType;
    private Transportation[] transportations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public Transportation[] getTransportations() {
        return transportations;
    }

    public void setTransportations(Transportation[] transportations) {
        this.transportations = transportations;
    }
}