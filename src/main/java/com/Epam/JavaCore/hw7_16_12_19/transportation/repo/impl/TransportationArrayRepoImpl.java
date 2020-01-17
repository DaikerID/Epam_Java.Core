package com.Epam.JavaCore.hw7_16_12_19.transportation.repo.impl;

import com.Epam.JavaCore.hw7_16_12_19.common.solutions.utils.ArrayUtils;
import com.Epam.JavaCore.hw7_16_12_19.storage.IdGenerator;
import com.Epam.JavaCore.hw7_16_12_19.storage.Storage;
import com.Epam.JavaCore.hw7_16_12_19.transportation.domain.Transportation;
import com.Epam.JavaCore.hw7_16_12_19.transportation.repo.TransportationRepo;

import static com.Epam.JavaCore.hw7_16_12_19.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static com.Epam.JavaCore.hw7_16_12_19.storage.Storage.*;

public class TransportationArrayRepoImpl implements TransportationRepo {

    @Override
    public void add(Transportation transportation) {
        if (transportationIndex == Storage.transportationsArray.length) {
            Transportation[] newTransportations =
                    new Transportation[Storage.transportationsArray.length * 2];
            ArrayUtils.copyArray(Storage.transportationsArray, newTransportations);
            Storage.transportationsArray = newTransportations;
        }

        transportation.setId(IdGenerator.generateId());
        Storage.transportationsArray[transportationIndex] = transportation;
        transportationIndex++;
    }

    @Override
    public Transportation getById(long id) {
        for (Transportation transportation : Storage.transportationsArray) {
            if (transportation != null && Long.valueOf(id).equals(transportation.getId())) {
                return transportation;
            }
        }

        return null;
    }

    @Override
    public boolean deleteById(long id) {
        Integer indexToDelete = findEntityIndexInArrayStorageById(transportationsArray, id);

        if (indexToDelete == null) {
            return false;
        } else {
            ArrayUtils.removeElement(transportationsArray, indexToDelete);
            return true;
        }
    }
}

