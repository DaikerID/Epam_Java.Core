package com.Epam.JavaCore.hw7_16_12_19.carrier.repo.impl;

import com.Epam.JavaCore.hw7_16_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw7_16_12_19.carrier.repo.CarrierArrayRepo;
import com.Epam.JavaCore.hw7_16_12_19.common.solutions.utils.ArrayUtils;
import com.Epam.JavaCore.hw7_16_12_19.storage.IdGenerator;

import java.util.Objects;

import static com.Epam.JavaCore.hw7_16_12_19.common.business.repo.CommonRepoHelper.findEntityIndexInArrayStorageById;
import static com.Epam.JavaCore.hw7_16_12_19.storage.Storage.carrierIndex;
import static com.Epam.JavaCore.hw7_16_12_19.storage.Storage.carriersArray;


public class CarrierArrayRepoImpl implements CarrierArrayRepo {

  private static final Carrier[] EMPTY_CARRIER_ARRAY = new Carrier[0];

  @Override
  public void add(Carrier carrier) {
    if (carrierIndex == carriersArray.length) {
      Carrier[] newCarriers = new Carrier[carriersArray.length * 2];
      ArrayUtils.copyArray(carriersArray, newCarriers);
      carriersArray = newCarriers;
    }

    carrier.setId(IdGenerator.generateId());
    carriersArray[carrierIndex] = carrier;
    carrierIndex++;
  }

  @Override
  public Carrier getById(long id) {
    for (Carrier carrier : carriersArray) {
      if (carrier != null && Long.valueOf(id).equals(carrier.getId())) {
        return carrier;
      }
    }

    return null;
  }

  @Override
  public Carrier[] getByName(String name) {
    Carrier[] searchResultWithNullableElems = getByNameIncludingNullElements(name);
    if (searchResultWithNullableElems == null || searchResultWithNullableElems.length == 0) {
      return EMPTY_CARRIER_ARRAY;
    } else {
      return excludeNullableElementsFromArray(searchResultWithNullableElems);
    }
  }

  private Carrier[] getByNameIncludingNullElements(String name) {
    Carrier[] result = new Carrier[carriersArray.length];

    int curIndex = 0;
    for (Carrier carrier : carriersArray) {
      if (carrier != null && Objects.equals(carrier.getName(), name)) {
        result[curIndex++] = carrier;
      }
    }

    return result;
  }


  private Carrier[] excludeNullableElementsFromArray(Carrier[] carriers) {
    int sizeOfArrWithNotNullElems = 0;

    for (Carrier carrier : carriers) {
      if (carrier != null) {
        sizeOfArrWithNotNullElems++;
      }
    }

    if (sizeOfArrWithNotNullElems == 0) {
      return EMPTY_CARRIER_ARRAY;
    } else {
      Carrier[] result = new Carrier[sizeOfArrWithNotNullElems];
      int index = 0;
      for (Carrier carrier : carriers) {
        if (carrier != null) {
          result[index++] = carrier;
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
      ArrayUtils.removeElement(carriersArray, indexToDelete);
      return true;
    }
  }
}
