package design_patterns.strukturalne.most;

import design_patterns.strukturalne.most.definition.RefinedAbstraction;
import design_patterns.strukturalne.most.definition.ConcreteImplementation_A;
import design_patterns.strukturalne.most.definition.Abstraction;

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
*
 */
public class BridgeMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //demonstracja wzorca
        System.out.println("bridge");
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

//Rozdzielenie rodzaju zamówienia (na miejscu, na wynos, dostawa) od sposobu realizacji