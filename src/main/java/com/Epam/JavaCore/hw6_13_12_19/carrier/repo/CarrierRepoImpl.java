package com.Epam.JavaCore.hw6_13_12_19.carrier.repo;


import com.Epam.JavaCore.hw6_13_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw6_13_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw6_13_12_19.common.utils.ArrayUtils;
import com.Epam.JavaCore.hw6_13_12_19.storage.IdGenerator;
import com.Epam.JavaCore.hw6_13_12_19.storage.Storage;

import java.util.Objects;

public class CarrierRepoImpl extends Storage implements CarrierRepo {

    @Override
    public void add(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carriers[carrierIndex] = carrier;
        carrierIndex++;

        if (carrierIndex % (ARRAY_CAPACITY - 1) == 0) {
            Carrier[] newCarriers = new Carrier[carrierIndex + ARRAY_CAPACITY];
            ArrayUtils.copyArray(carriers, newCarriers);
            carriers = newCarriers;
        }
    }

    @Override
    public Carrier getById(long id) {
        for (Carrier carrier : carriers) {
            if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
                return carrier;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        for (int i = 0; i < carriers.length; i++) {
            if (carriers[i].getId().equals(id)) {
                carriers = (Carrier[]) ArrayUtils.cutArrayWithout(carriers, i);
            }
        }
    }

    @Override
    public Carrier[] getByName(String name) {
        Carrier[] result = new Carrier[carriers.length];

        int curIndex = 0;
        for (Carrier carrier : carriers) {
            if (carrier != null && Objects.equals(carrier.getName(), name)) {
                result[curIndex++] = carrier;
            }
        }

        return (Carrier[]) ArrayUtils.excludeNullableElems(result, carrierIndex);
    }

    @Override
    public void printAll() {
        ArrayUtils.printArray(carriers);
    }
}
