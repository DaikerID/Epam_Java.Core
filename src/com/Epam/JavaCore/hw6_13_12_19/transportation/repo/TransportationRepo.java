package com.Epam.JavaCore.hw6_13_12_19.transportation.repo;

import com.Epam.JavaCore.hw6_13_12_19.transportation.domain.Transportation;

public interface TransportationRepo {
    void add(Transportation cargo);
    Transportation getById(long id);
    void printAll();
}
