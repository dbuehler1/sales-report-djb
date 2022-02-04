package edu.wctc;

import org.springframework.stereotype.Component;

@Component
public class FlatRate implements ShippingPolicy{
    @Override
    public void applyShipping(Sale sale) {
        sale.setShipping(sale.getAmount() * 0.10);
    }
}
