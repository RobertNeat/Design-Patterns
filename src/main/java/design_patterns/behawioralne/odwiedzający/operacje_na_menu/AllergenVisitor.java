package design_patterns.behawioralne.odwiedzający.operacje_na_menu;

public class AllergenVisitor implements MenuVisitor{
    @Override
    public void visit(Dish element) {
        System.out.println("Dish allergens: "+element.getAllergens());
    }

    @Override
    public void visit(Drink element) {
        System.out.println("Drink allergens: "+element.getAllergens());
    }

    @Override
    public void visit(Dessert element) {
        System.out.println("Dessert allergens: "+element.getAllergens());
    }
}
