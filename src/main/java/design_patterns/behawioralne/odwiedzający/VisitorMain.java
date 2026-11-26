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

public class VisitorMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //Operacje na elementach menu bez zmiany ich klas: kalkulacja kalorii, raport alergenów, wyceny
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
