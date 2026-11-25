package design_patterns.behawioralne.obserwator;

/*
* Definiuje mechanizm subskrypcji w celu powiadamiania wielu obiektów o zdarzeniach dziejących się w obserwowanym obiekcie
*
* klasa PUBLIKUJĄCY - rozsyła zdarzenia subskrybentom na podstawie zmian swojego stanu. Udostępnia metody subskrybowania i przerwania subskrypcji. Komunikuje się z subskrybentami za pomocą interfejsu subskrybenta.
* interfejs SUBSKRYBENTA - deklaruje interfejs powiadamiania
* KONKRETNI SUBSKRYBENCI - wykonują czynności w odpowiedzi na otrzymane powiadomienia. Implementują interfejs subskrybenta.
*
* publikujący wewnętrznie implementuje możliwość subskrybowania jako pole tablicowe z listą odniesień do subskrybentów i metod publicznych pozwalających dodawać i usuwać wpisy tej listy.
* */

import design_patterns.behawioralne.obserwator.definition.*;

public class ObserverMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //demonstracja wzorca
        System.out.println("observer");
    }


    public static void run_abstract(){
        Publisher concrete_publisher = new Publisher();//jeśli mamy implementację w której metody zmiany stanu konkretnej implementacji publikującego nie są w interfejsie, to operujemy na konkretnym publikującym
        PublisherInterface publisher_interface = concrete_publisher;//pełni rolę interfejsu za pomocą którego subskrybenci mogą subskrybować i odsubskrybowywać

        SubscriberInterface sub_a = new ConcreteSubscriber_A();
        SubscriberInterface sub_b = new ConcreteSubscriber_B();

        // Rejestracja subskrybentów
        publisher_interface.subscribe(sub_a);
        publisher_interface.subscribe(sub_b);


        // Powiadomienie wszystkich
        concrete_publisher.changeState("STATE_1");

        // Wypisanie subskrybenta A
        publisher_interface.unsubscribe(sub_a);

        // Kolejne powiadomienie
        concrete_publisher.changeState("STATE_2");
    }
}
