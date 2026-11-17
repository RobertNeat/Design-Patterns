package design_patterns.strukturalne.dekorator;

/*
* Pozwala owijać obiekty w dodatkowe zachowania (dekorowanie obiektów), klient wykonuje operajce na klasie bazowej
*
* interfejs KOMPONENT - deklaruje interfejs dla nakładek i opakowywanych obiektów
* KONKRETNY KOMPONENT - klasa bazowych obiektów które można opakowywać w dekoratory
* BAZOWY DEKORATOR - klasa posiadająca pole przeznaczone na referencję do opakowywanego obiektu (typ pola to: interfejs komponentu), deleguje działania opakowywanemu obiektowi (konkretnemu komponentowi)
* KONKRETNI DEKORATORZY - definiują dodatkowe zachowania które można przypisać do komponentów dynamicznie, wykonują swoje działania przed albo po wywołaniu metody klasy rodzica
*
*
 */

import design_patterns.strukturalne.dekorator.definition.ComponentInterface;
import design_patterns.strukturalne.dekorator.definition.ConcreteComponent;
import design_patterns.strukturalne.dekorator.definition.ConcreteDecorator_Append;
import design_patterns.strukturalne.dekorator.definition.ConcreteDecorator_Prepend;
import design_patterns.strukturalne.dekorator.dodatki_dan.Danie;
import design_patterns.strukturalne.dekorator.dodatki_dan.Dodatek;
import design_patterns.strukturalne.dekorator.dodatki_dan.InterfejsDanie;

import java.util.ArrayList;
import java.util.List;

public class DecoratorMain {
    public static void main(String[] args){
        run();
    }

    public static void run_abstract(){
        ComponentInterface component_1 = new ConcreteComponent("text");
        ComponentInterface dekorator_1 = new ConcreteDecorator_Append(component_1,"_appendix");
        ComponentInterface dekorator_2 = new ConcreteDecorator_Prepend(dekorator_1,"prependix_");

        System.out.println("Wywołanie komponentu: "+component_1.execute());
        System.out.println("Wywołanie opakowanego komponentu 1 raz: "+dekorator_1.execute());
        System.out.println("Wywołanie opakowanego komponentu 2 razy: "+dekorator_2.execute());
    }

    public static void run() {
        //Dodatki do dań: dodatkowy ser, ostry sos, większa porcja, każdy zmienia cenę i opis

        //interfejs komponentu: InterfejsDanie
        //konkretny komponent: Danie
        //bazowy dekorator: BazowyDekorator
        //konkretni dekoratorzy: Dodatek

        List<String> danie_makaronowe_skladniki =
                new ArrayList<>(List.of("makaron", "sos"));

        InterfejsDanie danie_1 = new Danie(danie_makaronowe_skladniki);
        InterfejsDanie dodatkowy_ser = new Dodatek(danie_1, "ser");
        InterfejsDanie dodatkowa_sol = new Dodatek(dodatkowy_ser,"sol");
        InterfejsDanie dodatkowy_pieprz = new Dodatek(dodatkowa_sol,"pieprz");

        System.out.println("Danie podstawowe: "+danie_1.execute());
        System.out.println("Danie z dodatkowym serem: "+dodatkowy_ser.execute());
        System.out.println("Danie z dodatkowym serem i sola: "+dodatkowa_sol.execute());
        System.out.println("Danie z dodatkowym serem i sola i pieprzem: "+dodatkowy_pieprz.execute());
    }

}
