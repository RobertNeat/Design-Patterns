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
import design_patterns.behawioralne.obserwator.order_status.KelnerSubscriber;
import design_patterns.behawioralne.obserwator.order_status.Klientsubscriber;
import design_patterns.behawioralne.obserwator.order_status.KuchniaSubskrybent;
import design_patterns.behawioralne.obserwator.order_status.StatusTrackerPublisher;

public class ObserverMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //Powiadamianie kuchni, kelnera i klienta o zmianie statusu zamówienia

        StatusTrackerPublisher statusTracker = new StatusTrackerPublisher(); //wersja ze wspólną abstrakcją dla publikujących

        KelnerSubscriber kelner = new KelnerSubscriber();
        KuchniaSubskrybent kuchnia = new KuchniaSubskrybent();
        Klientsubscriber klient_1 = new Klientsubscriber();
        Klientsubscriber klient_2 = new Klientsubscriber();

        statusTracker.subscribe(kelner);
        statusTracker.subscribe(kuchnia);
        statusTracker.subscribe(klient_1);
        statusTracker.subscribe(klient_2);

        statusTracker.zmienStatusDania("rozpoczeto",10);

        statusTracker.unsubscribe(kelner);

        statusTracker.zmienStatusDania("wykonano",100);

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
