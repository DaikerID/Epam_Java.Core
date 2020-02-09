package com.Epam.JavaCore.hw20_07_02_20.transportation.service;

import com.Epam.JavaCore.hw20_07_02_20.transportation.domain.Transportation;
import com.Epam.JavaCore.hw20_07_02_20.transportation.repo.TransportationRepo;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class TransportationServiceImpl implements TransportationService {

    private TransportationRepo transportationRepo;

    public TransportationServiceImpl(
            TransportationRepo transportationRepo) {
        this.transportationRepo = transportationRepo;
    }

    @Override
    public boolean deleteById(Long id) {
        return transportationRepo.deleteById(id);
    }

    @Override
    public void printAll() {
        List<Transportation> allTransportations = transportationRepo.getAll();
        for (Transportation transportation : allTransportations) {
            System.out.println(transportation);
        }
    }

    @Override
    public Optional<List<Transportation>> filterBy(Predicate<Transportation> condition) {
        return Optional.ofNullable(transportationRepo.filterByOneCondition(condition));
    }

    @Override
    public <U> Optional<List<Transportation>> filterBy(U param, BiPredicate<Transportation, U> condition) {
        return Optional.ofNullable(transportationRepo.filterByTwoConditions(param, condition));
    }

    @Override
    public void save(Transportation transportation) {
        transportationRepo.save(transportation);
    }

    @Override
    public Optional<Transportation> findById(Long id) {
        return Optional.ofNullable(transportationRepo.findById(id));
    }

    @Override
    public Optional<List<Transportation>> getAll() {
        return Optional.ofNullable(transportationRepo.getAll());
    }

    @Override
    public boolean update(Transportation transportation) {
        if (transportation != null) {
            return transportationRepo.update(transportation);
        }

        return false;
    }

    @Override
    public int countAll() {
        return transportationRepo.countAll();
    }
}
