package com.Epam.JavaCore.hw6_13_12_19.carrier.service;


import com.Epam.JavaCore.hw6_13_12_19.carrier.domain.Carrier;

public interface CarrierService {
    void add(Carrier carrier);

    Carrier getById(long id);

    Carrier[] getByName(String name);

    void deleteById(Long id);

    void printAll();
}
