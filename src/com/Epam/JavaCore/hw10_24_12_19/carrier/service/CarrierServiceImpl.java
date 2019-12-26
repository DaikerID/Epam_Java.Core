package com.Epam.JavaCore.hw10_24_12_19.carrier.service;

import com.Epam.JavaCore.hw10_24_12_19.carrier.exception.unchecked.CarrierDeleteConstraintViolationException;
import com.Epam.JavaCore.hw10_24_12_19.transportation.domain.Transportation;
import com.Epam.JavaCore.hw10_24_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw10_24_12_19.carrier.repo.CarrierRepo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarrierServiceImpl implements CarrierService {

  private CarrierRepo carrierRepo;

  public CarrierServiceImpl(
      CarrierRepo carrierRepo) {
    this.carrierRepo = carrierRepo;
  }

  @Override
  public void add(Carrier carrier) {
    carrierRepo.add(carrier);
  }

  @Override
  public Carrier getById(Long id) {
    if (id != null) {
      return carrierRepo.getById(id);
    }
    return null;
  }

  @Override
  public Carrier getByIdFetchingTransportations(Long id) {
    if (id != null) {
      return carrierRepo.getByIdFetchingTransportations(id);
    }
    return null;
  }

  @Override
  public List<Carrier> findByName(String name) {
    Carrier[] found = carrierRepo.findByName(name);
    return (found == null || found.length == 0) ? Collections.emptyList() : Arrays.asList(found);

  }

  @Override
  public List<Carrier> getAll() {
    return carrierRepo.getAll();
  }

  @Override
  public boolean deleteById(Long id) {
    Carrier carrier = this.getByIdFetchingTransportations(id);

    if (carrier != null) {
      List<Transportation> transportations = carrier.getTransportations();
      boolean hasTransportations = transportations != null && transportations.size() > 0;
      if (hasTransportations) {
        throw new CarrierDeleteConstraintViolationException(id);
      }

      return carrierRepo.deleteById(id);
    } else {
      return false;
    }
  }
  @Override
  public void printAll() {
    List<Carrier> carriers = carrierRepo.getAll();
    for (Carrier carrier : carriers) {
      System.out.println(carrier);
    }
  }

  @Override
  public void update(Carrier carrier) {
    if (carrier != null) {
      carrierRepo.update(carrier);
    }
  }
}
