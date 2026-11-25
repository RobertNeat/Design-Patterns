package design_patterns.behawioralne.strategia.discount_strategy;

import java.math.BigDecimal;

//Konkretna Strategia
public class PercentageDiscount implements DiscountStrategy{
    private BigDecimal discountPercentageValue;

    public PercentageDiscount(int discountPercentageValue){
        this.discountPercentageValue = BigDecimal.valueOf(discountPercentageValue)
                .divide(BigDecimal.valueOf(100));
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal orderValue) {
        return orderValue.subtract(
                orderValue.multiply(discountPercentageValue)
        );
    }
}
