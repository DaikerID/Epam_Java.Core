package com.Epam.JavaCore.hw20_07_02_20.carrier.exception.unchecked;


import com.Epam.JavaCore.hw20_07_02_20.common.business.exception.unchecked.OurCompanyUncheckedException;

public class CarrierDeleteConstraintViolationException extends OurCompanyUncheckedException {

    private static final String MESSAGE = "Cant delete carrier with id '%s'. There are transportations which relates to it!";

    public CarrierDeleteConstraintViolationException(String message) {
        super(message);
    }

    public CarrierDeleteConstraintViolationException(long carrierId) {
        this(String.format(MESSAGE, carrierId));
    }
}
