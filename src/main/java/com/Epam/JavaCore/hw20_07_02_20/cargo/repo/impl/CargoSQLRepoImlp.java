package com.Epam.JavaCore.hw20_07_02_20.cargo.repo.impl;

import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.Cargo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.repo.CargoRepo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.search.CargoSearchCondition;

import java.util.List;

public class CargoSQLRepoImlp implements CargoRepo {
    @Override
    public Cargo getByIdFetchingTransportations(long id) {
        return null;
    }

    @Override
    public Cargo[] findByName(String name) {
        return new Cargo[0];
    }

    @Override
    public List<Cargo> search(CargoSearchCondition cargoSearchCondition) {
        return null;
    }

    @Override
    public Cargo findById(Long aLong) {
        return null;
    }

    @Override
    public void save(Cargo entity) {

    }

    @Override
    public boolean update(Cargo entity) {
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }

    @Override
    public List<Cargo> getAll() {
        return null;
    }

    @Override
    public int countAll() {
        return 0;
    }
}
