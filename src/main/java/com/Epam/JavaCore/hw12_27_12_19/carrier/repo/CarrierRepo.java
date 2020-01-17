package com.Epam.JavaCore.hw12_27_12_19.carrier.repo;

import com.Epam.JavaCore.hw12_27_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw12_27_12_19.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

    Carrier getByIdFetchingTransportations(long id);

    Carrier[] findByName(String name);

}
