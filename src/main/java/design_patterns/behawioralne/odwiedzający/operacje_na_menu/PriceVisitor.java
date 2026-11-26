package design_patterns.behawioralne.odwiedzający.operacje_na_menu;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceVisitor implements MenuVisitor{
    @Override
    public void visit(Dish element) {
        BigDecimal finalPrice = element.getBasePrice()
                .multiply(new BigDecimal("1.25"))
                .setScale(2, RoundingMode.HALF_UP);
        System.out.println("Dish price: "+finalPrice);
    }

    @Override
    public void visit(Drink element) {
        BigDecimal finalPrice = element.getBasePrice()
                .multiply(new BigDecimal("1.25"))
                .setScale(2, RoundingMode.HALF_UP);
        System.out.println("Drink price: "+finalPrice);
    }

    @Override
    public void visit(Dessert element) {
        BigDecimal finalPrice = element.getBasePrice()
                .multiply(new BigDecimal("1.25"))
                .setScale(2, RoundingMode.HALF_UP);
        System.out.println("Dessert price: "+finalPrice);
    }
}
