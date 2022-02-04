package edu.wctc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportProvider {
    @Autowired
    private SalesInput salesProvider;
    @Autowired
    private SalesReport salesReportProvider;

    public void printReports(){

        List<Sale> list = salesProvider.getSales();

        salesReportProvider.generateReport(list);

    }
}
