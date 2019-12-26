package com.Epam.JavaCore.hw10_24_12_19.cargo.repo;

import com.Epam.JavaCore.hw10_24_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw10_24_12_19.cargo.search.CargoSearchCondition;
import com.Epam.JavaCore.hw10_24_12_19.common.business.repo.CommonRepo;

import java.util.List;

public interface CargoRepo extends CommonRepo {

  void add(Cargo cargo);

  Cargo getById(long id);

  Cargo getByIdFetchingTransportations(long id);

  Cargo[] findByName(String name);

  List<Cargo> getAll();

  List<Cargo> search(CargoSearchCondition cargoSearchCondition);

  void update(Cargo cargo);
}
