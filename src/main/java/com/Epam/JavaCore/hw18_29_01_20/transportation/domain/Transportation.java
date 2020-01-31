package com.Epam.JavaCore.hw18_29_01_20.transportation.domain;

import com.Epam.JavaCore.hw18_29_01_20.cargo.domain.Cargo;
import com.Epam.JavaCore.hw18_29_01_20.carrier.domain.Carrier;
import com.Epam.JavaCore.hw18_29_01_20.common.business.domain.BaseEntity;

import java.time.ZonedDateTime;


public class Transportation extends BaseEntity {

    private Cargo cargo;
    private Carrier carrier;
    private String description;
    private String billTo;
    private ZonedDateTime transportationBeginDate;

    public ZonedDateTime getTransportationBeginDate() {
        return transportationBeginDate;
    }

    public void setTransportationBeginDate(ZonedDateTime transportationBeginDate) {
        this.transportationBeginDate = transportationBeginDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "description='" + description + '\'' +
                ", Carrier='" + carrier.getName() + '\'' +
                ", Cargo=" + cargo.getName() +
                '}';
    }
}
