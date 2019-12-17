package com.Epam.JavaCore.hw7_16_12_19.cargo.repo;

import com.Epam.JavaCore.hw7_16_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw7_16_12_19.common.business.repo.CommonRepo;

public interface CargoRepo extends CommonRepo {
    void add(Cargo cargo);

    Cargo getById(long id);
}
