package com.Epam.JavaCore.hw13_30_12_19.carrier.service;

import com.Epam.JavaCore.hw13_30_12_19.common.business.service.CommonService;
import com.Epam.JavaCore.hw13_30_12_19.carrier.domain.Carrier;

import java.util.List;

public interface CarrierService extends CommonService<Carrier, Long> {

    Carrier getByIdFetchingTransportations(Long id);

    List<Carrier> findByName(String name);

}
