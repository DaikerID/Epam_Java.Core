package com.Epam.JavaCore.hw5_11_12_19.cargo.domain.types;

import com.Epam.JavaCore.hw5_11_12_19.cargo.domain.Cargo;

public class Animal extends Cargo {
    private Float amountOfFoodPerHour;

    public Float getAmountOfFoodPerHour() {
        return amountOfFoodPerHour;
    }

    public void setAmountOfFoodPerHour(Float amountOfFoodPerHour) {
        this.amountOfFoodPerHour = amountOfFoodPerHour;
    }
}
