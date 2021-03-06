package com.Epam.JavaCore.hw16_24_01_20.cargo.service;

import com.Epam.JavaCore.hw16_24_01_20.cargo.domain.Cargo;
import com.Epam.JavaCore.hw16_24_01_20.cargo.exception.unckecked.CargoDeleteConstraintViolationException;
import com.Epam.JavaCore.hw16_24_01_20.cargo.repo.CargoRepo;
import com.Epam.JavaCore.hw16_24_01_20.cargo.search.CargoSearchCondition;
import com.Epam.JavaCore.hw16_24_01_20.transportation.domain.Transportation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class CargoServiceImpl implements CargoService {

    private CargoRepo cargoRepo;

    public CargoServiceImpl(CargoRepo cargoRepo) {
        this.cargoRepo = cargoRepo;
    }

    @Override
    public void save(Cargo cargo) {
        cargoRepo.save(cargo);
    }

    @Override
    public Cargo findById(Long id) {
        if (id != null) {
            return cargoRepo.findById(id);
        }
        return null;
    }

    @Override
    public Cargo getByIdFetchingTransportations(Long id) {
        if (id != null) {
            return cargoRepo.getByIdFetchingTransportations(id);
        }
        return null;
    }

    @Override
    public List<Cargo> getAll() {
        return cargoRepo.getAll();
    }

    @Override
    public int countAll() {
        return this.cargoRepo.countAll();
    }

    @Override
    public List<Cargo> findByName(String name) {
        Cargo[] found = cargoRepo.findByName(name);
        return (found == null || found.length == 0) ? Collections.emptyList() : Arrays.asList(found);
    }

    @Override
    public boolean deleteById(Long id) {
        Cargo cargo = this.getByIdFetchingTransportations(id);

        if (cargo != null) {
            List<Transportation> transportations = cargo.getTransportations();
            boolean hasTransportations = transportations != null && transportations.size() > 0;
            if (hasTransportations) {
                throw new CargoDeleteConstraintViolationException(id);
            }

            return cargoRepo.deleteById(id);
        } else {
            return false;
        }
    }

    @Override
    public void printAll() {
        List<Cargo> allCargos = cargoRepo.getAll();

        for (Cargo cargo : allCargos) {
            System.out.println(cargo);
        }
    }

    @Override
    public List<Cargo> filterBy(Predicate<Cargo> condition) {
        return cargoRepo.filterByOneCondition(condition);
    }

    @Override
    public <U> List<Cargo> filterBy(U param, BiPredicate<Cargo, U> condition) {
        return cargoRepo.filterByTwoConditions(param,condition);
    }

    @Override
    public boolean update(Cargo cargo) {
        if (cargo != null) {
            return cargoRepo.update(cargo);
        }
        return false;
    }

    @Override
    public List<Cargo> search(CargoSearchCondition cargoSearchCondition) {
        return cargoRepo.search(cargoSearchCondition);
    }
}
