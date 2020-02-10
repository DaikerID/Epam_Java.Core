package com.Epam.JavaCore.hw20_07_02_20.carrier.repo.impl;

import com.Epam.JavaCore.hw20_07_02_20.carrier.domain.Carrier;
import com.Epam.JavaCore.hw20_07_02_20.carrier.domain.CarrierMapper;
import com.Epam.JavaCore.hw20_07_02_20.carrier.repo.CarrierRepo;
import com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils.db.utils.DbUtils;

import java.util.List;

import static com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils.db.utils.DbUtils.executeUpdate;

public class CarrierSQLRepoImpl implements CarrierRepo {
    @Override
    public Carrier getByIdFetchingTransportations(long id) {
        return findById(id);
    }

    @Override
    public Carrier[] findByName(String name) {
        return filterByTwoConditions(name, (cargo, cargoName) -> cargo.getName().equals(cargoName)).toArray(new Carrier[0]);
    }

    @Override
    public Carrier findById(Long aLong) {
        List<Carrier> carrierList = getAll();
        for (Carrier carrier : carrierList) {
            if (carrier.getId().equals(aLong)) {
                return carrier;
            }
        }
        return null;
    }

    @Override
    public void save(Carrier entity) {
        executeUpdate(
                "INSERT INTO CARRIER (ID, NAME, ADDRESS, ENTITY_TYPE) VALUES (?,?,?,?)",
                ps -> {
                    int i = 0;
                    ps.setLong(++i, entity.getId());
                    ps.setString(++i, entity.getName());
                    ps.setString(++i, entity.getAddress());
                    ps.setString(++i, String.valueOf(entity.getCarrierType()));
                }
        );
    }

    @Override
    public boolean update(Carrier entity) {
        return executeUpdate(
                "UPDATE CARRIER NAME = ? , ADDRESS = ?, ENTITY_TYPE = ? WHERE ID =?",
                ps -> {
                    int i = 0;
                    ps.setString(++i, entity.getName());
                    ps.setString(++i, entity.getAddress());
                    ps.setString(++i, String.valueOf(entity.getCarrierType()));
                    ps.setLong(++i, entity.getId());
                }
        ) == 1;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return executeUpdate("DELETE FROMM CARRIER WHERE ID = ?", ps -> {
            ps.setLong(1, aLong);
        }) == 1;
    }

    @Override
    public List<Carrier> getAll() {
        return DbUtils.selectAll("SELECT * FROM CARRIER",
                CarrierMapper::mapCarrier);
    }

    @Override
    public int countAll() {
        return getAll().size();
    }
}
