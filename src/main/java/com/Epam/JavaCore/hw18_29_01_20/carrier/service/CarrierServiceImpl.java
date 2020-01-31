package com.Epam.JavaCore.hw18_29_01_20.carrier.service;

import com.Epam.JavaCore.hw18_29_01_20.carrier.domain.Carrier;
import com.Epam.JavaCore.hw18_29_01_20.carrier.exception.unchecked.CarrierDeleteConstraintViolationException;
import com.Epam.JavaCore.hw18_29_01_20.carrier.repo.CarrierRepo;
import com.Epam.JavaCore.hw18_29_01_20.transportation.domain.Transportation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class CarrierServiceImpl implements CarrierService {

    private CarrierRepo carrierRepo;

    public CarrierServiceImpl(
            CarrierRepo carrierRepo) {
        this.carrierRepo = carrierRepo;
    }

    @Override
    public void save(Carrier carrier) {
        carrierRepo.save(carrier);
    }

    @Override
    public Optional<Carrier> findById(Long id) {
        if (id != null) {
            return Optional.ofNullable(carrierRepo.findById(id));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Carrier> getByIdFetchingTransportations(Long id) {
        if (id != null) {
            return Optional.ofNullable(carrierRepo.getByIdFetchingTransportations(id));
        }
        return  Optional.empty();
    }

    @Override
    public Optional<List<Carrier>> findByName(String name) {
        Carrier[] found = carrierRepo.findByName(name);

        return (found == null || found.length == 0) ? Optional.empty() : Optional.of(Arrays.asList(found));
    }

    @Override
    public Optional<List<Carrier>> getAll() {
        return Optional.ofNullable(carrierRepo.getAll());
    }

    @Override
    public int countAll() {
        return this.carrierRepo.countAll();
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Carrier> carrierOptional = this.getByIdFetchingTransportations(id);

        if (carrierOptional.isPresent()) {
            List<Transportation> transportations = carrierOptional.get().getTransportations();
            boolean hasTransportations = transportations != null && transportations.size() > 0;
            if (hasTransportations) {
                throw new CarrierDeleteConstraintViolationException(id);
            }

            return carrierRepo.deleteById(id);
        } else {
            return false;
        }
    }

    @Override
    public void printAll() {
        List<Carrier> carriers = carrierRepo.getAll();
        for (Carrier carrier : carriers) {
            System.out.println(carrier);
        }
    }

    @Override
    public Optional<List<Carrier>> filterBy(Predicate<Carrier> condition) {
        return Optional.ofNullable(carrierRepo.filterByOneCondition(condition));
    }

    @Override
    public <U> Optional<List<Carrier>> filterBy(U param, BiPredicate<Carrier, U> condition) {
        return Optional.ofNullable(carrierRepo.filterByTwoConditions(param, condition));
    }

    @Override
    public boolean update(Carrier carrier) {
        if (carrier != null) {
            carrierRepo.update(carrier);
        }

        return false;
    }
}
