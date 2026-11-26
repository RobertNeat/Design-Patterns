package design_patterns.behawioralne.odwiedzający.operacje_na_menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dessert implements MenuItem{

    String dessertName;
    int calories;
    List<String> allergens;
    BigDecimal basePrice;

    public Dessert(String dessertName, int callories, List<String> allergens, BigDecimal price){
        this.dessertName=dessertName;
        this.calories=callories;
        this.allergens= new ArrayList<>(allergens);
        this.basePrice= price;
    }

    @Override
    public void accept(MenuVisitor visitor) {
        visitor.visit(this);
    }

    //getters
    public String getDessertName() {
        return dessertName;
    }

    public int getCalories() {
        return calories;
    }

    public List<String> getAllergens() {
        return List.copyOf(allergens);
        //albo alternatywnie: return new ArrayList<>(allergens);
        //ważne, żeby zwracać zawsze nowy obiekt tablicy, żeby nikt z zewnątrz nie mógł dish.getAllergens().clear(); co by naruszyło hermetyzację pola
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

}
