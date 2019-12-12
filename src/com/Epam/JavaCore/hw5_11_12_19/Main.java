package com.Epam.JavaCore.hw5_11_12_19;

import com.Epam.JavaCore.hw5_11_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw5_11_12_19.cargo.domain.types.Animal;
import com.Epam.JavaCore.hw5_11_12_19.cargo.domain.types.Material;

public class Main {
    public static void main(String[] args) {
        Cargo cow = new Animal();
        cow.setName("Cow");
        Cargo cow2 = new Animal();
        cow2.setName("Cow");
        Cargo dog = new Animal();
        dog.setName("dog");
        Cargo sand = new Material();
        sand.setName("sand");

        Cargo[] cargos = {cow, cow2, dog, sand};
        for (Cargo cargo : cargos) {
            Storage.addCargo(cargo);
        }

        System.out.println(Storage.getCargoById(1l));
        cargos = Storage.getCargoByName("Cow");
        System.out.println("-----------------------------");
        for (Cargo cargo : cargos) {
            if (cargo != null) {
                System.out.println(cargo);
            }
        }
    }
}
