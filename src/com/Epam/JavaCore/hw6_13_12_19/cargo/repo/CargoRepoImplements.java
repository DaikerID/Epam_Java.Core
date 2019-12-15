package com.Epam.JavaCore.hw6_13_12_19.cargo.repo;

import com.Epam.JavaCore.hw6_13_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw6_13_12_19.common.utils.ArrayUtils;
import com.Epam.JavaCore.hw6_13_12_19.storage.IdGenerator;

import java.util.Objects;

public class CargoRepoImplements implements CargoRepo {
    private static final int ARRAY_CAPACITY = 10;

    private static Cargo[] cargos = new Cargo[ARRAY_CAPACITY];
    private static int cargoIndex = 0;

    @Override
    public void add(Cargo cargo) {
        cargo.setId(IdGenerator.generateId());
        cargos[cargoIndex] = cargo;
        cargoIndex++;

        if (cargoIndex % (ARRAY_CAPACITY - 1) == 0) {
            Cargo[] newCargos = new Cargo[cargoIndex + ARRAY_CAPACITY];
            ArrayUtils.copyArray(cargos, newCargos);
            cargos = newCargos;
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
        Cargo[] cleanResult = new Cargo[0];
        ArrayUtils.cutArray(result, cleanResult);
        return cleanResult;
    }

    @Override
    public void printAll() {
        ArrayUtils.printArray(cargos);
    }
}
