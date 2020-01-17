package com.Epam.JavaCore.hw7_16_12_19.carrier.repo;


import com.Epam.JavaCore.hw7_16_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw7_16_12_19.common.business.repo.CommonRepo;

public interface CarrierArrayRepo extends CarrierRepo {

  Carrier[] getByName(String name);

}
