package com.Epam.JavaCore.hw7_16_12_19.carrier.repo;

import com.Epam.JavaCore.hw7_16_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw7_16_12_19.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo {
    void add(Carrier carrier);

    Carrier getById(long id);

}
