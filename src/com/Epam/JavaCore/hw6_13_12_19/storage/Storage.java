package com.Epam.JavaCore.hw6_13_12_19.storage;

import com.Epam.JavaCore.hw6_13_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw6_13_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw6_13_12_19.common.utils.ArrayUtils;
import com.Epam.JavaCore.hw6_13_12_19.transportation.domain.Transportation;

import java.util.Objects;

public class Storage {
    private static final int ARRAY_CAPACITY = 10;

    private static Cargo[] cargos = new Cargo[ARRAY_CAPACITY];
    private static int cargoIndex = 0;

    private static Carrier[] carriers = new Carrier[ARRAY_CAPACITY];
    private static int carrierIndex = 0;

    private static Transportation[] transportations = new Transportation[ARRAY_CAPACITY];
    private static int transportationIndex = 0;


    public static void addCargo(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargos[cargoIndex] = cargo;
        cargoIndex++;

        if (cargoIndex % (ARRAY_CAPACITY - 1) == 0) {
            Cargo[] newCargos = new Cargo[cargoIndex + ARRAY_CAPACITY];
            ArrayUtils.copyArray(cargos, newCargos);
            cargos = newCargos;
        }
    }

    public static void addCarrier(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carriers[carrierIndex] = carrier;
        carrierIndex++;

        if (cargoIndex % (ARRAY_CAPACITY - 1) == 0) {
            Carrier[] newCarriers = new Carrier[carrierIndex + ARRAY_CAPACITY];
            ArrayUtils.copyArray(carriers, newCarriers);
            carriers = newCarriers;
        }
    }

    public static void addTransportation(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportations[transportationIndex] = transportation;
        transportationIndex++;

        if (cargoIndex % (ARRAY_CAPACITY - 1) == 0) {
            Transportation[] newTransportations = new Transportation[transportationIndex + ARRAY_CAPACITY];
            ArrayUtils.copyArray(transportations, newTransportations);
            transportations = newTransportations;
        }
    }

    public static void printAllCargos() {
        ArrayUtils.printArray(cargos);
    }

    public static void printAllCarries() {
        ArrayUtils.printArray(carriers);
    }

    public static void printAllTransportations() {
        ArrayUtils.printArray(transportations);
    }

    public static Cargo getCargoById(long id) {
        for (Cargo cargo : cargos) {
            if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
                return cargo;
            }
        }
        return null;
    }

    public static Carrier getCarrierById(long id) {
        for (Carrier carrier : carriers) {
            if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
                return carrier;
            }
        }
        return null;
    }

    public static Transportation getTransportationById(long id) {
        for (Transportation transportation : transportations) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }
        return null;
    }

    public static Cargo[] getCargosByName(String name) {
        Cargo[] result = new Cargo[cargos.length];

        int curIndex = 0;
        for (Cargo cargo : cargos) {
            if (cargo != null && Objects.equals(cargo.getName(), name)) {
                result[curIndex++] = cargo;
            }
        }
        Cargo[] cleanResult = new Cargo[0];
        ArrayUtils.cutArray(result, cleanResult);
        return cleanResult;
    }

    public static Carrier[] getCarriersByName(String name) {
        Carrier[] result = new Carrier[carriers.length];

        int curIndex = 0;
        for (Carrier carrier : carriers) {
            if (carrier != null && Objects.equals(carrier.getName(), name)) {
                result[curIndex++] = carrier;
            }
        }
        Carrier[] cleanResult = new Carrier[curIndex];
        ArrayUtils.cutArray(result, cleanResult);
        return cleanResult;
    }
}
