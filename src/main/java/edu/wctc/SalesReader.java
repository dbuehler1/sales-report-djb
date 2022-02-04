package edu.wctc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesReader implements SalesInput{
    @Autowired
    private ShippingPolicy shipper;
    @Override
    public List<Sale> getSales() {

        List<Sale> sales = new ArrayList<>();
        File file = new File("sales.txt");
        try {

            Scanner reader = new Scanner(file);

            while(reader.hasNext()) {
                String line = reader.nextLine();
                String[] contents = line.split(",");
                Sale sale = new Sale();
                sale.setCustomer(contents[0]);
                sale.setCountryName(contents[1]);
                sale.setAmount(Double.parseDouble(contents[2]));
                sale.setTax(Double.parseDouble(contents[3]));
                shipper.applyShipping(sale);
                sales.add(sale);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sales;
    }
}
