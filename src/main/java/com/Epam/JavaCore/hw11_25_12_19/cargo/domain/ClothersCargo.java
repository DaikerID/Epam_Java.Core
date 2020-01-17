package com.Epam.JavaCore.hw11_25_12_19.cargo.domain;

import com.Epam.JavaCore.hw12_27_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw12_27_12_19.cargo.domain.CargoType;

public class ClothersCargo extends Cargo {

    private String size;
    private String material;

    @Override
    public com.Epam.JavaCore.hw12_27_12_19.cargo.domain.CargoType getCargoType() {
        return CargoType.CLOTHERS;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
