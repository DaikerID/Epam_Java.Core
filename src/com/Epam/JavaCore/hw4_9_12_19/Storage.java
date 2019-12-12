package com.Epam.JavaCore.hw4_9_12_19;

import com.Epam.JavaCore.hw4_9_12_19.cargo.Cargo;
import com.Epam.JavaCore.hw4_9_12_19.carrier.Carrier;
import com.Epam.JavaCore.hw4_9_12_19.transportation.Transportation;

public class Storage {
    private Cargo[] cargos = new Cargo[10];
    private Carrier[] carriers = new Carrier[10];
    private Transportation[] transportations = new Transportation[10];
    private int cargosLength = 0;
    private int carriersLength = 0;
    private int transportationsLength = 0;
    private Long cargoLastID = 1l;
    private Long carrierLastID = 1l;
    private Long transportationLastID = 1l;

    public void addCargo(Cargo cargo) {
        if (cargo != null) {
            cargo.setId(cargoLastID);
            cargoLastID++;
            if (cargosLength < cargos.length) {
                cargos[cargosLength] = cargo;
                cargosLength++;
            } else {
                cargos = (Cargo[]) addInArray(cargo, cargos, new Cargo[cargosLength + 10]);
                cargosLength++;
            }
        }
    }

    public void addCarrier(Carrier carrier) {
        if (carrier != null) {
            carrier.setId(carrierLastID);
            carrierLastID++;
            if (carriersLength < carriers.length) {
                carriers[carriersLength] = carrier;
                carriersLength++;
            } else {
                carriers = (Carrier[]) addInArray(carrier, carriers, new Carrier[carriersLength + 10]);
                carriersLength++;
            }
        }
    }

    public void addTransportation(Transportation transportation) {
        if (transportation != null) {
            transportation.setId(transportationLastID);
            transportationLastID++;
            if (transportationsLength < transportations.length) {
                transportations[transportationsLength] = transportation;
                transportationsLength++;
            } else {
                transportations = (Transportation[]) addInArray(transportation, transportations, new Transportation[transportationsLength + 10]);
                transportationsLength++;
            }
        }
    }

    private Entity[] addInArray(Entity entity, Entity[] oldArrray, Entity[] newArray) {
        for (int i = 0; i < oldArrray.length; i++) {
            newArray[i] = oldArrray[i];
        }
        newArray[oldArrray.length] = entity;
        return newArray;
    }

    public Cargo[] getCargos() {
        return cargos;
    }

    public Carrier[] getCarriers() {
        return carriers;
    }

    public Transportation[] getTransportations() {
        return transportations;
    }
}
