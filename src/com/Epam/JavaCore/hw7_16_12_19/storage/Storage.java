package com.Epam.JavaCore.hw7_16_12_19.storage;


import com.Epam.JavaCore.hw7_16_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw7_16_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw7_16_12_19.common.solutions.utils.ArrayUtils;
import com.Epam.JavaCore.hw7_16_12_19.transportation.domain.Transportation;

import java.util.ArrayList;
import java.util.List;

public class Storage {

  private static final int ARRAY_CAPACITY = 10;

  public static Cargo[] cargosArray = new Cargo[ARRAY_CAPACITY];
  public static List<Cargo> cargoArrayList = new ArrayList<>();
  public static int cargoIndex = 0;

  public static Carrier[] carriersArray = new Carrier[ARRAY_CAPACITY];
  public static List<Carrier> carrierArrayList = new ArrayList<>();
  public static int carrierIndex = 0;

  public static Transportation[] transportationsArray = new Transportation[ARRAY_CAPACITY];
  public static List<Transportation> transportationArrayList = new ArrayList<>();
  public static int transportationIndex = 0;



  public static void printAllCargos() {
    ArrayUtils.printArray(cargosArray);
  }

  public static void printAllCarriers() {
    ArrayUtils.printArray(carriersArray);
  }

  public static void printAllTransportations() {
    ArrayUtils.printArray(transportationsArray);
  }

}
