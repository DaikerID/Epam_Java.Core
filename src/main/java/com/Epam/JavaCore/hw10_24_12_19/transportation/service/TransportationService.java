package com.Epam.JavaCore.hw10_24_12_19.transportation.service;


import com.Epam.JavaCore.hw10_24_12_19.common.business.service.CommonService;
import com.Epam.JavaCore.hw10_24_12_19.transportation.domain.Transportation;

import java.util.List;

public interface TransportationService extends CommonService {
  void add(Transportation transportation);

  Transportation getById(Long id);

  List<Transportation> getAll();

  void update(Transportation transportation);

}
