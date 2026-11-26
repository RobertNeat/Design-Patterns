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

public class TemplateMethodMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //demonstracja wzorca
        System.out.println("template_method");
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
