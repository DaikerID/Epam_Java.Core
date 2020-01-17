package com.Epam.JavaCore.hw8_18_12_19.cargo.repo;

import com.Epam.JavaCore.hw8_18_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw8_18_12_19.cargo.service.SortBy;
import com.Epam.JavaCore.hw8_18_12_19.common.business.repo.CommonRepo;
import com.Epam.JavaCore.hw8_18_12_19.common.business.service.SortType;

import java.util.List;

public interface CargoRepo extends CommonRepo {

    void add(Cargo cargo);

    Cargo getById(long id);

    Cargo[] getByName(String name);

    List<Cargo> getAll();

    boolean update(Cargo updateCargo);

    List<Cargo> getSorted(SortBy sortBy, SortType sortType);
}
