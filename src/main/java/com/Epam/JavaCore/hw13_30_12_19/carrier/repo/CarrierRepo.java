package com.Epam.JavaCore.hw13_30_12_19.carrier.repo;

import com.Epam.JavaCore.hw13_30_12_19.common.business.repo.CommonRepo;
import com.Epam.JavaCore.hw13_30_12_19.carrier.domain.Carrier;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

    Carrier getByIdFetchingTransportations(long id);

    Carrier[] findByName(String name);

}
