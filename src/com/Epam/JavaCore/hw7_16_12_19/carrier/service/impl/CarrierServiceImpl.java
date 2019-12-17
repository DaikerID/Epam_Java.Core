package com.Epam.JavaCore.hw7_16_12_19.carrier.service.impl;

import com.Epam.JavaCore.hw7_16_12_19.cargo.repo.impl.CargoArrayRepoImpl;
import com.Epam.JavaCore.hw7_16_12_19.cargo.repo.impl.CargoCollectionRepoImpl;
import com.Epam.JavaCore.hw7_16_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw7_16_12_19.carrier.repo.impl.CarrierArrayRepoImpl;
import com.Epam.JavaCore.hw7_16_12_19.carrier.repo.impl.CarrierCollectionRepoImpl;
import com.Epam.JavaCore.hw7_16_12_19.carrier.service.CarrierService;

public class CarrierServiceImpl implements CarrierService {

   CarrierArrayRepoImpl carrierArrayRepo = new CarrierArrayRepoImpl();
   CarrierCollectionRepoImpl carrierCollectionRepo = new CarrierCollectionRepoImpl();

    @Override
    public void add(Carrier carrier) {
        System.out.println("Begin tpo add carrier");
        carrierArrayRepo.add(carrier);
        carrierCollectionRepo.add(carrier);
    }

    @Override
    public Carrier getById(Long id) {
        if (id != null) {
            carrierArrayRepo.getById(id);
            carrierCollectionRepo.getById(id);
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if (carrierCollectionRepo.deleteById(id))
            return true;
        else if (carrierArrayRepo.deleteById(id))
            return true;
        return false;
    }
}
