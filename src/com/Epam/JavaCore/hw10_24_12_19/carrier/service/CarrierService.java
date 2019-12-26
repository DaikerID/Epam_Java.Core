package com.Epam.JavaCore.hw10_24_12_19.carrier.service;

import com.Epam.JavaCore.hw10_24_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw10_24_12_19.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService {
  void add(Carrier carrier);

  Carrier getById(Long id);

  Carrier getByIdFetchingTransportations(Long id);

  List<Carrier> findByName(String name);

  List<Carrier> getAll();

  void update(Carrier carrier);

}
