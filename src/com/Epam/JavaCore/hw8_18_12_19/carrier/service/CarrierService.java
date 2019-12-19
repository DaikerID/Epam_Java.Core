package com.Epam.JavaCore.hw8_18_12_19.carrier.service;

import com.Epam.JavaCore.hw8_18_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw8_18_12_19.common.business.service.CommonService;

import java.util.List;

public interface CarrierService extends CommonService {
    void add(Carrier carrier);

    Carrier getById(Long id);

    List<Carrier> getByName(String name);

    List<Carrier> getAll();

    boolean update(Carrier carrier);

}
