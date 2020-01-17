package com.Epam.JavaCore.hw6_13_12_19.transportation.repo;

import com.Epam.JavaCore.hw6_13_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw6_13_12_19.common.utils.ArrayUtils;
import com.Epam.JavaCore.hw6_13_12_19.storage.IdGenerator;
import com.Epam.JavaCore.hw6_13_12_19.storage.Storage;
import com.Epam.JavaCore.hw6_13_12_19.transportation.domain.Transportation;

public class TransportationRepoImplements extends Storage implements TransportationRepo {

    @Override
    public void add(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportations[transportationIndex] = transportation;
        transportationIndex++;

        if (transportationIndex % (ARRAY_CAPACITY - 1) == 0) {
            Transportation[] newTransportations = new Transportation[transportationIndex + ARRAY_CAPACITY];
            ArrayUtils.copyArray(transportations, newTransportations);
            transportations = newTransportations;
        }
    }

    @Override
    public Transportation getById(long id) {
        for (Transportation transportation : transportations) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        for (int i = 0; i < transportations.length; i++) {
            if (transportations[i].getId().equals(id)) {
                transportations = (Transportation[]) ArrayUtils.cutArrayWithout(transportations, i);
            }
        }
    }

    @Override
    public void printAll() {
        ArrayUtils.printArray(transportations);
    }
}
