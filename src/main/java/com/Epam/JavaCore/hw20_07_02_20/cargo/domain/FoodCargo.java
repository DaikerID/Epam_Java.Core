package com.Epam.JavaCore.hw20_07_02_20.cargo.domain;


import java.time.ZonedDateTime;

public class FoodCargo extends Cargo {

    private ZonedDateTime expirationDate;
    private int storeTemperature;

    @Override
    public CargoType getCargoType() {
        return CargoType.FOOD;
    }

    public ZonedDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ZonedDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getStoreTemperature() {
        return storeTemperature;
    }

    public void setStoreTemperature(int storeTemperature) {
        this.storeTemperature = storeTemperature;
    }
}
