package com.Epam.JavaCore.hw8_18_12_19.cargo.service;


import com.Epam.JavaCore.hw8_18_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw8_18_12_19.cargo.repo.CargoRepo;
import com.Epam.JavaCore.hw8_18_12_19.common.business.service.SortType;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CargoServiceImpl implements CargoService {

    private CargoRepo cargoRepo;

    public CargoServiceImpl(CargoRepo cargoRepo) {
        this.cargoRepo = cargoRepo;
    }

    @Override
    public void add(Cargo cargo) {
        cargoRepo.add(cargo);
    }

    @Override
    public Cargo getById(Long id) {
        if (id != null) {
            return cargoRepo.getById(id);
        }
        return null;
    }

    @Override
    public List<Cargo> getAll() {
        return cargoRepo.getAll();
    }

    @Override
    public List<Cargo> getByName(String name) {
        Cargo[] found = cargoRepo.getByName(name);
        return (found == null || found.length == 0) ? Collections.emptyList() : Arrays.asList(found);
    }

    @Override
    public boolean update(Cargo updateCargo) {
        return cargoRepo.update(updateCargo);
    }

    @Override
    public boolean deleteById(Long id) {
        return cargoRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        List<Cargo> allCargos = cargoRepo.getAll();

        for (Cargo cargo : allCargos) {
            System.out.println(cargo);
        }
    }

    public List<Cargo> getSorted(SortBy sortBy, SortType sortType) {
        List<Cargo> sortedList = cargoRepo.getAll();
        sortedList.sort(new Comparator<Cargo>() {
            @Override
            public int compare(Cargo o1, Cargo o2) {
                int type = SortType.ASC.equals(sortType) ? 1 : -1;
                switch (sortBy) {
                    case NAME:
                        return type * o1.getName().compareTo(o2.getName());
                    case WEIGHT:
                        return type * Integer.compare(o1.getWeight(), o2.getWeight());
                    default:
                        int compareNames = o1.getName().compareTo(o2.getName());
                        return type * compareNames != 0 ? compareNames : Integer.compare(o1.getWeight(), o2.getWeight());
                }
            }
        });
        return sortedList;
    }
}
