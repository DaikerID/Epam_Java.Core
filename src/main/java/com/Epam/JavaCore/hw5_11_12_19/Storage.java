package com.Epam.JavaCore.hw5_11_12_19;

import com.Epam.JavaCore.hw5_11_12_19.common.Entity;
import com.Epam.JavaCore.hw5_11_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw5_11_12_19.transportation.domain.Transportation;
import com.Epam.JavaCore.hw5_11_12_19.cargo.domain.Cargo;

public class Storage {
    private static final int ARRAY_CAPACITY = 2;

    private static Cargo[] cargos = new Cargo[ARRAY_CAPACITY];
    private static Carrier[] carriers = new Carrier[ARRAY_CAPACITY];
    private static Transportation[] transportations = new Transportation[ARRAY_CAPACITY];
    private static int cargoIndex = 0;
    private static int carrierIndex = 0;
    private static int transportationIndex = 0;

    public static void addCargo(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargos[cargoIndex] = cargo;
        cargoIndex++;

        if (cargoIndex % (ARRAY_CAPACITY - 1) == 0) {
            cargos = (Cargo[]) copyArray(cargos,
                    new Cargo[cargoIndex + ARRAY_CAPACITY]);
        }
    }

    public static void addCarrier(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carriers[carrierIndex] = carrier;
        carrierIndex++;

        if (cargoIndex % (ARRAY_CAPACITY - 1) == 0) {
            carriers = (Carrier[]) copyArray(carriers,
                    new Carrier[carrierIndex + ARRAY_CAPACITY]);
        }
    }

    public static void addTransportation(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportations[transportationIndex] = transportation;
        transportationIndex++;

        if (cargoIndex % (ARRAY_CAPACITY - 1) == 0) {
            transportations = (Transportation[]) copyArray(transportations,
                    new Transportation[transportationIndex + ARRAY_CAPACITY]);
        }
    }

    private static Entity[] copyArray(Entity[] oldArray, Entity[] newArray) {
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    public static void printAllCargos() {
        for (Cargo cargo : cargos) {
            if (cargo != null) {
                System.out.println(cargo);
            }
        }
    }

    public static void printAllCarries() {
        for (Carrier carrier : carriers) {
            if (carrier != null) {
                System.out.println(carrier);
            }
        }
    }

    public static void printAllTransportations() {
        for (Transportation transportation : transportations) {
            if (transportation != null) {
                System.out.println(transportation);
            }
        }
    }

    public static Cargo getCargoById(Long id) {
        for (Cargo cargo : cargos) {
            if (cargo != null && cargo.getId().equals(id)) {
                return cargo;
            }
        }
        return null;
    }

    public static Carrier getCarrierById(Long id) {
        for (Carrier carrier : carriers) {
            if (carrier != null && carrier.getId().equals(id)) {
                return carrier;
            }
        }
        return null;
    }

    public static Transportation getTransportationById(Long id) {
        for (Transportation transportation : transportations) {
            if (transportation != null && transportation.getId().equals(id)) {
                return transportation;
            }
        }
        return null;
    }

    public static Cargo[] getCargoByName(String name) {
        Cargo[] cargosByName = new Cargo[ARRAY_CAPACITY];
        int index = 0;
        for (Cargo cargo : cargos) {
            if (cargo != null && cargo.getName().equals(name)) {
                cargosByName[index] = cargo;
                index++;
                if (index % (ARRAY_CAPACITY - 1) == 0) {
                    cargosByName = (Cargo[]) copyArray(cargosByName,
                            new Cargo[index + ARRAY_CAPACITY]);
                }
            }
        }
        return cargosByName;
    }

    public static Carrier[] getCarrierByName(String name) {
        Carrier[] carriersByName = new Carrier[ARRAY_CAPACITY];
        int index = 0;
        for (Carrier carrier : carriers) {
            if (carrier != null && carrier.getName().equals(name)) {
                carriersByName[index] = carrier;
                index++;
                if (index % (ARRAY_CAPACITY - 1) == 0) {
                    carriersByName = (Carrier[]) copyArray(carriersByName,
                            new Carrier[index + ARRAY_CAPACITY]);
                }
            }
        }
        return carriersByName;
    }
}
