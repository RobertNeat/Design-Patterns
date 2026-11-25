package design_patterns.behawioralne.strategia.discount_strategy;

import java.math.BigDecimal;

public class LoyaltyCardDiscount implements DiscountStrategy{

    private BigDecimal discountPercentageValue;
    private boolean isLoyaltyCard;

    public LoyaltyCardDiscount(int discountPercentageValue,boolean isLoyaltyCard){
        this.discountPercentageValue = BigDecimal.valueOf(discountPercentageValue)
                .divide(BigDecimal.valueOf(100));
        this.isLoyaltyCard=isLoyaltyCard;
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal orderValue) {
        if(isLoyaltyCard){
            return orderValue.subtract(
                    orderValue.multiply(discountPercentageValue)
            );
        }
        return orderValue;
    }
}
