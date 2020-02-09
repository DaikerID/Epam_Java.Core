package com.Epam.JavaCore.hw20_07_02_20.cargo.service;

import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.Cargo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.search.CargoSearchCondition;
import com.Epam.JavaCore.hw20_07_02_20.common.business.service.CommonService;

import java.util.List;
import java.util.Optional;

public interface CargoService extends CommonService<Cargo, Long> {

    Optional<Cargo> getByIdFetchingTransportations(Long id);

    Optional<List<Cargo>> findByName(String name);

    Optional<List<Cargo>> search(CargoSearchCondition cargoSearchCondition);
}
