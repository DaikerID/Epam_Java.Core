package com.Epam.JavaCore.hw20_07_02_20.cargo.repo.impl;

import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.Cargo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.CargoMapper;
import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.ClothersCargo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.FoodCargo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.repo.CargoRepo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.search.CargoSearchCondition;
import com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils.CollectionUtils;
import com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils.db.utils.DbUtils;

import java.util.Collections;
import java.util.List;

import static com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils.db.utils.DbUtils.executeUpdate;

public class CargoSQLRepoImlp implements CargoRepo {
    @Override
    public Cargo getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Cargo[] findByName(String name) {
        return filterByTwoConditions(name, (cargo, cargoName) -> cargo.getName().equals(cargoName)).toArray(new Cargo[0]);
    }

    @Override
    public List<Cargo> search(CargoSearchCondition cargoSearchCondition) {
        return null;
    }

    @Override
    public Cargo findById(Long aLong) {
        List<Cargo> cargoList = getAll();
        for (Cargo cargo : cargoList) {
            if (cargo.getId().equals(aLong)) {
                return cargo;
            }
        }
        return null;
    }

    @Override
    public void save(Cargo entity) {
        executeUpdate(
                "INSERT INTO CARGO (ID, NAME, WEIGHT, ENTITY_TYPE, " +
                        "CLOTHERS_SIZE, CLOTHERS_MATERIAL, FOOD_EXPIRATION_DATE, " +
                        "FOOD_STORE_TEMPERATURE) VALUES (?,?,?,?,?,?,?,?)",
                ps -> {
                    int i = 0;
                    ps.setLong(++i, entity.getId());
                    ps.setString(++i, entity.getName());
                    ps.setInt(++i, entity.getWeight());
                    ps.setString(++i, String.valueOf(entity.getCargoType()));
                    switch (entity.getCargoType()) {
                        case CLOTHERS:
                            ClothersCargo clothersCargo = (ClothersCargo) entity;
                            ps.setString(++i, clothersCargo.getSize());
                            ps.setString(++i, clothersCargo.getMaterial());
                            break;
                        default:
                            FoodCargo foodCargo = (FoodCargo) entity;
                            i += 2;
                            ps.setString(++i, foodCargo.getExpirationDate().toString());
                            ps.setInt(++i, foodCargo.getStoreTemperature());
                    }
                }
        );
    }

    @Override
    public boolean update(Cargo entity) {
        int affectedRows = executeUpdate(
                "UPDATE CARGO NAME = ? , WEIGHT = ?, ENTITY_TYPE = ?, " +
                        "CLOTHERS_SIZE = ?, CLOTHERS_MATERIAL = ?, FOOD_EXPIRATION_DATE = ?, " +
                        "FOOD_STORE_TEMPERATURE = ?) VALUES (?,?,?,?,?,?,?,?) WHERE ID =?",
                ps -> {
                    int i = 0;

                    ps.setString(++i, entity.getName());
                    ps.setInt(++i, entity.getWeight());
                    ps.setString(++i, String.valueOf(entity.getCargoType()));
                    switch (entity.getCargoType()) {
                        case CLOTHERS:
                            ClothersCargo clothersCargo = (ClothersCargo) entity;
                            ps.setString(++i, clothersCargo.getSize());
                            ps.setString(++i, clothersCargo.getMaterial());
                            break;
                        default:
                            FoodCargo foodCargo = (FoodCargo) entity;
                            i += 2;
                            ps.setString(++i, foodCargo.getExpirationDate().toString());
                            ps.setInt(++i, foodCargo.getStoreTemperature());
                    }
                    ps.setLong(++i, entity.getId());
                }
        );
        return affectedRows == 1;
    }

    @Override
    public boolean deleteById(Long aLong) {
        int affectedRows = executeUpdate("DELETE FROMM CARGO WHERE ID = ?", ps -> {
            ps.setLong(1, aLong);
        });
        return affectedRows == 1;
    }

    @Override
    public List<Cargo> getAll() {
        return DbUtils.selectAll("SELECT * FROM CARGO",
                CargoMapper::mapCargo);
    }

    @Override
    public int countAll() {
        return getAll().size();
    }
}
