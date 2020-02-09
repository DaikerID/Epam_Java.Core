package com.Epam.JavaCore.hw20_07_02_20.reporting;

import com.Epam.JavaCore.hw20_07_02_20.cargo.domain.Cargo;
import com.Epam.JavaCore.hw20_07_02_20.cargo.service.CargoService;
import com.Epam.JavaCore.hw20_07_02_20.carrier.domain.Carrier;
import com.Epam.JavaCore.hw20_07_02_20.carrier.service.CarrierService;
import com.Epam.JavaCore.hw20_07_02_20.common.business.exception.checked.ReportException;
import com.Epam.JavaCore.hw20_07_02_20.transportation.domain.Transportation;
import com.Epam.JavaCore.hw20_07_02_20.transportation.service.TransportationService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils.CollectionUtils.isNotEmpty;

public class ReportDefaultService implements ReportService {

  private final CargoService cargoService;
  private final CarrierService carrierService;
  private final TransportationService transportationService;

  public ReportDefaultService(
      CargoService cargoService,
      CarrierService carrierService,
      TransportationService transportationService) {
    this.cargoService = cargoService;
    this.carrierService = carrierService;
    this.transportationService = transportationService;
  }

  @Override
  public void exportData() throws ReportException {
    List<String> reportData = new ArrayList<>();
    reportData.addAll(getCargosReportData());
    reportData.addAll(getCarriersReportData());
    reportData.addAll(getTransportationsReportData());

    if (isNotEmpty(reportData)) {
      try {
        exportDataToFile(reportData);
      } catch (Exception e) {
        throw new ReportException(e.getMessage());
      }
    }
  }

  private void exportDataToFile(List<String> data) throws IOException {
    Path tempFile = null;
    try {
      tempFile = Files.createTempFile("report", "all-data");
      Files.write(tempFile, data);

      List<String> fileContent = Files.readAllLines(tempFile);
      System.out.println("File content");
      for (String line : fileContent) {
        System.out.println(line);
      }
    } finally {
      if (tempFile != null) {
        Files.delete(tempFile);
      }
    }
  }

  private List<String> getCargosReportData() {
    Optional<List<Cargo>> cargos = cargoService.getAll();

    List<String> result = Collections.emptyList();
    if (cargos.isPresent()) {
      result = new ArrayList<>();
      for (Cargo cargo : cargos.get()) {
        if (cargo != null) {
          result.add(cargoAsString(cargo));
        }
      }
    }

    return result;
  }

  private String cargoAsString(Cargo cargo) {
    return "id:" + cargo.getId() + "| " + "Name:" + cargo.getName() + "| weight:" + cargo
        .getWeight() + "| type: " + cargo.getCargoType();
  }

  private List<String> getCarriersReportData() {
    Optional<List<Carrier>> carriers = carrierService.getAll();

    List<String> result = Collections.emptyList();
    if (carriers.isPresent()) {
      result = new ArrayList<>();

      for (Carrier carrier : carriers.get()) {
        if (carrier != null) {
          result.add(carrierAsString(carrier));
        }
      }
    }

    return result;
  }


  private String carrierAsString(Carrier carrier) {
    return "id:" + carrier.getId() + " |name:" + carrier.getName() + "| address:" + carrier
        .getAddress();
  }


  private List<String> getTransportationsReportData() {
    Optional<List<Transportation>> transportations = transportationService.getAll();

    List<String> result = Collections.emptyList();
    if (transportations.isPresent()) {
      result = new ArrayList<>();

      for (Transportation transportation : transportations.get()) {
        if (transportation != null) {
          result.add(transportationAsString(transportation));
        }
      }
    }

    return result;
  }

  private String transportationAsString(Transportation transportation) {
    return "id:" + transportation.getId() + "| description: " + transportation.getDescription()
        + "| cargoRef: " + transportation.getCargo().getId() + " carrierRef: " + transportation
        .getCarrier().getId();
  }


}
