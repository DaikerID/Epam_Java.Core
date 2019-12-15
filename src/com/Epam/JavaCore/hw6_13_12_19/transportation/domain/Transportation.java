package com.Epam.JavaCore.hw6_13_12_19.transportation.domain;

import com.Epam.JavaCore.hw6_13_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw6_13_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw6_13_12_19.common.domen.BaseEntity;

import java.util.Date;

public class Transportation extends BaseEntity {
    private Cargo cargo;
    private Carrier carrier;
    private String description;
    private String billTo;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                "cargo=" + cargo +
                ", carrier=" + carrier +
                ", description='" + description + '\'' +
                ", billTo='" + billTo + '\'' +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}
