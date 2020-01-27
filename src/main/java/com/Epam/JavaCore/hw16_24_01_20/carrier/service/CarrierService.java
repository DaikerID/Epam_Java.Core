package com.Epam.JavaCore.hw16_24_01_20.carrier.service;

import com.Epam.JavaCore.hw16_24_01_20.carrier.domain.Carrier;
import com.Epam.JavaCore.hw16_24_01_20.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService<Carrier, Long> {

    Carrier getByIdFetchingTransportations(Long id);

    List<Carrier> findByName(String name);

}
