package com.Epam.JavaCore.hw4_9_12_19;

import com.Epam.JavaCore.hw4_9_12_19.cargo.Cargo;
import com.Epam.JavaCore.hw4_9_12_19.cargo.CargoType;
import com.Epam.JavaCore.hw4_9_12_19.carrier.Carrier;
import com.Epam.JavaCore.hw4_9_12_19.transportation.Transportation;

public class Main {
    public static void main(String[] args) {
        Cargo apple = new Cargo();
        apple.setName("apple");

        Cargo banana = new Cargo();
        banana.setName("banana");

        Cargo orange = new Cargo();
        orange.setName("orange");


        Carrier dhl = new Carrier();
        dhl.setName("DHL");

        Carrier fedEx = new Carrier();
        fedEx.setName("FedEx");

        Carrier ups = new Carrier();
        ups.setName("UPS");


        Transportation transportation1 = new Transportation();
        transportation1.setName("transportation1");

        Transportation transportation2 = new Transportation();
        transportation2.setName("transportation2");

        Transportation transportation3 = new Transportation();
        transportation3.setName("transportation3");

        Entity[] entities = {apple, banana, orange, dhl, fedEx, ups, transportation1, transportation2, transportation3};

        Storage storage = new Storage();

        storage.addCargo(apple);
        storage.addCargo(banana);
        storage.addCargo(orange);

        storage.addCarrier(dhl);
        storage.addCarrier(fedEx);
        storage.addCarrier(ups);

        storage.addTransportation(transportation1);
        storage.addTransportation(transportation2);
        storage.addTransportation(transportation3);


        Cargo[] cargos = storage.getCargos();
        Carrier[] carriers = storage.getCarriers();
        Transportation[] transportations = storage.getTransportations();

        System.out.println("Грузы");
        for (Cargo cargo : cargos) {
            if (cargo != null) {
                System.out.println(cargo.getId() + " " + cargo.getName());
            }
        }

        System.out.println("\nПеревозчики");
        for (Carrier carrier : carriers) {
            if (carrier != null) {
                System.out.println(carrier.getId() + " " + carrier.getName());
            }
        }

        System.out.println("\nПеревозки");
        for (Transportation transportation : transportations) {
            if (transportation != null) {
                System.out.println(transportation.getId() + " " + transportation.getName());
            }
        }
    }
}
