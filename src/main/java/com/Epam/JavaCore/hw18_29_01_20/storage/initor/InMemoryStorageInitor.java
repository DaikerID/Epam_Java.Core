package com.Epam.JavaCore.hw18_29_01_20.storage.initor;


import com.Epam.JavaCore.hw18_29_01_20.application.serviceholder.ServiceHolder;
import com.Epam.JavaCore.hw18_29_01_20.cargo.domain.Cargo;
import com.Epam.JavaCore.hw18_29_01_20.cargo.domain.ClothersCargo;
import com.Epam.JavaCore.hw18_29_01_20.cargo.domain.FoodCargo;
import com.Epam.JavaCore.hw18_29_01_20.cargo.service.CargoService;
import com.Epam.JavaCore.hw18_29_01_20.carrier.domain.Carrier;
import com.Epam.JavaCore.hw18_29_01_20.carrier.service.CarrierService;
import com.Epam.JavaCore.hw18_29_01_20.transportation.domain.Transportation;
import com.Epam.JavaCore.hw18_29_01_20.transportation.service.TransportationService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class InMemoryStorageInitor implements StorageInitor {

  private static final int TOTAL_ENTITIES_IN_GROUP = 6;

  private final CarrierService carrierService;
  private final CargoService cargoService;
  private final TransportationService transportationService;

  public InMemoryStorageInitor() {
    carrierService = ServiceHolder.getInstance().getCarrierService();
    cargoService = ServiceHolder.getInstance().getCargoService();
    transportationService = ServiceHolder.getInstance().getTransportationService();
  }

  @Override
  public void initStorage() {
    initCargos();
    initCarriers();
    initTransportations();
    appendTransportationsToCargos();
  }

  private void initCargos() {
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP / 2; i++) {
      cargoService.save(createClothersCargo(i));
    }
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP / 2; i++) {
      cargoService.save(createFoodCargo(i));
    }
  }

  private ClothersCargo createClothersCargo(int index) {
    ClothersCargo cargo = new ClothersCargo();
    cargo.setSize("Clothers_Size_" + index);
    cargo.setName("Jeans");
    cargo.setWeight(ThreadLocalRandom.current().nextInt(1, 100 + 1));

    return cargo;
  }

  private FoodCargo createFoodCargo(int index) {
    FoodCargo cargo = new FoodCargo();
    cargo.setExpirationDate(ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault()));
    cargo.setStoreTemperature(index);
    cargo.setWeight(ThreadLocalRandom.current().nextInt(1, 100 + 1));
    cargo.setName("Milk");

    return cargo;
  }

  private void initCarriers() {
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP; i++) {
      Carrier carrier = createCarrier(i);
      carrierService.save(carrier);
    }
  }

  private Carrier createCarrier(int index) {
    Carrier carrier = new Carrier();
    carrier.setName("Carrier_Name");
    carrier.setAddress("Address_" + index);
    return carrier;
  }

  private void initTransportations() {
    for (int i = 0; i < TOTAL_ENTITIES_IN_GROUP; i++) {
      Transportation transportation = createTransportation(i + 1, i + 1 + TOTAL_ENTITIES_IN_GROUP);
      transportationService.save(transportation);
    }
  }

  private Transportation createTransportation(long cargoId, long carrierId) {
    Transportation transportation = new Transportation();
    cargoService.findById(cargoId).ifPresent(transportation::setCargo);
    carrierService.findById(carrierId).ifPresent(transportation::setCarrier);
    transportation.setDescription("Transportation");

    return transportation;
  }

  private void appendTransportationsToCargos() {
    Optional<List<Cargo>> cargosOptional = cargoService.getAll();
    Optional<List<Transportation>> transportationsOptional = transportationService.getAll();

    if (cargosOptional.isPresent() && transportationsOptional.isPresent()) {
      for (Cargo cargo : cargosOptional.get()) {
        appendTransportationsToCargo(cargo, transportationsOptional.get());
      }
    }
  }

  private void appendTransportationsToCargo(Cargo cargo,
                                            List<Transportation> transportations) {

    List<Transportation> cargoTransportations = cargo.getTransportations();
    if (cargoTransportations == null) {
      cargoTransportations = new ArrayList<>();
    }

    for (Transportation transportation : transportations) {
      if (transportation.getCargo() != null && transportation.getCargo().getId()
          .equals(cargo.getId())) {
        cargoTransportations.add(transportation);
      }
    }

    cargo.setTransportations(transportations);
  }
}
