package edu.wctc;

//import org.springframework.stereotype.Component;

import java.util.List;

public class DetailReport implements SalesReport{
    @Override
    public void generateReport(List<Sale> salesList) {
        System.out.printf("%-22s%-22s%-22s%-22s%-22s\n","Customer", "Country", "Amount", "Tax", "Shipping");
        for(Sale sale : salesList) {
            System.out.printf("%-22s%-22s%-22s%-22s%-22s\n",sale.getCustomer(),sale.getCountryName(),sale.getAmount(), sale.getTax(), sale.getShipping());
        }

    }
}
