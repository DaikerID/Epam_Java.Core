package com.Epam.JavaCore.hw13_30_12_19.cargo.service;

import com.Epam.JavaCore.hw13_30_12_19.common.business.service.CommonService;
import com.Epam.JavaCore.hw13_30_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw13_30_12_19.cargo.search.CargoSearchCondition;

import java.util.List;

public interface CargoService extends CommonService<Cargo, Long> {

    Cargo getByIdFetchingTransportations(Long id);

    List<Cargo> findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}
