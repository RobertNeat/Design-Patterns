package design_patterns.behawioralne.strategia.discount_strategy;

import java.math.BigDecimal;
import java.time.LocalTime;

public class HappyHourDiscount implements DiscountStrategy{
    private LocalTime happyHoutStart;
    private LocalTime happyHoutEnd;
    private BigDecimal discountPercentageValue;

    public HappyHourDiscount(int happyHoutStart,int happyHoutEnd, int discountPercentageValue){
        this.happyHoutStart = LocalTime.of(happyHoutStart, 0);
        this.happyHoutEnd = LocalTime.of(happyHoutEnd, 0);
        this.discountPercentageValue = BigDecimal.valueOf(discountPercentageValue)
                .divide(BigDecimal.valueOf(100));
    }

    @Override
    public BigDecimal calculateDiscount(BigDecimal orderValue) {
        LocalTime now = LocalTime.now();
        if(!now.isBefore(happyHoutStart) && !now.isAfter(happyHoutEnd)){
            return orderValue.subtract(
                    orderValue.multiply(discountPercentageValue)
            );
        }else{
            return orderValue;
        }
    }
}
