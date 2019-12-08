package com.Epam.JavaCore.hw_3_6_12_19;

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

    public void setRoute(Route route) {
        this.route = route;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }
}
