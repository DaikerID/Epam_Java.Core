package com.Epam.JavaCore.hw20_07_02_20.carrier.repo;

import com.Epam.JavaCore.hw20_07_02_20.carrier.domain.Carrier;
import com.Epam.JavaCore.hw20_07_02_20.common.business.repo.CommonRepo;

public interface CarrierRepo extends CommonRepo<Carrier, Long> {

    Carrier getByIdFetchingTransportations(long id);

    Carrier[] findByName(String name);

}
