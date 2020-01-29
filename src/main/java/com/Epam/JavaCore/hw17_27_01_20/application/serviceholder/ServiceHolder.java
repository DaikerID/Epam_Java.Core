package com.Epam.JavaCore.hw17_27_01_20.application.serviceholder;

import com.Epam.JavaCore.hw17_27_01_20.cargo.repo.impl.CargoArrayRepoImpl;
import com.Epam.JavaCore.hw17_27_01_20.cargo.repo.impl.CargoCollectionRepoImpl;
import com.Epam.JavaCore.hw17_27_01_20.cargo.service.CargoService;
import com.Epam.JavaCore.hw17_27_01_20.cargo.service.CargoServiceImpl;
import com.Epam.JavaCore.hw17_27_01_20.carrier.repo.impl.CarrierArrayRepoImpl;
import com.Epam.JavaCore.hw17_27_01_20.carrier.repo.impl.CarrierCollectionRepoImpl;
import com.Epam.JavaCore.hw17_27_01_20.carrier.service.CarrierService;
import com.Epam.JavaCore.hw17_27_01_20.carrier.service.CarrierServiceImpl;
import com.Epam.JavaCore.hw17_27_01_20.transportation.repo.impl.TransportationArrayRepoImpl;
import com.Epam.JavaCore.hw17_27_01_20.transportation.repo.impl.TransportationCollectionRepoImpl;
import com.Epam.JavaCore.hw17_27_01_20.transportation.service.TransportationService;
import com.Epam.JavaCore.hw17_27_01_20.transportation.service.TransportationServiceImpl;

public final class ServiceHolder {

  private static ServiceHolder instance = null;

  private final CarrierService carrierService;
  private final CargoService cargoService;
  private final TransportationService transportationService;

  private ServiceHolder(StorageType storageType) {
    SimpleServiceHolder initedServiceHolder = getInitedServiceHolder(storageType);
    cargoService = initedServiceHolder.cargoService;
    carrierService = initedServiceHolder.carrierService;
    transportationService = initedServiceHolder.transportationService;
  }

  public static void initServiceHolder(StorageType storageType) {
    ServiceHolder.instance = new ServiceHolder(storageType);
  }

  public static ServiceHolder getInstance() {
    return instance;
  }

  private static class SimpleServiceHolder {

    private final CarrierService carrierService;
    private final CargoService cargoService;
    private final TransportationService transportationService;

    public SimpleServiceHolder(
        CarrierService carrierService,
        CargoService cargoService,
        TransportationService transportationService) {
      this.carrierService = carrierService;
      this.cargoService = cargoService;
      this.transportationService = transportationService;
    }
  }

  private SimpleServiceHolder getInitedServiceHolder(StorageType storageType) {
    switch (storageType) {

      case ARRAY: {
        return new SimpleServiceHolder(
            new CarrierServiceImpl(new CarrierArrayRepoImpl()),
            new CargoServiceImpl(new CargoArrayRepoImpl()),
            new TransportationServiceImpl(new TransportationArrayRepoImpl()));
      }

      default: {
        return new SimpleServiceHolder(
            new CarrierServiceImpl(new CarrierCollectionRepoImpl()),
            new CargoServiceImpl(new CargoCollectionRepoImpl()),
            new TransportationServiceImpl(new TransportationCollectionRepoImpl()));
      }
    }
  }

  public CarrierService getCarrierService() {
    return carrierService;
  }

  public CargoService getCargoService() {
    return cargoService;
  }

  public TransportationService getTransportationService() {
    return transportationService;
  }
}
