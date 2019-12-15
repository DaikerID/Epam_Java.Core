package com.Epam.JavaCore.hw6_13_12_19.transportation.repo;

import com.Epam.JavaCore.hw6_13_12_19.common.utils.ArrayUtils;
import com.Epam.JavaCore.hw6_13_12_19.storage.IdGenerator;
import com.Epam.JavaCore.hw6_13_12_19.transportation.domain.Transportation;

public class TransportationRepoImplements implements TransportationRepo {
    private static final int ARRAY_CAPACITY = 10;
    private static Transportation[] transportations = new Transportation[ARRAY_CAPACITY];
    private static int transportationIndex = 0;

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
    public void printAll() {
        ArrayUtils.printArray(transportations);
    }
}
