package com.Epam.JavaCore.hw5_11_12_19.cargo.domain.types;

import com.Epam.JavaCore.hw5_11_12_19.cargo.domain.Cargo;

public class Material extends Cargo {
    private Float density;

    public Float getDensity() {
        return density;
    }

    public void setDensity(Float density) {
        this.density = density;
    }
}
