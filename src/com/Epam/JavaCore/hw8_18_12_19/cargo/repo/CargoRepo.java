package com.Epam.JavaCore.hw8_18_12_19.cargo.repo;

import com.Epam.JavaCore.hw8_18_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw8_18_12_19.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo {

    void add(Cargo cargo);

    Cargo getById(long id);

    Cargo[] getByName(String name);

    List<Cargo> getAll();

    boolean update(Cargo updateCargo);
}
