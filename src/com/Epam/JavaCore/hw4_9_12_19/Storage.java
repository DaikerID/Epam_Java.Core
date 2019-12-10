package com.Epam.JavaCore.hw4_9_12_19;

import com.Epam.JavaCore.hw4_9_12_19.cargo.Cargo;
import com.Epam.JavaCore.hw4_9_12_19.carrier.Carrier;
import com.Epam.JavaCore.hw4_9_12_19.transportation.Transportation;

public class Storage {
    private Entity[] cargos = new Cargo[0];
    private Entity[] carriers = new Carrier[0];
    private Entity[] transportations = new Transportation[0];
    private int cargosLength = 0;
    private int carriersLength = 0;
    private int transportationsLength = 0;

    public Entity[] getCargos() {
        return cargos;
    }

    public void add(Entity entity) {
        if (entity != null) {
            if (Cargo.class.equals(entity.getClass())) {
                cargosLength++;
                cargos = addInMass(entity, cargos, new Cargo[cargosLength]);
            } else if (Carrier.class.equals(entity.getClass())) {
                carriersLength++;
                carriers = addInMass(entity,carriers,new Carrier[carriersLength]);
            } else if (Transportation.class.equals(entity.getClass())) {
                transportationsLength++;
                transportations = addInMass(entity, transportations,new Transportation[transportationsLength]);
            }
        }
    }

    private Entity[] addInMass(Entity entity, Entity[] oldMassive, Entity[] newMassive) {
        Long maxId = 0l;

        for (int i = 0; i < oldMassive.length; i++) {
            newMassive[i] = oldMassive[i];
            if (oldMassive[i].getId() > maxId) {
                maxId = oldMassive[i].getId();
            }
        }
        maxId++;
        entity.setId(maxId);
        newMassive[oldMassive.length] = entity;

        return newMassive;
    }

    public Entity[] getCarriers() {
        return carriers;
    }

    public Entity[] getTransportations() {
        return transportations;
    }
}
