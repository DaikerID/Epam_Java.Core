package com.Epam.JavaCore.hw7_16_12_19.cargo.repo;

import com.Epam.JavaCore.hw7_16_12_19.cargo.domain.Cargo;

import java.util.List;

public interface CargoCollectionRepo extends CargoRepo {

    List<Cargo> getByName(String name);
}
