package com.Epam.JavaCore.hw8_18_12_19.transportation.repo.impl;


import com.Epam.JavaCore.hw8_18_12_19.common.solutions.utils.ArrayUtils;
import com.Epam.JavaCore.hw8_18_12_19.storage.IdGenerator;
import com.Epam.JavaCore.hw8_18_12_19.transportation.domain.Transportation;
import com.Epam.JavaCore.hw8_18_12_19.transportation.repo.TransportationRepo;

import java.util.Arrays;
import java.util.List;

import static com.Epam.JavaCore.hw8_18_12_19.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static com.Epam.JavaCore.hw8_18_12_19.storage.Storage.*;
import static com.Epam.JavaCore.hw8_18_12_19.storage.Storage.carrierArray;

public class TransportationArrayRepoImpl implements TransportationRepo {

    @Override
    public void add(Transportation transportation) {
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
    public Transportation getById(long id) {
        for (Transportation transportation : transportationArray) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }

        return null;
    }

    @Override
    public boolean update(Transportation updateTransportatiom) {
        return ArrayUtils.updateElement(transportationArray, updateTransportatiom);
    }

    @Override
    public List<Transportation> getAll() {
        return Arrays.asList(transportationArray);
    }

    @Override
    public boolean deleteById(long id) {
        Integer indexToDelete = findEntityIndexInArrayStorageById(transportationArray, id);

        if (indexToDelete == null) {
            return false;
        } else {
            ArrayUtils.removeElement(transportationArray, indexToDelete);
            return true;
        }
    }
}
