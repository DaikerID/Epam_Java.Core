package com.Epam.JavaCore.hw4_9_12_19.transportation;
import com.Epam.JavaCore.hw4_9_12_19.Entity;
import com.Epam.JavaCore.hw4_9_12_19.cargo.Cargo;
import com.Epam.JavaCore.hw4_9_12_19.carrier.Carrier;

import java.util.Date;

public class Transportation extends Entity {
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

    public String getName() {
        return description;
    }

    public void setName(String description) {
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
}
