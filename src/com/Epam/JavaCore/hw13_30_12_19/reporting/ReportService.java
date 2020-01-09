package com.Epam.JavaCore.hw13_30_12_19.reporting;


import com.Epam.JavaCore.hw13_30_12_19.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
