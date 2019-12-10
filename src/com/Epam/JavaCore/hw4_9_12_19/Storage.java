package com.Epam.JavaCore.hw4_9_12_19;

import com.Epam.JavaCore.hw4_9_12_19.cargo.Cargo;
import com.Epam.JavaCore.hw4_9_12_19.carrier.Carrier;
import com.Epam.JavaCore.hw4_9_12_19.transportation.Transportation;

import java.util.Arrays;

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

    public void addCargo(Entity entity) {
        if (entity != null) {
            if (Cargo.class.equals(entity.getClass())) {
                entity.setId(cargoLastID);
                cargoLastID++;
                if (cargosLength < cargos.length) {
                    cargos[cargosLength] = (Cargo) entity;
                    cargosLength++;
                } else {
                    cargos = (Cargo[]) addInArray(entity, cargos, new Cargo[cargosLength + 10]);
                    cargosLength++;
                }
            }
        }
    }

    public void addCarrier(Entity entity) {
        if (entity != null) {
            if (Carrier.class.equals(entity.getClass())) {
                entity.setId(carrierLastID);
                carrierLastID++;
                if (carriersLength < carriers.length) {
                    carriers[carriersLength] = (Carrier) entity;
                    carriersLength++;
                } else {
                    carriers = (Carrier[]) addInArray(entity, carriers, new Carrier[carriersLength + 10]);
                    carriersLength++;
                }
            }
        }
    }

    public void addTransportation(Entity entity) {
        if (entity != null) {
            if (Transportation.class.equals(entity.getClass())) {
                entity.setId(transportationLastID);
                transportationLastID++;
                if (transportationsLength < transportations.length) {
                    transportations[transportationsLength] = (Transportation) entity;
                    transportationsLength++;
                } else {
                    transportations = (Transportation[]) addInArray(entity, transportations, new Transportation[transportationsLength]);
                    transportationsLength++;
                }
            }
        }
    }

    private Entity[] addInArray(Entity entity, Entity[] oldArrray, Entity[] newArray) {
        Long maxId = 0l;
        for (int i = 0; i < oldArrray.length; i++) {
            newArray[i] = oldArrray[i];
        }
        entity.setId(maxId);
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
