package com.Epam.JavaCore.hw11_25_12_19.storage.initor;

import com.Epam.JavaCore.hw11_25_12_19.application.serviceholder.ServiceHolder;
import com.Epam.JavaCore.hw11_25_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw11_25_12_19.cargo.domain.CargoType;
import com.Epam.JavaCore.hw11_25_12_19.cargo.domain.ClothersCargo;
import com.Epam.JavaCore.hw11_25_12_19.cargo.domain.FoodCargo;
import com.Epam.JavaCore.hw11_25_12_19.cargo.service.CargoService;
import com.Epam.JavaCore.hw11_25_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw11_25_12_19.carrier.domain.CarrierType;
import com.Epam.JavaCore.hw11_25_12_19.carrier.service.CarrierService;
import com.Epam.JavaCore.hw11_25_12_19.common.business.service.CommonService;
import com.Epam.JavaCore.hw11_25_12_19.storage.initor.exception.unchecked.InitorFilePathDoesNotPointToFileException;
import com.Epam.JavaCore.hw11_25_12_19.transportation.domain.Transportation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FromFileInitor {
    private FromFileInitor() {
    }

    public static void initDataFromFile(String filePath) {
        File file = new File(filePath);
        if (!file.isFile()) {
            throw new InitorFilePathDoesNotPointToFileException();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currEntityTypeRead = "null";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("BEGIN"))
                    currEntityTypeRead = line;
                else if (!line.contains("END")) {
                    switch (currEntityTypeRead) {
                        case "---CARGO_BEGIN---":
                            initCargoFromLine(line);
                            break;
                        case "---CARRIER_BEGIN---":
                            initCarrierFromLine(line);
                            break;
                        case "---TRANSPORTATION_BEGIN---":
                            initTransportationFromLine(line);
                            break;
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initCargoFromLine(String line) throws ParseException {
        CommonService cargoService = ServiceHolder.getInstance().getCargoService();

        switch (CargoType.valueOf(line.substring(0, line.indexOf("|")))) {
            case FOOD:
                FoodCargo foodCargo = new FoodCargo();
                String integ = line.substring(line.lastIndexOf("|") + 1);
                foodCargo.setStoreTemperature(Integer.parseInt(integ));
                line = line.substring(0, line.lastIndexOf("|"));

                String date = line.substring(line.lastIndexOf("|") + 1);
                SimpleDateFormat format = new SimpleDateFormat();
                format.applyPattern("dd.MM.yyyy");
                foodCargo.setExpirationDate(format.parse(date));

                line = line.substring(0, line.lastIndexOf("|"));

                cargoService.save(getCargoDataFromLine(foodCargo, line));
                break;
            case CLOTHERS:
                ClothersCargo clothersCargo = new ClothersCargo();

                clothersCargo.setMaterial(line.substring(line.indexOf("|")) + 1);
                line = line.substring(0, line.lastIndexOf("|"));

                clothersCargo.setSize(line.substring(line.indexOf("|") + 1));
                line = line.substring(0, line.lastIndexOf("|"));

                cargoService.save(getCargoDataFromLine(clothersCargo, line));
                break;
        }
    }

    private static void initCarrierFromLine(String line) {
        CommonService carrierService = ServiceHolder.getInstance().getCarrierService();
        Carrier carrier = new Carrier();

        carrier.setCarrierType(CarrierType.valueOf(line.substring(line.lastIndexOf("|") + 1)));
        line = line.substring(0, line.lastIndexOf("|"));

        carrier.setAddress(line.substring(line.lastIndexOf("|") + 1));

        carrier.setName(line.substring(0, line.lastIndexOf("|")));

        carrierService.save(carrier);
    }

    private static void initTransportationFromLine(String line) throws ParseException {
        CommonService transportationService = ServiceHolder.getInstance().getTransportationService();
        CargoService cargoService = ServiceHolder.getInstance().getCargoService();
        CarrierService carrierService = ServiceHolder.getInstance().getCarrierService();
        Transportation transportation = new Transportation();

        String integ = line.substring(line.lastIndexOf("|") + 1);
        transportation.setCargo(cargoService.findById(Long.parseLong(integ)));
        line = line.substring(0, line.lastIndexOf("|"));

        integ = line.substring(line.lastIndexOf("|") + 1);
        transportation.setCarrier(carrierService.findById(Long.parseLong(integ)));
        line = line.substring(0, line.lastIndexOf("|"));

        String date = line.substring(line.lastIndexOf("|") + 1);
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        transportation.setTransportationBeginDate(format.parse(date));
        line = line.substring(0, line.lastIndexOf("|"));

        transportation.setBillTo(line.substring(line.lastIndexOf("|") + 1));

        transportation.setDescription(line.substring(0, line.lastIndexOf("|")));
        transportationService.save(transportation);
    }

    private static Cargo getCargoDataFromLine(Cargo cargo, String line) {
        cargo.setWeight(Integer.parseInt(line.substring(line.lastIndexOf("|") + 1)));
        line = line.substring(0, line.lastIndexOf("|"));
        cargo.setName(line.substring(line.lastIndexOf("|") + 1));
        return cargo;
    }
}
