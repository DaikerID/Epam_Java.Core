package com.Epam.JavaCore.hw7_16_12_19.transportation.repo.impl;

import com.Epam.JavaCore.hw7_16_12_19.storage.IdGenerator;
import com.Epam.JavaCore.hw7_16_12_19.transportation.domain.Transportation;
import com.Epam.JavaCore.hw7_16_12_19.transportation.repo.TransportationRepo;

import static com.Epam.JavaCore.hw7_16_12_19.storage.Storage.transportationArrayList;

public class TransportationCollectionRepoImpl implements TransportationRepo {
    @Override
    public void add(Transportation transportation) {
        transportation.setId(IdGenerator.generateId());
        transportationArrayList.add(transportation);
    }

    @Override
    public Transportation getById(long id) {
        for(Transportation transportation: transportationArrayList){
            if(Long.valueOf(id).equals(transportation.getId())){
                return transportation;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        for(Transportation transportation: transportationArrayList){
            if(Long.valueOf(id).equals(transportation.getId())){
                transportationArrayList.remove(transportation);
                return  true;
            }
        }
        return false;
    }
}
