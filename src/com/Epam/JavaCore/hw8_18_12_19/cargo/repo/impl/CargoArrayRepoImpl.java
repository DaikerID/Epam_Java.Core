package com.Epam.JavaCore.hw8_18_12_19.cargo.repo.impl;


import com.Epam.JavaCore.hw8_18_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw8_18_12_19.cargo.repo.CargoRepo;
import com.Epam.JavaCore.hw8_18_12_19.cargo.service.SortBy;
import com.Epam.JavaCore.hw8_18_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw8_18_12_19.common.business.service.SortType;
import com.Epam.JavaCore.hw8_18_12_19.common.solutions.utils.ArrayUtils;
import com.Epam.JavaCore.hw8_18_12_19.storage.IdGenerator;
import com.Epam.JavaCore.hw8_18_12_19.storage.Storage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static com.Epam.JavaCore.hw8_18_12_19.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static com.Epam.JavaCore.hw8_18_12_19.storage.Storage.cargoArray;
import static com.Epam.JavaCore.hw8_18_12_19.storage.Storage.cargoIndex;

public class CargoArrayRepoImpl implements CargoRepo {

    private static final Cargo[] EMPTY_CARGO_ARRAY = new Cargo[0];

    @Override
    public void add(Cargo cargo) {
        if (cargoIndex == cargoArray.length) {
            Cargo[] newCargos = new Cargo[cargoArray.length * 2];
            ArrayUtils.copyArray(cargoArray, newCargos);
            cargoArray = newCargos;
        }

        cargo.setId(IdGenerator.generateId());
        cargoArray[cargoIndex] = cargo;
        cargoIndex++;
    }

    @Override
    public Cargo getById(long id) {
        for (Cargo cargo : cargoArray) {
            if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
                return cargo;
            }
        }

        return null;
    }

    @Override
    public Cargo[] getByName(String name) {
        Cargo[] searchResultWithNullableElems = getByNameIncludingNullElements(name);
        if (searchResultWithNullableElems == null
                || searchResultWithNullableElems.length == 0) {
            return EMPTY_CARGO_ARRAY;
        } else {
            return excludeNullableElementsFromArray(searchResultWithNullableElems);
        }
    }

    private Cargo[] getByNameIncludingNullElements(String name) {
        Cargo[] result = new Cargo[cargoArray.length];

        int curIndex = 0;
        for (Cargo cargo : cargoArray) {
            if (cargo != null && Objects.equals(cargo.getName(), name)) {
                result[curIndex++] = cargo;
            }
        }

        return result;
    }

    private Cargo[] excludeNullableElementsFromArray(Cargo[] cargos) {
        int sizeOfArrWithNotNullElems = 0;

        for (Cargo cargo : cargos) {
            if (cargo != null) {
                sizeOfArrWithNotNullElems++;
            }
        }

        if (sizeOfArrWithNotNullElems == 0) {
            return EMPTY_CARGO_ARRAY;
        } else {
            Cargo[] result = new Cargo[sizeOfArrWithNotNullElems];
            int index = 0;
            for (Cargo cargo : cargos) {
                if (cargo != null) {
                    result[index++] = cargo;
                }
            }

            return result;
        }
    }

    @Override
    public boolean deleteById(long id) {
        Integer indexToDelete = findEntityIndexInArrayStorageById(cargoArray, id);

        if (indexToDelete == null) {
            return false;
        } else {
            ArrayUtils.removeElement(cargoArray, indexToDelete);
            return true;
        }
    }

    @Override
    public List<Cargo> getSorted(SortBy sortBy, SortType sortType) {
        List<Cargo> sortedList = Arrays.asList(cargoArray);
        sortedList.sort(new Comparator<Cargo>() {
            @Override
            public int compare(Cargo o1, Cargo o2) {
                int type = SortType.ASC.equals(sortType) ? 1 : -1;
                switch (sortBy) {
                    case NAME:
                        return type * o1.getName().compareTo(o2.getName());
                    case WEIGHT:
                        return type * Integer.compare(o1.getWeight(), o2.getWeight());
                    default:
                        int compareNames = o1.getName().compareTo(o2.getName());
                        return type * compareNames != 0 ? compareNames : Integer.compare(o1.getWeight(), o2.getWeight());
                }
            }
        });
        return sortedList;
    }

    @Override
    public List<Cargo> getAll() {
        return Arrays.asList(cargoArray);
    }

    @Override
    public boolean update(Cargo updateCargo) {
        return ArrayUtils.updateElement(cargoArray, updateCargo);
    }
}
