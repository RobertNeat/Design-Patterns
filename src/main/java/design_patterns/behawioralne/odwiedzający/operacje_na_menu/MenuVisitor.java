package design_patterns.behawioralne.odwiedzający.operacje_na_menu;

import design_patterns.behawioralne.odwiedzający.definition.DoubleElement;
import design_patterns.behawioralne.odwiedzający.definition.IntegerElement;

//INTERFEJS ODWIEDZAJĄCY
public interface MenuVisitor {
    void visit(Dish element);
    void visit(Drink element);
    void visit(Dessert element);
}
