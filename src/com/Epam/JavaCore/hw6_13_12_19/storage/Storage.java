package com.Epam.JavaCore.hw6_13_12_19.storage;

import com.Epam.JavaCore.hw6_13_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw6_13_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw6_13_12_19.transportation.domain.Transportation;

import java.util.Objects;

public class Storage {
    protected static final int ARRAY_CAPACITY = 10;

    protected static Cargo[] cargos = new Cargo[ARRAY_CAPACITY];
    protected static int cargoIndex = 0;

    protected static Carrier[] carriers = new Carrier[ARRAY_CAPACITY];
    protected static int carrierIndex = 0;

    protected static Transportation[] transportations = new Transportation[ARRAY_CAPACITY];
    protected static int transportationIndex = 0;
}
