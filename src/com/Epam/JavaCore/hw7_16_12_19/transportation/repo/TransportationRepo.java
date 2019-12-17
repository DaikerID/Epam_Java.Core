package com.Epam.JavaCore.hw7_16_12_19.transportation.repo;


import com.Epam.JavaCore.hw7_16_12_19.common.business.repo.CommonRepo;
import com.Epam.JavaCore.hw7_16_12_19.transportation.domain.Transportation;

public interface TransportationRepo extends CommonRepo {
    void add(Transportation transportation);

    Transportation getById(long id);
}
