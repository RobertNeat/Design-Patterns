package design_patterns.behawioralne.strategia.discount_strategy;

import java.math.BigDecimal;

//Kontekst
public class Order {
    DiscountStrategy strategy;
    BigDecimal orderValue;

    public Order(DiscountStrategy strategy){
        this.strategy=strategy;
    }


    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal executeStrategy(double orderValue){
        return strategy.calculateDiscount(BigDecimal.valueOf(orderValue));
    }
}
