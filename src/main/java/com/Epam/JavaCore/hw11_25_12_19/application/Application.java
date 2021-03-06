package com.Epam.JavaCore.hw11_25_12_19.application;

import com.Epam.JavaCore.hw12_27_12_19.application.serviceholder.ServiceHolder;
import com.Epam.JavaCore.hw12_27_12_19.application.serviceholder.StorageType;
import com.Epam.JavaCore.hw12_27_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw12_27_12_19.cargo.domain.CargoField;
import com.Epam.JavaCore.hw12_27_12_19.cargo.search.CargoSearchCondition;
import com.Epam.JavaCore.hw12_27_12_19.cargo.service.CargoService;
import com.Epam.JavaCore.hw12_27_12_19.carrier.service.CarrierService;
import com.Epam.JavaCore.hw12_27_12_19.common.solutions.search.OrderType;
import com.Epam.JavaCore.hw12_27_12_19.common.solutions.utils.CollectionUtils;
import com.Epam.JavaCore.hw12_27_12_19.storage.initor.InMemoryStorageInitor;
import com.Epam.JavaCore.hw12_27_12_19.storage.initor.InitFrom;
import com.Epam.JavaCore.hw12_27_12_19.storage.initor.StorageInitor;
import com.Epam.JavaCore.hw12_27_12_19.transportation.service.TransportationService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import static com.Epam.JavaCore.hw12_27_12_19.cargo.domain.CargoField.NAME;
import static com.Epam.JavaCore.hw12_27_12_19.cargo.domain.CargoField.WEIGHT;
import static com.Epam.JavaCore.hw12_27_12_19.common.solutions.search.OrderType.ASC;
import static com.Epam.JavaCore.hw12_27_12_19.common.solutions.search.OrderType.DESC;
import static java.util.Collections.singletonList;

public class Application {

    private static final String SEPARATOR = "--------------";
    private static CargoService cargoService;
    private static CarrierService carrierService;
    private static TransportationService transportationService;

    public static void main(String[] args) {
        ServiceHolder.initServiceHolder(StorageType.COLLECTION);
        cargoService = ServiceHolder.getInstance().getCargoService();
        carrierService = ServiceHolder.getInstance().getCarrierService();
        transportationService = ServiceHolder.getInstance().getTransportationService();

        StorageInitor storageInitor = new InMemoryStorageInitor();
        storageInitor.setFilePath("C:\\Users\\igorh\\IdeaProjects\\Epam_Java.Core\\src\\com\\Epam\\JavaCore\\hw11_25_12_19\\DB\\database.txt");
        storageInitor.initStorage(InitFrom.FILE);

        printStorageData();
        demoSearchOperations();
        demoSortOperations();
        demoExceptions();
    }

    private static void demoSearchOperations() {
        System.out.println("SEARCH CARGO BY ID = 1");
        System.out.println(cargoService.findById(1L));
        printSeparator();

        System.out.println("SEARCH CARRIER BY ID = 8");
        System.out.println(carrierService.findById(8L));
        printSeparator();

        System.out.println("SEARCH CARGOES BY NAME = 'Clothers_Name_1'");
        CollectionUtils.printCollection(cargoService.findByName("Clothers_Name_1"));
        printSeparator();

        System.out.println("SEARCH CARRIERS BY NAME = 'Carrier_Name'");
        CollectionUtils.printCollection(carrierService.findByName("Carrier_Name"));
    }

    private static void printStorageData() {
        System.out.println("ALL CARGOS");
        cargoService.printAll();
        printSeparator();

        System.out.println("ALL CARRIERS");
        carrierService.printAll();
        printSeparator();

        System.out.println("ALL TRANSPOORTATIONS");
        transportationService.printAll();
        printSeparator();
    }

    private static void printSeparator() {
        System.out.println(SEPARATOR);
    }

    private static void demoSortOperations() {
        demoCargoSorting(singletonList(NAME), ASC);
        demoCargoSorting(singletonList(NAME), DESC);

        demoCargoSorting(singletonList(WEIGHT), ASC);
        demoCargoSorting(singletonList(WEIGHT), DESC);

        demoCargoSorting(Arrays.asList(NAME, WEIGHT), ASC);
        demoCargoSorting(Arrays.asList(NAME, WEIGHT), DESC);
    }

    private static String getOrderingConditionsAsString(CargoSearchCondition condition) {
        StringBuilder result = new StringBuilder();
        result.append(" ORDER BY ");

        Iterator<CargoField> iter = condition.getSortFields().iterator();
        while (iter.hasNext()) {
            CargoField fld = iter.next();
            result.append(fld);

            if (iter.hasNext()) {
                result.append(",");
            }
        }

        result.append(" ").append(condition.getOrderType());

        return result.toString();
    }

    private static void demoCargoSorting(Collection<CargoField> sortFields, OrderType orderType) {
        CargoSearchCondition cargoSearchCondition = new CargoSearchCondition();
        cargoSearchCondition.setOrderType(orderType);
        cargoSearchCondition.setSortFields(new LinkedHashSet<>(sortFields));
        System.out.println(
                "---------Sorting '" + getOrderingConditionsAsString(cargoSearchCondition) + "'------");
        cargoService.search(cargoSearchCondition);
        cargoService.printAll();
        System.out.println();
    }

    private static void demoExceptions() {
        System.out.println("------Demo  exceptions------------");
        Long firstCargo = cargoService.getAll().get(0).getId();
        Cargo cargo = cargoService.getByIdFetchingTransportations(firstCargo);
        System.out.println("Try to delete cargo");
        System.out.println("Cargo details:");
        System.out.println("id: " + cargo.getId());
        System.out.println("name: " + cargo.getName());
        System.out.println("total transportations: " + (cargo.getTransportations() != null ? cargo
                .getTransportations().size() : 0));
        System.out.println();
        try {
            cargoService.deleteById(cargo.getId());
        } catch (Exception e) {
            System.out.println("OOPS, something went wrong!");
            System.out.println(e.getMessage());
        }
    }
}
