package design_patterns.strukturalne.most;

import design_patterns.strukturalne.most.definition.RefinedAbstraction;
import design_patterns.strukturalne.most.definition.ConcreteImplementation_A;
import design_patterns.strukturalne.most.definition.Abstraction;

import design_patterns.strukturalne.most.zamowienie.EkspresowaRealizacja;
import design_patterns.strukturalne.most.zamowienie.StandardowaRealizacja;
import design_patterns.strukturalne.most.zamowienie.ZamowienieNaWynos;

/*
* Podział logiki na osobne hierarchie klas (abstrakcję i implementację) które następnie można rozwijać niezależnie od siebie.
* Zamiast tworzyć m*n klas tworzy się m+n klas
*
* # KEY-DEFINITIONS:
* interfejs ABSTRAKCJA - definiuje logike wysokiego poziomu, przechowuje referencję do implementacji
* WZBOGACONE ABSTRAKCJE (refined abstraction) - rozszerza abstrakcję o bardziej szczegółowe zachowanie
*
* interfejs IMPLEMENTACJA - definiuje interfejs operacji implementacyjnych.
* KONKRETNE IMPLEMENTACJE - dostarcza konkretną implementację interfejsu
*
* ^ można rozwijać logikę na dwóch płaszczyznach (wzbogaconych abstrakcji i konkretnych implemenytacji)
* W java to klasa refined abstraction przechowuje instancję implementacji (ograniczenie technologiczne)
*
*
* abstrakcja:  rodzaj zamówienia (na miejscu, na wynos, z dostawą)
* implementacja:  realizacja (standardowo, priorytetowo, ekspresowo)
*
 */
public class BridgeMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //stworzenie obiektu konkretnej implementacji
        EkspresowaRealizacja ekspresowo = new EkspresowaRealizacja();
        //stworzenie obiektu wzbogaconej abstrakcji
        ZamowienieNaWynos na_wynos = new ZamowienieNaWynos(ekspresowo);

        //wykonywanie działań na abstrakcji która wewnętrznie wywołuje metody implementacji
        na_wynos.przyjmijZamowienie();

        //wykonywanie działań zdefiniowanych w konkretnej abstrakcji
        na_wynos.zrealizujZamowienie();

        // Zmiana sposobu realizacji zamówienia (dodatkowy mechanizm rozszerzenia wzorca pozwalający na ponowne użycie abstrakcji jeśli potrzeba podmienić implementację i tym samym docelowe zachowanie w kodzie)
        na_wynos.zmienRealizacje(new StandardowaRealizacja());

        na_wynos.zrealizujZamowienie();

    }


    public static void run_abstract(){
        ConcreteImplementation_A impl_a = new ConcreteImplementation_A();
        Abstraction ref_abs = new Abstraction(impl_a);
        //metody są wywoływane na wzbogaconych abstrakcjach, ale faktycznie kod działa na teodach konkretnych implementacji
        ref_abs.perform_create();
        ref_abs.perform_reset();

        RefinedAbstraction adv_ref_abs = new RefinedAbstraction(impl_a);
        // metody wywoływane na dodatkowo rozszerzonej abstrakcji są wywoływane analogicznie do rozszerzonej abstrakcji
        adv_ref_abs.perform_create_reset();
    }
}