package com.Epam.JavaCore.hw11_25_12_19.storage.initor.exception.unchecked;

import com.Epam.JavaCore.hw12_27_12_19.common.business.exception.unchecked.OurCompanyException;

public class InitorFilePathIsNullException extends OurCompanyException {

    private static final String MESSAGE = "File path is not set!";

    public InitorFilePathIsNullException() {
        super(MESSAGE);
    }
}

