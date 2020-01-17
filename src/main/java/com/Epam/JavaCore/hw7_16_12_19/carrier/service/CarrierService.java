package com.Epam.JavaCore.hw7_16_12_19.carrier.service;

import com.Epam.JavaCore.hw7_16_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw7_16_12_19.common.business.service.CommonService;

public interface CarrierService extends CommonService {
    void add(Carrier carrier);

    Carrier getById(Long id);
}
