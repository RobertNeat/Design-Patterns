package design_patterns.behawioralne.odwiedzający;

/*
* Oddziela algorytmy operujące na obiektach od samych obiektów, umożliwiając definiowanie nowych operacji bez modyfikowania ich klas.
*
* INTERFEJS ODWIEDZAJĄCY - deklaruje zestaw metod odwiedzania po jednej dla każdego typu obiektu. Każda metoda przyjmuje odwiedzane obiektu jako parametr.
* KONKRETNY(I) ODWIEDZAJĄCY - implementuje operacje wykonywane na różnych typach elementów, definiując zachowanie dla każdej konkretnej klasy elementu.
* INTERFEJS ELEMENT - deklaruje metodę przyjmowania odwiedzającego.
* KONKRETNY(E) ELEMENT(Y) - implementuje metodę przyjmowania, która przekazuje siebie jako argument do odpowiedniej metody odwiedzającego (podwójna dyspozycja).
*
* Podwójna dyspozycja – mechanizm wyboru odpowiedniej metody na podstawie typów dwóch obiektów: odwiedzającego oraz odwiedzanego elementu. Element przekazuje siebie do odwiedzającego, wywołując metodę właściwą dla swojego typu.
* */


import design_patterns.behawioralne.odwiedzający.definition.*;
import design_patterns.behawioralne.odwiedzający.operacje_na_menu.*;

import java.math.BigDecimal;
import java.util.List;

public class VisitorMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //Operacje na elementach menu bez zmiany ich klas: kalkulacja kalorii, raport alergenów, wyceny

        // W restauracji w menu występują: Dania, Napoje, Desery
        // Z czego Dania ma obiekty np. pizza, burger, Napoje: kawa, sok, Desery: lody, ciasto
        // Chcemy wykonywać na tych elementach wykonywać operacje: obliczania kaloryczności, generowania list alergenów, obliczania ceny z podatkiem VAT
        // Ale nie powinniśmy tych operacji umieszczać w klasach Dania, Napoje, Desery, ponieważ rozmyje się odpowiedzialnośc tych klas i będą robiły wszystko (i też klasy byłyby uzależnione od swoich instancji)

        //INTERFEJS ODWIEDZAJĄCY: MenuVisitor
        //KONKRETNI ODWIEDZAJĄCY: CaloriesVisitor, AllergenVisitor, PriceVisitor
        //INTERFEJS ELEMENT: MenuItem
        //KONKRETNE ELEMENTY: Dish, Drink, Dessert


        //alergeny:
        List<String> gluten = List.of("Gluten");
        List<String> milk = List.of("Mleko");
        List<String> eggs = List.of("Jaja");
        List<String> glutenMilk = List.of("Gluten", "Mleko");
        List<String> glutenMilkEggs = List.of("Gluten", "Mleko", "Jaja");
        List<String> noAllergens = List.of();

        MenuItem drink_1 = new Drink(
                "Latte",
                180,
                milk,
                BigDecimal.valueOf(14.99)
        );

        MenuItem drink_2 = new Drink(
                "Fresh Orange Juice",
                110,
                noAllergens,
                BigDecimal.valueOf(12.50)
        );

        MenuItem dish_1 = new Dish(
                "Pizza Margherita",
                850,
                glutenMilk,
                BigDecimal.valueOf(32.99)
        );

        MenuItem dish_2 = new Dish(
                "Classic Cheeseburger",
                920,
                glutenMilkEggs,
                BigDecimal.valueOf(36.50)
        );

        MenuItem dish_3 = new Dish(
                "Grilled Chicken Salad",
                420,
                noAllergens,
                BigDecimal.valueOf(28.00)
        );

        MenuItem dessert_1 = new Dessert(
                "Cheesecake",
                460,
                glutenMilkEggs,
                BigDecimal.valueOf(16.99)
        );

        MenuVisitor allergen_visitor = new AllergenVisitor();
        MenuVisitor callories_visitor = new CaloriesVisitor();
        MenuVisitor price_visitor = new PriceVisitor();


        drink_1.accept(allergen_visitor);
        drink_2.accept(allergen_visitor);
        dish_1.accept(allergen_visitor);
        dish_2.accept(allergen_visitor);
        dish_3.accept(allergen_visitor);
        dessert_1.accept(allergen_visitor);

        drink_1.accept(callories_visitor);
        drink_2.accept(callories_visitor);
        dish_1.accept(callories_visitor);
        dish_2.accept(callories_visitor);
        dish_3.accept(callories_visitor);
        dessert_1.accept(callories_visitor);

        drink_1.accept(price_visitor);
        drink_2.accept(price_visitor);
        dish_1.accept(price_visitor);
        dish_2.accept(price_visitor);
        dish_3.accept(price_visitor);
        dessert_1.accept(price_visitor);

    }



    public static void run_abstract(){

        // Referencje interfejsowe pozwalają korzystać z różnych implementacji
        // elementów i odwiedzających bez uzależniania kodu od konkretnych klas.
        ElementInterface integer_val = new IntegerElement(5);
        ElementInterface double_val = new DoubleElement(2.5);

        VisitorInterface print_vis = new PrintVisitor();
        VisitorInterface square_vis = new SquareVisitor();

        // Elementy przyjmują odwiedzających (accept), przekazując siebie do odpowiedniej metody visit().
        // To jest podwójna dyspozycja.
        integer_val.accept(print_vis);
        double_val.accept(print_vis);

        integer_val.accept(square_vis);
        double_val.accept(square_vis);
    }
}
