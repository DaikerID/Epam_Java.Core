package com.Epam.JavaCore.hw6_13_12_19.transportation.service;

import com.Epam.JavaCore.hw6_13_12_19.transportation.domain.Transportation;

public interface TransportationService {
    void add(Transportation cargo);
    Transportation getById(long id);
    void printAll();
}
