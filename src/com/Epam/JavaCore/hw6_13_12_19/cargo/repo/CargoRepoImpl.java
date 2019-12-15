package com.Epam.JavaCore.hw6_13_12_19.cargo.repo;

import com.Epam.JavaCore.hw6_13_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw6_13_12_19.common.utils.ArrayUtils;
import com.Epam.JavaCore.hw6_13_12_19.storage.IdGenerator;
import com.Epam.JavaCore.hw6_13_12_19.storage.Storage;

import java.util.Objects;

public class CargoRepoImpl extends Storage implements CargoRepo {

    @Override
    public void add(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        Storage.cargos[cargoIndex] = cargo;
        cargoIndex++;

        if (cargoIndex % (ARRAY_CAPACITY - 1) == 0) {
            Cargo[] newCargos = new Cargo[cargoIndex + ARRAY_CAPACITY];
            ArrayUtils.copyArray(cargos, newCargos);
            cargos = newCargos;
        }
    }

    @Override
    public void deleteById(Long id) {
        for (int i = 0; i < cargos.length; i++) {
            if (cargos[i].getId().equals(id)) {
                cargos = (Cargo[]) ArrayUtils.cutArrayWithout(cargos, i);
            }
        }
    }

    @Override
    public Cargo getById(long id) {
        for (Cargo cargo : cargos) {
            if (cargo != null && Long.valueOf(id).equals(cargo.getId())) {
                return cargo;
            }
        }
        return null;
    }

    @Override
    public Cargo[] getByName(String name) {
        Cargo[] result = new Cargo[cargos.length];

        int curIndex = 0;
        for (Cargo cargo : cargos) {
            if (cargo != null && Objects.equals(cargo.getName(), name)) {
                result[curIndex++] = cargo;
            }
        }

        return (Cargo[]) ArrayUtils.excludeNullableElems(result, cargoIndex);
    }

    @Override
    public void printAll() {
        ArrayUtils.printArray(cargos);
    }
}
