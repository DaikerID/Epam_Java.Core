package com.Epam.JavaCore.hw16_24_01_20.transportation.service;

import com.Epam.JavaCore.hw16_24_01_20.transportation.domain.Transportation;
import com.Epam.JavaCore.hw16_24_01_20.transportation.repo.TransportationRepo;

import java.util.List;
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
    public List<Transportation> filterBy(Predicate<Transportation> condition) {
        return transportationRepo.filterByOneConition(condition);
    }

    @Override
    public <U> List<Transportation> filterBy(U param, BiPredicate<Transportation, U> condition) {
        return transportationRepo.filterByTwoConitions(param, condition);
    }

    @Override
    public void save(Transportation transportation) {
        transportationRepo.save(transportation);
    }

    @Override
    public Transportation findById(Long id) {
        return transportationRepo.findById(id);
    }

    @Override
    public List<Transportation> getAll() {
        return transportationRepo.getAll();
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
