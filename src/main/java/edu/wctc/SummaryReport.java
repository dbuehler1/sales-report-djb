package edu.wctc;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class SummaryReport implements SalesReport{
    @Override
    public void generateReport(List<Sale> salesList) {
        //Array to store unique countries
        ArrayList<String> countries = new ArrayList<>();

        System.out.printf("%-22s%-22s%-22s%-22s\n","Country", "Amount", "Tax", "Shipping");

        //Adds unique countries to a list
        for(Sale sale : salesList){
            if(!countries.contains(sale.getCountryName())){
                countries.add(sale.getCountryName());
            }
        }

        //temporary strings for string builder to output totals
        double tempTax = 0;
        double tempAmount = 0;
        double tempShipping = 0;

        //goes through each unique countries and adds values to temporary variables based on matching country names

        for(int i = 0; i < countries.size(); i++){
            //Reset temporary variables
            tempShipping = 0;
            tempAmount = 0;
            tempTax = 0;
            for(Sale sale : salesList) {
                if (sale.getCountryName().equals(countries.get(i))) {
                    tempAmount += sale.getAmount();
                    tempTax += sale.getTax();
                    tempShipping += sale.getShipping();
                }
            }
            System.out.printf("%-22s%-22s%-22s%-22s\n",countries.get(i), tempAmount, tempTax, String.format("%.2f", tempShipping));
        }


        //Solution above works, just a lot of extra unneeded work
        //Did some research online and found the syntax for arrow methods and it eliminates some unneeded lines.
        //The work below is based off of a stack overflow thread, the solution above is what I did before research
//        for(String country : countries) {
//            tempAmount = salesList.stream().filter(sale -> sale.getCountryName().equals(country)).mapToDouble(sale -> sale.getAmount()).sum();
//            tempTax = salesList.stream().filter(sale -> sale.getCountryName().equals(country)).mapToDouble(sale -> sale.getTax()).sum();
//            tempShipping = salesList.stream().filter(sale -> sale.getCountryName().equals(country)).mapToDouble(sale -> sale.getShipping()).sum();
//            System.out.printf("%-22s%-22s%-22s%-22s\n",country, tempAmount, tempTax, String.format("%.2f", tempShipping));
//        }

    }
}
