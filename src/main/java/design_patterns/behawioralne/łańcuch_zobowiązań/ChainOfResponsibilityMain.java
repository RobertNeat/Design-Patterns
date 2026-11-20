package design_patterns.behawioralne.łańcuch_zobowiązań;

/*
* Przekazywanie żądania wzdłuż łańcucha obiektów obsługujących (wykonanie operacji lub przekazanie dalej).
*
*  OBIEKT OBSŁUGUJĄCY - wspólny interfejs dla wszystkich obiektów obsługujących, zawiera metodę do obsługi żądań i metodę do wybierania kolejnego obiektu w łańcuchu
*  BAZOWY OBIEKT OBSŁUGUJĄCY - opcjonalna klasa zawierająca kod przygotowawczy wspólny dla wszystkich klas obsługujących, definiuje pole przechowujące odniesienie do kolejnego obiektu obsługującego.
*  KONKRETNE OBIEKTY OBSŁUGUJĄCE - zawierają faktyczny kod służący obsłudze żądań. Obiekty są samodzielne i niezmienne, otrzymują wszystkie wartości jednorazowo przez konstruktor
*
*
* Istnieje kilka wariancji łańcucha zobowiązań:
* - obsługa atomiczna albo przekazanie dalej (trochę jak switch ale na obiektach i bardziej skomplikowane operacje można wykonywać)
* - wykonanie operacji i przekazanie dalej (dane ogniwo łańcucha wykonuje pracę ale następne ogniwo też może wykonać pracę itd.)
*
*  */

import design_patterns.behawioralne.łańcuch_zobowiązań.definition.*;

public class ChainOfResponsibilityMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //demonstracja wzorca
        //Kolejne kroki walidacji i rabatów: poprawność zamówienia, dostępność składników, kod promocyjny
        System.out.println("chain_of_responsibility");
    }

    //przykład łańcucha w którym każde ogniwo wykonuje jedną operację i jeśli wykona to przestaje przekazywanie dalej
    public static void run_abstract(){
        //base handler też można wykorzystywać w roli ogniwa łańcucha (pełni wtedy zarówno rolę wspólnej bazowej implementacji i obiektu uczestniczącego w zadaniach
        HandlingInterface base_handler = new BaseHandlerClass();
        HandlingInterface low_handler = new LowPriorityHandler();
        HandlingInterface medium_handler = new MediumPriorityHandler();
        HandlingInterface high_handler = new HighPriorityHandler();

        //połaczenie w łańcuch
        medium_handler.setNext(high_handler);
        low_handler.setNext(medium_handler);
        base_handler.setNext(low_handler);
        //base->low->medium->high

        base_handler.handle("high");

    }
}