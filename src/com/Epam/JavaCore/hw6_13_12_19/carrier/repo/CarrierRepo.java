package com.Epam.JavaCore.hw6_13_12_19.carrier.repo;


import com.Epam.JavaCore.hw6_13_12_19.carrier.domain.Carrier;

public interface CarrierRepo {
    void add(Carrier carrier);

    Carrier getById(long id);

    Carrier[] getByName(String name);

    void deleteById(Long id);

    void printAll();
}
