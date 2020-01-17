package com.Epam.JavaCore.hw7_16_12_19.carrier.repo;

import com.Epam.JavaCore.hw7_16_12_19.carrier.domain.Carrier;

import java.util.List;

public interface CarrierCollectionRepo extends CarrierRepo{
    List<Carrier> getByName(String name);
}
