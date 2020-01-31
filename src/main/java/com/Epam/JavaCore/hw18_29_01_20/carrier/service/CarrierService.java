package com.Epam.JavaCore.hw18_29_01_20.carrier.service;

import com.Epam.JavaCore.hw18_29_01_20.carrier.domain.Carrier;
import com.Epam.JavaCore.hw18_29_01_20.common.business.service.CommonService;

import java.util.List;
import java.util.Optional;

public interface CarrierService extends CommonService<Carrier, Long> {

    Optional<Carrier> getByIdFetchingTransportations(Long id);

    Optional<List<Carrier>> findByName(String name);

}
