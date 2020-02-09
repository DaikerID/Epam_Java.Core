package com.Epam.JavaCore.hw20_07_02_20.cargo.service;

import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.Cargo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.exception.unckecked.CargoDeleteConstraintViolationException;
import com.Epam.JavaCore.hw20_07_02_20.cargo.repo.CargoRepo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.search.CargoSearchCondition;
import com.Epam.JavaCore.hw20_07_02_20.transportation.domain.Transportation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
    public Optional<Cargo> findById(Long id) {
        if (id != null) {
            return Optional.ofNullable(cargoRepo.findById(id));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Cargo> getByIdFetchingTransportations(Long id) {
        if (id != null) {
            return Optional.ofNullable(cargoRepo.getByIdFetchingTransportations(id));
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<Cargo>> getAll() {
        return Optional.ofNullable(cargoRepo.getAll());
    }

    @Override
    public int countAll() {
        return this.cargoRepo.countAll();
    }

    @Override
    public Optional<List<Cargo>> findByName(String name) {
        Cargo[] found = cargoRepo.findByName(name);
        return (found == null || found.length == 0) ? Optional.empty() : Optional.of(Arrays.asList(found));
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Cargo> cargoOptional = this.getByIdFetchingTransportations(id);

        if (cargoOptional.isPresent()) {
            List<Transportation> transportations = cargoOptional.get().getTransportations();
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
    public Optional<List<Cargo>> filterBy(Predicate<Cargo> condition) {
        return Optional.ofNullable(cargoRepo.filterByOneCondition(condition));
    }

    @Override
    public <U> Optional<List<Cargo>> filterBy(U param, BiPredicate<Cargo, U> condition) {
        return Optional.ofNullable(cargoRepo.filterByTwoConditions(param,condition));
    }

    @Override
    public boolean update(Cargo cargo) {
        if (cargo != null) {
            return cargoRepo.update(cargo);
        }
        return false;
    }

    @Override
    public Optional<List<Cargo>> search(CargoSearchCondition cargoSearchCondition) {
        return Optional.ofNullable(cargoRepo.search(cargoSearchCondition));
    }
}
