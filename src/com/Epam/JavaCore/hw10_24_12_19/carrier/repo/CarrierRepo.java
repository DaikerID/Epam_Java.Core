package com.Epam.JavaCore.hw10_24_12_19.carrier.repo;

import com.Epam.JavaCore.hw10_24_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw10_24_12_19.common.business.repo.CommonRepo;

import java.util.List;

public interface CarrierRepo extends CommonRepo {

  void add(Carrier carrier);

  Carrier getById(long id);

  Carrier getByIdFetchingTransportations(long id);

  Carrier[] findByName(String name);

  List<Carrier> getAll();

  void update(Carrier carrier);
}
