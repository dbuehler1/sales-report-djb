package edu.wctc;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sale {
    private String customer;
    private String countryName;
    private double amount;
    private double tax;
    private double shipping;
}
