package com.Epam.JavaCore.hw7_16_12_19.cargo.repo;


import com.Epam.JavaCore.hw7_16_12_19.cargo.domain.Cargo;

public interface CargoArrayRepo extends CargoRepo {

    Cargo[] getByName(String name);
}
