package com.Epam.JavaCore.hw7_16_12_19.cargo.domain;



import com.Epam.JavaCore.hw7_16_12_19.common.business.domain.BaseEntity;
import com.Epam.JavaCore.hw7_16_12_19.transportation.domain.Transportation;

import java.util.Arrays;

public abstract class Cargo extends BaseEntity {

  protected String name;
  protected int weight;
  protected Transportation[] transportations;
  protected CargoType cargoType;

  public Cargo() {
    cargoType = this.getCargoType();
  }

  public abstract CargoType getCargoType();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Transportation[] getTransportations() {
    return transportations;
  }

  public void setTransportations(Transportation[] transportations) {
    this.transportations = transportations;
  }

  @Override
  public String toString() {
    return "Cargo{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", weight=" + weight +
        ", cargoType=" + cargoType +
        ", transportations=" + Arrays.toString(transportations) +
        '}';
  }
}
