package com.Epam.JavaCore.hw18_29_01_20.transportation.repo.impl;


import com.Epam.JavaCore.hw18_29_01_20.common.solutions.utils.ArrayUtils;
import com.Epam.JavaCore.hw18_29_01_20.storage.IdGenerator;
import com.Epam.JavaCore.hw18_29_01_20.transportation.domain.Transportation;
import com.Epam.JavaCore.hw18_29_01_20.transportation.repo.TransportationRepo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.Epam.JavaCore.hw18_29_01_20.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static com.Epam.JavaCore.hw18_29_01_20.storage.Storage.transportationArray;
import static com.Epam.JavaCore.hw18_29_01_20.storage.Storage.transportationIndex;

public class TransportationArrayRepoImpl implements TransportationRepo {

    private static final Transportation[] EMPTY_TRANSPORTATION_ARRAY = new Transportation[0];

    @Override
    public void save(Transportation transportation) {
        if (transportationIndex == transportationArray.length) {
            Transportation[] newTransportations =
                    new Transportation[transportationArray.length * 2];
            ArrayUtils.copyArray(transportationArray, newTransportations);
            transportationArray = newTransportations;
        }

        transportation.setId(IdGenerator.generateId());
        transportationArray[transportationIndex] = transportation;
        transportationIndex++;
    }

    @Override
    public Transportation findById(Long id) {
        for (Transportation transportation : transportationArray) {
            if (transportation != null && transportation.getId().equals(id)) {
                return transportation;
            }
        }

        return null;
    }

    @Override
    public List<Transportation> getAll() {
        Transportation[] transportations = excludeNullableElementsFromArray(transportationArray);
        return transportations.length == 0 ? Collections.emptyList()
                : Arrays.asList(transportationArray);
    }

    @Override
    public int countAll() {
        return getAll().size();
    }

    private Transportation[] excludeNullableElementsFromArray(Transportation[] transportations) {
        int sizeOfArrWithNotNullElems = 0;

        for (Transportation transportation : transportations) {
            if (transportation != null) {
                sizeOfArrWithNotNullElems++;
            }
        }

        if (sizeOfArrWithNotNullElems == 0) {
            return EMPTY_TRANSPORTATION_ARRAY;
        } else {
            Transportation[] result = new Transportation[sizeOfArrWithNotNullElems];
            int index = 0;
            for (Transportation transportation : transportations) {
                if (transportation != null) {
                    result[index++] = transportation;
                }
            }

            return result;
        }
    }


    @Override
    public boolean update(Transportation transportation) {
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        Integer indexToDelete = findEntityIndexInArrayStorageById(transportationArray, id);

        if (indexToDelete == null) {
            return false;
        } else {
            ArrayUtils.removeElement(transportationArray, indexToDelete);
            return true;
        }
    }
}
