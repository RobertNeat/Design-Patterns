package design_patterns.behawioralne.mediator;

/*
* Pozwala redukować zależności między obiektami poprzez zamianę bezpośredniej komunikacji między obiektami na komunikację za pośrednictwem mediatora.
*
* abstrakcja KOMPONENT - zapewnia sposób przekazania konkretnej klasy komponentu do mediatora
* klasy KOMPONENTY - klasy zawierające logikę biznesową, każdy z nich posiada odniesienie do mediatora poprzez 'interfejs MEDIATOR'.
* interfejs MEDIATOR - deklaruje metody komunikacji z komponentami za pomocą pojedynczej metody powiadamiania.
* KONKRETNI MEDIATORZY - hermetyzują relacje pomiędzy różnorakimi komponentami, zarządzają cyklem życia komponentów.
*
* */

import design_patterns.behawioralne.mediator.definition.ComponentClass_A;
import design_patterns.behawioralne.mediator.definition.ComponentClass_B;
import design_patterns.behawioralne.mediator.definition.ComponentClass_C;
import design_patterns.behawioralne.mediator.definition.ConcreteMediator;

public class MediatorMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //demonstracja wzorca
        System.out.println("mediator");
    }


    public static void run_abstract(){
        ComponentClass_A componentA = new ComponentClass_A();
        ComponentClass_B componentB = new ComponentClass_B();
        ComponentClass_C componentC = new ComponentClass_C();

        ConcreteMediator mediator_1 = new ConcreteMediator(componentA,componentB,componentC);

        componentA.setMediator(mediator_1);
        componentB.setMediator(mediator_1);
        componentC.setMediator(mediator_1);

        componentA.performActionA();

    }
}
