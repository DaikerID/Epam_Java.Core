package com.Epam.JavaCore.hw10_24_12_19.cargo.repo.impl;


import com.Epam.JavaCore.hw10_24_12_19.cargo.search.CargoSearchCondition;
import com.Epam.JavaCore.hw10_24_12_19.common.solutions.utils.CollectionUtils;
import com.Epam.JavaCore.hw10_24_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw10_24_12_19.storage.IdGenerator;

import java.util.*;

import static com.Epam.JavaCore.hw10_24_12_19.storage.Storage.cargoCollection;

public class CargoCollectionRepoImpl extends CommonCargoRepo {

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
  public Cargo getByIdFetchingTransportations(long id) {
    return getById(id);
  }

  @Override
  public Cargo[] findByName(String name) {
    List<Cargo> result = new ArrayList<>();

    for (Cargo carrier : cargoCollection) {
      if (Objects.equals(carrier.getName(), name)) {
        result.add(carrier);
      }
    }

    return result.toArray(new Cargo[0]);
  }

  @Override
  public List<Cargo> getAll() {
    return cargoCollection;
  }

  @Override
  public void update(Cargo cargo) {

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

  @Override
  public List<Cargo> search(CargoSearchCondition searchCondition) {
    List<Cargo> cargos = getAll();

    if (CollectionUtils.isNotEmpty(cargos)) {
      if (searchCondition.needSorting()) {
        Comparator<Cargo> cargoComparator = createCargoComparator(searchCondition);
        cargos.sort(searchCondition.isAscOrdering() ? cargoComparator : cargoComparator.reversed());
      }
    }

    return cargos;
  }


}
