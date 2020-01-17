package com.Epam.JavaCore.hw10_24_12_19.transportation.repo;

import com.Epam.JavaCore.hw10_24_12_19.common.business.repo.CommonRepo;
import com.Epam.JavaCore.hw10_24_12_19.transportation.domain.Transportation;

import java.util.List;

public interface TransportationRepo extends CommonRepo {
    void add(Transportation transportation);

    Transportation getById(long id);

    List<Transportation> getAll();

    void update(Transportation transportation);
}
