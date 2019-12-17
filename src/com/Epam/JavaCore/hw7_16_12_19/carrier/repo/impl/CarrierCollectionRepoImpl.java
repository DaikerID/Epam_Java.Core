package com.Epam.JavaCore.hw7_16_12_19.carrier.repo.impl;

import com.Epam.JavaCore.hw7_16_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw7_16_12_19.carrier.repo.CarrierCollectionRepo;
import com.Epam.JavaCore.hw7_16_12_19.storage.IdGenerator;

import java.util.ArrayList;
import java.util.List;

import static com.Epam.JavaCore.hw7_16_12_19.storage.Storage.carrierArrayList;

public class CarrierCollectionRepoImpl implements CarrierCollectionRepo {

    @Override
    public void add(Carrier carrier) {
        carrier.setId(IdGenerator.generateId());
        carrierArrayList.add(carrier);
    }

    @Override
    public Carrier getById(long id) {
        for(Carrier carrier: carrierArrayList){
            if(Long.valueOf(id).equals(carrier.getId())){
                return carrier;
            }
        }
        return null;
    }

    @Override
    public List<Carrier> getByName(String name) {
        List<Carrier> carriersListByName = new ArrayList<>();
        for(Carrier carrier: carrierArrayList){
            if (carrier.getName().equals(name)){
                carriersListByName.add(carrier);
            }
        }
        return carriersListByName;
    }

    @Override
    public boolean deleteById(long id) {
        for(Carrier carrier: carrierArrayList){
            if(Long.valueOf(id).equals(carrier.getId())){
                carrierArrayList.remove(carrier);
                return  true;
            }
        }
        return false;
    }
}
