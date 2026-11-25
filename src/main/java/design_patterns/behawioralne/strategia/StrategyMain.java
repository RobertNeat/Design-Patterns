package design_patterns.behawioralne.strategia;

/*
* Umożliwia rozdzielenie rodziny algorytmów na osobne wymienialne odrębne klasy.
*
* KONTEKST - przechowuje odniesienie do danej strategii, współpracuje i komunikuje się ze wszystkimi strategiami za pośrednictwem interfejsu
* interfejs STRATEGIA - deklaruje metodę za pomocą której kontekst uruchamia daną strategię
* KONKRETNE STRATEGIE - implementują warianty algorytmu z którego korzysta kontekst
*
* KLIENT przekazuje żądaną strategię kontekstowi (klient wiąże strategię z kontekstem)
* */

import design_patterns.behawioralne.strategia.definition.ConcreteStrategy_Adding;
import design_patterns.behawioralne.strategia.definition.ConcreteStrategy_Substracting;
import design_patterns.behawioralne.strategia.definition.Context;
import design_patterns.behawioralne.strategia.definition.StrategyInterface;

public class StrategyMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //demonstracja wzorca
        System.out.println("strategy");
    }


    public static void run_abstract(){
        //strategia na przykładzie wymiennych algorytmów wykonywania operacji matematycznej na dwóch liczbach.

        StrategyInterface dodawanie = new ConcreteStrategy_Adding();
        StrategyInterface odejmowanie = new ConcreteStrategy_Substracting();

        Context context = new Context(dodawanie);

        System.out.println("Strategia dodawania [2,3]:"+context.executeStrategy(2,3));

        context.setStrategy(odejmowanie);
        System.out.println("Strategia odejmowania [2,3]:"+context.executeStrategy(2,3));

        //dzięki zastosowaniu strategii kody algorytmów są oddzielne, a w trakcie działania programu można podmieniać algorytmy na których przeprowadzane są działania
    }
}
