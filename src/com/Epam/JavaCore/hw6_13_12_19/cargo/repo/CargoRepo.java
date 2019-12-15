package com.Epam.JavaCore.hw6_13_12_19.cargo.repo;

import com.Epam.JavaCore.hw6_13_12_19.cargo.domain.Cargo;

public interface CargoRepo {
    void add(Cargo cargo);

    void deleteById(Long id);

    Cargo getById(long id);

    Cargo[] getByName(String name);

    void printAll();
}
