package com.Epam.JavaCore.hw14_13_01_20.reporting;


import com.Epam.JavaCore.hw14_13_01_20.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
