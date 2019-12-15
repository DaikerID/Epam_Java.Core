package com.Epam.JavaCore.hw6_13_12_19;

import com.Epam.JavaCore.hw6_13_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw6_13_12_19.cargo.domain.MaterialCargo;
import com.Epam.JavaCore.hw6_13_12_19.storage.Storage;

public class Main {
    public static void main(String[] args) {

        Cargo sand = new MaterialCargo();
        sand.setName("sand");

        Cargo sand1 = new MaterialCargo();
        sand1.setName("sand");

        Cargo sand2 = new MaterialCargo();
        sand2.setName("sand");

        Cargo sand3 = new MaterialCargo();
        sand3.setName("sand");

        Cargo[] cargos = {sand1, sand2, sand3, sand};
        for (Cargo cargo : cargos) {
            Storage.addCargo(cargo);
        }

        System.out.println(Storage.getCargoById(1l));
        System.out.println("-----------------------------");
        cargos = Storage.getCargosByName("sand");
        for (Cargo cargo : cargos) {
                System.out.println(cargo);
        }
    }
}
