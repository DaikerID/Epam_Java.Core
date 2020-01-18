package com.Epam.JavaCore.hw14_13_01_20.application;

import com.Epam.JavaCore.hw14_13_01_20.carrier.domain.Carrier;
import com.Epam.JavaCore.hw14_13_01_20.cargo.domain.ClothersCargo;
import com.Epam.JavaCore.hw14_13_01_20.cargo.domain.FoodCargo;
import com.Epam.JavaCore.hw14_13_01_20.transportation.domain.Transportation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.Epam.JavaCore.hw14_13_01_20.common.business.domain.EnityUtill.*;

public class UnitTest {

    private Path file = null;

    @BeforeEach
    public void createTempFile() throws IOException {
        file = Files.createTempFile("test", "temp");
    }

    @AfterEach
    public void deleteTempFile() {
        deleteFile(file);
    }

    @Test
    public void singleFoodCargoSerialisationTest() throws Exception {
        FoodCargo foodCargo = genFoodCargo(new Random());
        serializeInFile(foodCargo);
        FoodCargo newFoodCargo = readSerializebleObjectFromFile();
        Assertions.assertTrue(areCargosEquals(foodCargo, newFoodCargo));
    }

    @Test
    public void singleClotherCargoSerialisationTest() throws Exception {
        ClothersCargo clothersCargo = genClothersCargo(new Random());
        serializeInFile(clothersCargo);
        ClothersCargo newClothersCargo = readSerializebleObjectFromFile();
        Assertions.assertTrue(areCargosEquals(clothersCargo, newClothersCargo));
    }

    @Test
    public void singleCarrierSerialisationTest() throws Exception {
        Carrier carrier = genCarrier(new Random());
        serializeInFile(carrier);
        Carrier newCarrier = readSerializebleObjectFromFile();
        Assertions.assertTrue(areCarriersEquals(carrier, newCarrier));
    }

    @Test
    public void singleTransportationSerialisationTest() throws Exception {
        Transportation transportation = genTransportation(new Random());
        serializeInFile(transportation);
        Transportation newTransportation = readSerializebleObjectFromFile();
        Assertions.assertTrue(areTransportationsEquals(transportation, newTransportation));
    }

    @Test
    public void listFoodCargoSerialisationTest() throws Exception{
        List<FoodCargo> foodCargoList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            foodCargoList.add(genFoodCargo(random));
        }
        serializeInFile(foodCargoList);
        List<FoodCargo> newFoodCargoList = readSerializebleObjectFromFile();
        Assertions.assertTrue(areCargosEquals(foodCargoList,newFoodCargoList));
    }

    @Test
    public void listCarrierSerialisationTest() throws Exception {
        List<Carrier> carrierArrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            carrierArrayList.add(genCarrier(random));
        }
        serializeInFile(carrierArrayList);
        List<Carrier> newCarrierArrayList = readSerializebleObjectFromFile();
        Assertions.assertTrue(areCarriersEquals(carrierArrayList, newCarrierArrayList));
    }

    @Test
    public void listTransportationSerialisationTest() throws Exception {
        List<Transportation> transportationArrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            transportationArrayList.add(genTransportation(random));
        }
        serializeInFile(transportationArrayList);
        List<Transportation> newTransportationArrayList = readSerializebleObjectFromFile();
        Assertions.assertTrue(areTransportationEquals(transportationArrayList, newTransportationArrayList));
    }

    public <T> void serializeInFile(T object) throws Exception {
        try (ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(file.toAbsolutePath().toString()))) {
            objectOutput.writeObject(object);
        }
    }

    public <T> T readSerializebleObjectFromFile() throws Exception {
        try (ObjectInput objectInput = new ObjectInputStream(new FileInputStream(file.toAbsolutePath().toString()))) {
            return (T) objectInput.readObject();
        }
    }

    private void deleteFile(Path path) {
        if (path != null && path.toFile().isFile()) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}