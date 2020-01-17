package com.Epam.JavaCore.hw7_16_12_19.transportation.service.impl;

import com.Epam.JavaCore.hw7_16_12_19.transportation.domain.Transportation;
import com.Epam.JavaCore.hw7_16_12_19.transportation.repo.impl.TransportationArrayRepoImpl;
import com.Epam.JavaCore.hw7_16_12_19.transportation.repo.impl.TransportationCollectionRepoImpl;
import com.Epam.JavaCore.hw7_16_12_19.transportation.service.TransportationService;

public class TransportationServiceImpl implements TransportationService {

    TransportationArrayRepoImpl transportationArrayRepo = new TransportationArrayRepoImpl();
    TransportationCollectionRepoImpl transportationCollectionRepo = new TransportationCollectionRepoImpl();

    @Override
    public void add(Transportation transportation) {
        System.out.println("Begin tpo add transportation");
        transportationCollectionRepo.add(transportation);
        transportationArrayRepo.add(transportation);

    }

    @Override
    public Transportation getById(Long id) {
        if (id != null) {
            transportationArrayRepo.getById(id);
            transportationCollectionRepo.getById(id);
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if (transportationArrayRepo.deleteById(id))
            return true;
        else if (transportationCollectionRepo.deleteById(id))
            return true;
        return false;
    }
}
