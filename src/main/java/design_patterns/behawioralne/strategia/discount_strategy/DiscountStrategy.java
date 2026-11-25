package design_patterns.behawioralne.strategia.discount_strategy;

import java.math.BigDecimal;

//Interfejs strategii
public interface DiscountStrategy {
    //metoda służąca obliczeniu zniżki na podstawie wartości zamówienia
    BigDecimal calculateDiscount(BigDecimal orderValue);
}
