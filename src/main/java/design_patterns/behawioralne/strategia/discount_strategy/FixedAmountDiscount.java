package design_patterns.behawioralne.strategia.discount_strategy;

import java.math.BigDecimal;

public class FixedAmountDiscount implements DiscountStrategy{

    private BigDecimal discountFixedValue;

    public FixedAmountDiscount(int discountFixedValue){
        this.discountFixedValue=BigDecimal.valueOf(discountFixedValue);
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal orderValue) {
        return orderValue.subtract(discountFixedValue);
    }
}
