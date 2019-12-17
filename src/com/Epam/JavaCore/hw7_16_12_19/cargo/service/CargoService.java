package com.Epam.JavaCore.hw7_16_12_19.cargo.service;

import com.Epam.JavaCore.hw7_16_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw7_16_12_19.common.business.service.CommonService;

public interface CargoService extends CommonService {
    void add(Cargo cargo);

    Cargo getById(Long id);
}
