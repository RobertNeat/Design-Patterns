package design_patterns.behawioralne.odwiedzający.operacje_na_menu;

public class CaloriesVisitor implements MenuVisitor{
    @Override
    public void visit(Dish element) {
        System.out.println("Dish calories: "+element.getCalories());
    }

    @Override
    public void visit(Drink element) {
        System.out.println("Drink calories: "+element.getCalories());
    }

    @Override
    public void visit(Dessert element) {
        System.out.println("Dessert calories: "+element.getCalories());
    }
}
