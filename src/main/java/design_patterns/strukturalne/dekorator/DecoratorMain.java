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

public class DecoratorMain {
    public static void main(String[] args){
        run_abstract();
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
        //demonstracja wzorca
        System.out.println("decorator");
    }

}
