package com.Epam.JavaCore.hw7_16_12_19.cargo.repo.impl;

import com.Epam.JavaCore.hw7_16_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw7_16_12_19.cargo.repo.CargoArrayRepo;
import com.Epam.JavaCore.hw7_16_12_19.common.solutions.utils.ArrayUtils;
import com.Epam.JavaCore.hw7_16_12_19.storage.IdGenerator;


import java.util.Objects;

import static com.Epam.JavaCore.hw7_16_12_19.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static com.Epam.JavaCore.hw7_16_12_19.storage.Storage.*;

public class CargoArrayRepoImpl implements CargoArrayRepo {

  private static final Cargo[] EMPTY_CARGO_ARRAY = new Cargo[0];

  @Override
  public void add(Cargo cargo) {
    if (cargoIndex == cargosArray.length) {
      Cargo[] newCargos = new Cargo[cargosArray.length * 2];
      ArrayUtils.copyArray(cargosArray, newCargos);
      cargosArray = newCargos;
    }

    cargo.setId(IdGenerator.generateId());
    cargosArray[cargoIndex] = cargo;
    cargoIndex++;
  }

  @Override
  public Cargo getById(long id) {
    for (Cargo cargo : cargosArray) {
      if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
        return cargo;
      }
    }

    return null;
  }

  @Override
  public Cargo[] getByName(String name) {
    Cargo[] searchResultWithNullableElems = getByNameIncludingNullElements(name);
    if (searchResultWithNullableElems == null
            || searchResultWithNullableElems.length == 0) {
      return EMPTY_CARGO_ARRAY;
    } else {
      return excludeNullableElementsFromArray(searchResultWithNullableElems);
    }
  }

  private Cargo[] getByNameIncludingNullElements(String name) {
    Cargo[] result = new Cargo[cargosArray.length];

    int curIndex = 0;
    for (Cargo cargo : cargosArray) {
      if (cargo != null && Objects.equals(cargo.getName(), name)) {
        result[curIndex++] = cargo;
      }
    }

    return result;
  }
  private Cargo[] excludeNullableElementsFromArray(Cargo[] cargos) {
    int sizeOfArrWithNotNullElems = 0;

    for (Cargo cargo : cargos) {
      if (cargo != null) {
        sizeOfArrWithNotNullElems++;
      }
    }

    if (sizeOfArrWithNotNullElems == 0) {
      return EMPTY_CARGO_ARRAY;
    } else {
      Cargo[] result = new Cargo[sizeOfArrWithNotNullElems];
      int index = 0;
      for (Cargo cargo : cargos) {
        if (cargo != null) {
          result[index++] = cargo;
        }
      }

      return result;
    }
  }

  @Override
  public boolean deleteById(long id) {
    Integer indexToDelete = findEntityIndexInArrayStorageById(carriersArray, id);

    if (indexToDelete == null) {
      return false;
    } else {
      ArrayUtils.removeElement(cargosArray, indexToDelete);
      return true;
    }
  }
}
