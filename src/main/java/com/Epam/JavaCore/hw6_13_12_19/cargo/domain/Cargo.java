package com.Epam.JavaCore.hw6_13_12_19.cargo.domain;

import com.Epam.JavaCore.hw6_13_12_19.common.domen.BaseEntity;
import com.Epam.JavaCore.hw6_13_12_19.transportation.domain.Transportation;

import java.util.Arrays;

public class Cargo extends BaseEntity {
    protected String name;
    protected int weight;
    protected CargoType cargoType;
    protected Transportation[] transportations;

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

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", cargoType=" + cargoType +
                ", transportations=" + Arrays.toString(transportations) +
                '}';
    }
}