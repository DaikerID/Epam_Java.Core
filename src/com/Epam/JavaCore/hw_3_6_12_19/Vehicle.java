package com.Epam.JavaCore.hw_3_6_12_19;

public enum Vehicle {
    TRUCK(2, 10000, 45),
    PLANE(3, 8000, 800),
    TRAIN(1, 50000, 1000000),
    SHIP(0.5f, 100000, 10000000),
    HELICOPTER(4, 1000, 10);

    private Float marginRate;
    private Float maxWeight;
    private Float maxVolume;

    Vehicle(float marginRate, float maxWeight, float maxVolume) {
        this.marginRate = marginRate;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
    }

    public Float getMarginRate() {
        return marginRate;
    }

    public Float getMaxWeight() {
        return maxWeight;
    }

    public Float getMaxVolume() {
        return maxVolume;
    }
}
