package com.Epam.JavaCore.hw11_25_12_19.storage.initor.eception.unchecked;

import com.Epam.JavaCore.hw11_25_12_19.common.business.exception.unchecked.OurCompanyException;

public class InitorFilePathDoesNotPointToFileException extends OurCompanyException {
    private static final String MESSAGE = "File %spath does not point to file!";

    public InitorFilePathDoesNotPointToFileException() {
        super(MESSAGE);
    }
}