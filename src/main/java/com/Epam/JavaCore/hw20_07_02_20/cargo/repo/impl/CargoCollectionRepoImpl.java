package com.Epam.JavaCore.hw20_07_02_20.cargo.repo.impl;


import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.Cargo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.search.CargoSearchCondition;
import com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils.CollectionUtils;
import com.Epam.JavaCore.hw20_07_02_20.storage.IdGenerator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static com.Epam.JavaCore.hw20_07_02_20.storage.Storage.cargoCollection;


public class CargoCollectionRepoImpl extends CommonCargoRepo {

    @Override
    public Cargo getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Cargo[] findByName(String name) {
        List<Cargo> result = filterByTwoConditions(name, (cargo, cargoName) -> cargo.getName().equals(cargoName));
        return result.toArray(new Cargo[0]);
    }

    @Override
    public List<Cargo> search(CargoSearchCondition searchCondition) {
        List<Cargo> cargos = getAll();

        if (CollectionUtils.isNotEmpty(cargos)) {
            if (searchCondition.needSorting()) {
                Comparator<Cargo> cargoComparator = createCargoComparator(searchCondition);
                cargos.sort(searchCondition.isAscOrdering() ? cargoComparator : cargoComparator.reversed());
            }
        }

        return cargos;
    }

    @Override
    public Cargo findById(Long id) {
        for (Cargo carrier : cargoCollection) {
            if (id != null && id.equals(carrier.getId())) {
                return carrier;
            }
        }

        return null;
    }

    @Override
    public void save(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargoCollection.add(cargo);
    }

    @Override
    public boolean update(Cargo entity) {
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        Iterator<Cargo> iter = cargoCollection.iterator();

        boolean removed = false;
        while (iter.hasNext()) {
            if (id != null && id.equals(iter.next().getId())) {
                iter.remove();
                removed = true;
                break;
            }
        }

        return removed;
    }

    @Override
    public List<Cargo> getAll() {
        return cargoCollection;
    }

    @Override
    public int countAll() {
        return cargoCollection.size();
    }


}
