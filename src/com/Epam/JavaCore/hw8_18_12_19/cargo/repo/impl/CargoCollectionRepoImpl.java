package com.Epam.JavaCore.hw8_18_12_19.cargo.repo.impl;


import com.Epam.JavaCore.hw8_18_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw8_18_12_19.cargo.repo.CargoRepo;
import com.Epam.JavaCore.hw8_18_12_19.cargo.service.SortBy;
import com.Epam.JavaCore.hw8_18_12_19.common.business.service.SortType;
import com.Epam.JavaCore.hw8_18_12_19.storage.IdGenerator;

import java.util.*;

import static com.Epam.JavaCore.hw8_18_12_19.storage.Storage.cargoArray;
import static com.Epam.JavaCore.hw8_18_12_19.storage.Storage.cargoCollection;

public class CargoCollectionRepoImpl implements CargoRepo {

    @Override
    public void add(Cargo carrier) {
        carrier.setId(IdGenerator.generateId());
        cargoCollection.add(carrier);
    }

    @Override
    public Cargo getById(long id) {
        for (Cargo carrier : cargoCollection) {
            if (Long.valueOf(id).equals(carrier.getId())) {
                return carrier;
            }
        }

        return null;
    }

    @Override
    public Cargo[] getByName(String name) {
        List<Cargo> result = new ArrayList<>();

        for (Cargo cargo : cargoCollection) {
            if (Objects.equals(cargo.getName(), name)) {
                result.add(cargo);
            }
        }

        return result.toArray(new Cargo[0]);
    }

    @Override
    public List<Cargo> getAll() {
        return cargoCollection;
    }

    @Override
    public boolean update(Cargo updateCargo) {
        if (cargoCollection.contains(updateCargo)) {
            cargoCollection.set(cargoCollection.indexOf(updateCargo), updateCargo);
            return true;
        }
        return false;
    }

    @Override
    public List<Cargo> getSorted(SortBy sortBy, SortType sortType) {
        List<Cargo> sortedList = cargoCollection;
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
    public boolean deleteById(long id) {
        Iterator<Cargo> iter = cargoCollection.iterator();

        boolean removed = false;
        while (iter.hasNext()) {
            if (Long.valueOf(id).equals(iter.next().getId())) {
                iter.remove();
                removed = true;
                break;
            }
        }

        return removed;
    }
}
