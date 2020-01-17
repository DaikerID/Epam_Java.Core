package com.Epam.JavaCore.hw6_13_12_19.cargo.domain;

public class MaterialCargo extends Cargo {
    private Float density;

    public Float getDensity() {
        return density;
    }

    public void setDensity(Float density) {
        this.density = density;
    }

    @Override
    public CargoType getCargoType() {
        return CargoType.MATERIALS;
    }
}
