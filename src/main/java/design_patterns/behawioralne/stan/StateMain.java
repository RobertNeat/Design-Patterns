package design_patterns.behawioralne.stan;

/*
* Pozwala obiektowi zmienić swoje zachowanie, gdy zmieni się jego stan wewnętrzny.
*
* KONTEKST - przechowuje odniesienie do jednego z konkretnych obiektów-stanów i deleguje mu zadania specyficzne dla danego stanu. Komunikuje się z obiektem stanu za pośrednictwem interfejsu.
* INTERFEJS STANU - deklaruje metody specyficzne poszczególnych stanów.
* KONKRETNE STANY - dostarczają własne implementacje metod dla poszczególnych stanów, inicjują zmianę stanu, przechowują referencję do obiektu kontekstu i mogą pobierać z niego dowolne informacje.
*
* skończona liczba stanów w której program może się znajdować
* reguły przejść między stamami są określone i znane
* */

import design_patterns.behawioralne.stan.definition.Context;
import design_patterns.behawioralne.stan.definition.State_A;

public class StateMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {}

    public static void run_abstract() {
        // Inicjalizacja Context z początkowym stanem State_A
        Context context = new Context(new State_A());

        System.out.println("==Forward==");

        // Delegowanie operacji do aktualnego stanu (State_A)
        context.performAction(); // A → B | wypisanie: A
        context.displayData();
        context.performAction(); // B → C | wypisanie: B
        context.displayData();

        System.out.println("==Backward==");
        context.reverseDirection();

        context.performAction(); // C → B | wypisanie: C
        context.displayData();
        context.performAction(); // B → A | wypisanie: B
        context.displayData();
        context.performAction(); // A->C | wypisanie: A
        context.displayData();
    }
}
