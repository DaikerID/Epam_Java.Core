package com.Epam.JavaCore.hw10_24_12_19.cargo.service;

import com.Epam.JavaCore.hw10_24_12_19.cargo.search.CargoSearchCondition;
import com.Epam.JavaCore.hw10_24_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw10_24_12_19.common.business.service.CommonService;

import java.util.List;

public interface CargoService extends CommonService {
    void add(Cargo cargo);

    Cargo getById(Long id);

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> getAll();

    List<Cargo> findByName(String name);

    void update(Cargo cargo);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}
