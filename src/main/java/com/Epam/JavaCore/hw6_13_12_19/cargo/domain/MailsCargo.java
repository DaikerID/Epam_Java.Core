package com.Epam.JavaCore.hw6_13_12_19.cargo.domain;

import java.util.Date;

public class MailsCargo extends Cargo {
    private Date departureDate;

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Override
    public CargoType getCargoType() {
        return CargoType.MAILS;
    }
}
