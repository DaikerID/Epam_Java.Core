package com.Epam.JavaCore.hw7_16_12_19.cargo.service.impl;


import com.Epam.JavaCore.hw7_16_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw7_16_12_19.cargo.repo.impl.CargoArrayRepoImpl;
import com.Epam.JavaCore.hw7_16_12_19.cargo.repo.impl.CargoCollectionRepoImpl;
import com.Epam.JavaCore.hw7_16_12_19.cargo.service.CargoService;

public class CargoServiceImpl implements CargoService {

    CargoArrayRepoImpl cargoArrayRepo = new CargoArrayRepoImpl();
    CargoCollectionRepoImpl cargoCollectionRepo = new CargoCollectionRepoImpl();

    @Override
    public void add(Cargo cargo) {
        System.out.println("Begin tpo add cargo");
        cargoArrayRepo.add(cargo);
        cargoCollectionRepo.add(cargo);

    }

    @Override
    public Cargo getById(Long id) {
        if (id != null) {
            cargoCollectionRepo.getById(id);
            cargoArrayRepo.getById(id);
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if (cargoArrayRepo.deleteById(id))
            return true;
        else if (cargoCollectionRepo.deleteById(id))
            return true;
        return false;
    }
}
