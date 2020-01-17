package com.Epam.JavaCore.hw7_16_12_19.transportation.service;

import com.Epam.JavaCore.hw7_16_12_19.common.business.service.CommonService;
import com.Epam.JavaCore.hw7_16_12_19.transportation.domain.Transportation;

public interface TransportationService extends CommonService {
    void add(Transportation transportation);

    Transportation getById(Long id);
}
