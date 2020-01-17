package com.Epam.JavaCore.hw3_6_12_19;

public class Cargo {
    private Route route;
    private Float weight;
    private Float volume;


    public Cargo(Route route, float weight, float volume) {
        this.route = route;
        this.weight = weight;
        this.volume = volume;
    }

    public Route getRoute() {
        return route;
    }

    public Float getWeight() {
        return weight;
    }

    public Float getVolume() {
        return volume;
    }
}
