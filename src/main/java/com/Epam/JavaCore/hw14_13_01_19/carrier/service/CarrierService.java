package com.Epam.JavaCore.hw14_13_01_19.carrier.service;

import com.Epam.JavaCore.hw14_13_01_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw14_13_01_19.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService<Carrier, Long> {

    Carrier getByIdFetchingTransportations(Long id);

    List<Carrier> findByName(String name);

}
