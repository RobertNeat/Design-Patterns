package design_patterns.behawioralne.metoda_szablonowa;

/*
* Definiuje szkielet algorytmu w klasie bazowej, pozwala podklasom nadpisywać etapy algorytmu bez konieczności zmiany jego struktury.
*
* KLASA ABSTRAKCYJNA - deklaruje metodę szablonową wywołującą poszczególne metody etapów algorytmu w określonej kolejności.
* KONKRETNE KLASY - nadpisują określone etapy, oprócz samej metody szablonowej.
*
* Metody występujące w klasie abstrakcyjnej:
* metoda szablonowa - główna metoda całkowitego działania algorytmu
* etapy abstrakcyjne - etapy które trzeba zaimplementować w każdej podklasie (różne między algorytmami)
* etapy opcjonalne - mają domyślną implementację, ale mogą być nadpisane (wspólne między algorytmami)
* hook'i - opcjonalne puste etapy umożliwiające na rozbudowę algorytmu przez podklasę
* */

import design_patterns.behawioralne.metoda_szablonowa.definition.AbstractTemplate;
import design_patterns.behawioralne.metoda_szablonowa.definition.ConcreteTamplate_A;
import design_patterns.behawioralne.metoda_szablonowa.definition.ConcreteTemplate_B;
import design_patterns.behawioralne.metoda_szablonowa.dish_preparation.AbstractDishPreparation;
import design_patterns.behawioralne.metoda_szablonowa.dish_preparation.PizzaPreparation;
import design_patterns.behawioralne.metoda_szablonowa.dish_preparation.SoupPreparation;
import design_patterns.behawioralne.metoda_szablonowa.dish_preparation.SteakPreparation;

public class TemplateMethodMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //Wspólny szkielet przygotowania dania z różnymi krokami dla każdej kategorii

        //KLASA ABSTRAKCYJNA: AbstractDishPreparation
        //KONKRETNE KLASY: PizzaPreparation, SoupPreparation, SteakPreparation

        //przygotowanie pizzy wymaga wyrobienia ciasta, przygotowania sosu i dodatków, a następnie wypieku
        //przygotowanie zupy wymaga natomiast przygotowania warzyw, wykonania wywaru i ugotowania składników
        //przygotowanie steku obejmuje przygotowanie mięsa, jego odpowiednie przyprawienie, obróbkę termiczną na patelni lub grillu oraz odpoczynek mięsa przed podaniem

        AbstractDishPreparation pizza = new PizzaPreparation();
        AbstractDishPreparation soup = new SoupPreparation();
        AbstractDishPreparation steak = new SteakPreparation();

        System.out.println("-- Prepare pizza: --");
        pizza.prepareDish();

        System.out.println("-- Prepare soup: --");
        soup.prepareDish();

        System.out.println("-- Prepare steak: --");
        steak.prepareDish();
    }


    //metoda szablonowa należy do klasy bazowej i kontroluje kolejność wykonywania algorytmu,
    // podklasy dostarczają implementacje poszczególnych kroków.
    public static void run_abstract(){
        AbstractTemplate templateA = new ConcreteTamplate_A();

        AbstractTemplate templateB = new ConcreteTemplate_B();

        System.out.println("--- Algorithm 1");
        templateA.templateMethod();

        System.out.println("--- Algorithm 2");
        templateB.templateMethod();
    }
}
