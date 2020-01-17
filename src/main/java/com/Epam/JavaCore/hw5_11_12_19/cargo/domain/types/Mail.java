package com.Epam.JavaCore.hw5_11_12_19.cargo.domain.types;

import com.Epam.JavaCore.hw5_11_12_19.cargo.domain.Cargo;

import java.util.Date;

public class Mail extends Cargo {
    private Date departureDate;

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}
