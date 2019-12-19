package com.Epam.JavaCore.hw8_18_12_19.cargo.repo.impl;


import com.Epam.JavaCore.hw8_18_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw8_18_12_19.cargo.repo.CargoRepo;
import com.Epam.JavaCore.hw8_18_12_19.storage.IdGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
