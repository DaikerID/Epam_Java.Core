package com.Epam.JavaCore.hw7_16_12_19.cargo.repo.impl;

import com.Epam.JavaCore.hw7_16_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw7_16_12_19.storage.IdGenerator;

import java.util.ArrayList;
import java.util.List;

import static com.Epam.JavaCore.hw7_16_12_19.storage.Storage.*;

public class CargoCollectionRepoImpl implements com.Epam.JavaCore.hw7_16_12_19.cargo.repo.CargoCollectionRepo {
    @Override
    public void add(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargoArrayList.add(cargo);
    }

    @Override
    public Cargo getById(long id) {
        for(Cargo cargo: cargoArrayList){
            if(Long.valueOf(id).equals(cargo.getId())){
                return cargo;
            }
        }
        return null;
    }

    @Override
    public List<Cargo> getByName(String name) {
        List<Cargo> cargosListByName = new ArrayList<>();
        for(Cargo cargo: cargoArrayList){
            if (cargo.getName().equals(name)){
                cargosListByName.add(cargo);
            }
        }
        return cargosListByName;
    }

    @Override
    public boolean deleteById(long id) {
        for(Cargo cargo: cargoArrayList){
            if(Long.valueOf(id).equals(cargo.getId())){
                cargoArrayList.remove(cargo);
                return  true;
            }
        }
        return false;
    }
}
