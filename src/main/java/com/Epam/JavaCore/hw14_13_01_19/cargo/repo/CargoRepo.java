package com.Epam.JavaCore.hw14_13_01_19.cargo.repo;

import com.Epam.JavaCore.hw14_13_01_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw14_13_01_19.cargo.search.CargoSearchCondition;
import com.Epam.JavaCore.hw14_13_01_19.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo<Cargo, Long> {

    Cargo getByIdFetchingTransportations(long id);

    Cargo[] findByName(String name);

    List<Cargo> search(CargoSearchCondition cargoSearchCondition);
}
