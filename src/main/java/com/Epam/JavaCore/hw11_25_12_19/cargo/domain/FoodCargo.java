package com.Epam.JavaCore.hw11_25_12_19.cargo.domain;

import com.Epam.JavaCore.hw12_27_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw12_27_12_19.cargo.domain.CargoType;

import java.util.Date;

public class FoodCargo extends Cargo {

    private Date expirationDate;
    private int storeTemperature;

    @Override
    public com.Epam.JavaCore.hw12_27_12_19.cargo.domain.CargoType getCargoType() {
        return CargoType.FOOD;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getStoreTemperature() {
        return storeTemperature;
    }

    public void setStoreTemperature(int storeTemperature) {
        this.storeTemperature = storeTemperature;
    }
}
