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
import design_patterns.behawioralne.strategia.discount_strategy.*;

public class StrategyMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //Wybór rodzaju zniżki: procentowa, kwotowa, happy hour, karta stałego klienta

        //Kontekst:	Order
        //Interfejs strategii: DiscountStrategy
        //Konkretna strategia: PercentageDiscount, FixedAmountDiscount, HappyHourDiscount, LoyaltyCardDiscount
        //Klient: Main

        DiscountStrategy percentageDiscount = new PercentageDiscount(25);//25%
        DiscountStrategy fixedAmountDiscount = new FixedAmountDiscount(30);//-30 value
        DiscountStrategy happyHourDiscount = new HappyHourDiscount(16,20,55);//55%
        DiscountStrategy loyaltyCardDiscountTrue = new LoyaltyCardDiscount(5,true);//5%
        DiscountStrategy loyaltyCardDiscountFalse = new LoyaltyCardDiscount(5,false);//5%

        Order order = new Order(percentageDiscount);
        System.out.println("percentageDiscount: "+order.executeStrategy(100));

        order.setStrategy(fixedAmountDiscount);
        System.out.println("fixedAmountDiscount:"+order.executeStrategy(100));

        order.setStrategy(happyHourDiscount);
        System.out.println("happyHourDiscount:"+order.executeStrategy(100));

        order.setStrategy(loyaltyCardDiscountTrue);
        System.out.println("loyaltyCardDiscountTrue:"+order.executeStrategy(100));

        order.setStrategy(loyaltyCardDiscountFalse);
        System.out.println("loyaltyCardDiscountFalse:"+order.executeStrategy(100));
    }


    public static void run_abstract(){
        //strategia na przykładzie wymiennych algorytmów wykonywania operacji matematycznej na dwóch liczbach.

        //inicjalizacja algorytmów
        StrategyInterface dodawanie = new ConcreteStrategy_Adding();
        StrategyInterface odejmowanie = new ConcreteStrategy_Substracting();

        //powiązanie algorytmu dodawania z klasą kontekstu
        Context context = new Context(dodawanie);

        System.out.println("Strategia dodawania [2,3]:"+context.executeStrategy(2,3));

        //podmiana w kontekście na algorytm odejmowania
        context.setStrategy(odejmowanie);
        System.out.println("Strategia odejmowania [2,3]:"+context.executeStrategy(2,3));

        //dzięki zastosowaniu strategii kody algorytmów są oddzielne, a w trakcie działania programu można podmieniać algorytmy na których przeprowadzane są działania
    }
}
