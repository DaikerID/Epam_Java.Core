package com.Epam.JavaCore.hw8_18_12_19.cargo.service;

import com.Epam.JavaCore.hw8_18_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw8_18_12_19.common.business.service.CommonService;
import com.Epam.JavaCore.hw8_18_12_19.common.business.service.SortType;

import java.util.List;

public interface CargoService extends CommonService {
    void add(Cargo cargo);

    Cargo getById(Long id);

    List<Cargo> getAll();

    List<Cargo> getByName(String name);

    boolean update(Cargo updateCargo);

    public List<Cargo> getSorted(SortBy sortBy, SortType sortType);
}
