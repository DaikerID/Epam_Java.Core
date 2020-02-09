package com.Epam.JavaCore.hw20_07_02_20.reporting;


import com.Epam.JavaCore.hw20_07_02_20.common.business.exception.checked.ReportException;

public interface ReportService {
    void exportData() throws ReportException;
}
