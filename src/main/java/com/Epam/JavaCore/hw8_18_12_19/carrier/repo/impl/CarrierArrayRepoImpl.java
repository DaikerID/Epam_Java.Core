package com.Epam.JavaCore.hw8_18_12_19.carrier.repo.impl;


import com.Epam.JavaCore.hw8_18_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw8_18_12_19.carrier.repo.CarrierRepo;
import com.Epam.JavaCore.hw8_18_12_19.common.solutions.utils.ArrayUtils;
import com.Epam.JavaCore.hw8_18_12_19.storage.IdGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.Epam.JavaCore.hw8_18_12_19.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static com.Epam.JavaCore.hw8_18_12_19.storage.Storage.*;
import static com.Epam.JavaCore.hw8_18_12_19.storage.Storage.cargoArray;

public class CarrierArrayRepoImpl implements CarrierRepo {

    private static final Carrier[] EMPTY_CARRIER_ARRAY = new Carrier[0];

    @Override
    public void add(Carrier carrier) {
        if (carrierIndex == carrierArray.length) {
            Carrier[] newCarriers = new Carrier[carrierArray.length * 2];
            ArrayUtils.copyArray(carrierArray, newCarriers);
            carrierArray = newCarriers;
        }

        carrier.setId(IdGenerator.generateId());
        carrierArray[carrierIndex] = carrier;
        carrierIndex++;
    }

    @Override
    public Carrier getById(long id) {
        for (Carrier carrier : carrierArray) {
            if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
                return carrier;
            }
        }

        return null;
    }

    @Override
    public Carrier[] getByName(String name) {
        Carrier[] searchResultWithNullableElems = getByNameIncludingNullElements(name);
        if (searchResultWithNullableElems == null || searchResultWithNullableElems.length == 0) {
            return EMPTY_CARRIER_ARRAY;
        } else {
            return excludeNullableElementsFromArray(searchResultWithNullableElems);
        }
    }

    private Carrier[] getByNameIncludingNullElements(String name) {
        Carrier[] result = new Carrier[carrierArray.length];

        int curIndex = 0;
        for (Carrier carrier : carrierArray) {
            if (carrier != null && Objects.equals(carrier.getName(), name)) {
                result[curIndex++] = carrier;
            }
        }

        return result;
    }


    private Carrier[] excludeNullableElementsFromArray(Carrier[] carriers) {
        int sizeOfArrWithNotNullElems = 0;

        for (Carrier carrier : carriers) {
            if (carrier != null) {
                sizeOfArrWithNotNullElems++;
            }
        }

        if (sizeOfArrWithNotNullElems == 0) {
            return EMPTY_CARRIER_ARRAY;
        } else {
            Carrier[] result = new Carrier[sizeOfArrWithNotNullElems];
            int index = 0;
            for (Carrier carrier : carriers) {
                if (carrier != null) {
                    result[index++] = carrier;
                }
            }

            return result;
        }
    }

    @Override
    public boolean deleteById(long id) {
        Integer indexToDelete = findEntityIndexInArrayStorageById(carrierArray, id);

        if (indexToDelete == null) {
            return false;
        } else {
            ArrayUtils.removeElement(carrierArray, indexToDelete);
            return true;
        }
    }

    @Override
    public List<Carrier> getAll() {
        return Arrays.asList(carrierArray);
    }

    @Override
    public boolean update(Carrier updateCarrier) {
        return ArrayUtils.updateElement(carrierArray, updateCarrier);
    }
}
