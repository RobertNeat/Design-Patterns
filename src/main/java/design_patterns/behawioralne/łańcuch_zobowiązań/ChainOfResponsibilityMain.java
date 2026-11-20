package design_patterns.behawioralne.łańcuch_zobowiązań;

/*
* Przekazywanie żądania wzdłuż łańcucha obiektów obsługujących (wykonanie operacji lub przekazanie dalej).
*
*  interfejs OBIEKTU OBSŁUGUJĄCEGO - interfejs dla wszystkich obiektów obsługujących, zawiera metodę do obsługi żądań i metodę do wybierania kolejnego obiektu w łańcuchu
*  klasa BAZOWY OBIEKT OBSŁUGUJĄCY - opcjonalna klasa zawierająca kod przygotowawczy wspólny dla wszystkich klas obsługujących, definiuje pole przechowujące odniesienie do kolejnego obiektu obsługującego.
*  klasy KONKRETNE OBIEKTY OBSŁUGUJĄCE - zawierają faktyczny kod służący obsłudze żądań. Obiekty są samodzielne i niezmienne, otrzymują wszystkie wartości jednorazowo przez konstruktor
*
*
* Istnieje kilka wariancji łańcucha zobowiązań:
* - obsługa atomiczna albo przekazanie dalej (trochę jak switch ale na obiektach i bardziej skomplikowane operacje można wykonywać)
* - wykonanie operacji i przekazanie dalej (dane ogniwo łańcucha wykonuje pracę ale następne ogniwo też może wykonać pracę itd.)
*
*  */

import design_patterns.behawioralne.łańcuch_zobowiązań.definition.*;
import design_patterns.behawioralne.łańcuch_zobowiązań.lancuch_rozliczenia_zamowienia.*;

import java.util.HashMap;
import java.util.Map;

public class ChainOfResponsibilityMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //Kolejne kroki walidacji i rabatów: poprawność zamówienia, dostępność składników, kod promocyjny
        Map<String,Boolean> zadanie = new HashMap<>();
        zadanie.put("poprawnosc_zamowienia",true);
        zadanie.put("dostepnosc_skladnikow",true);
        zadanie.put("kod_promocyjny",false);

        //InterfejsObslugi -- interfejs OBIEKTU OBSŁUGUJĄCEGO
        //ObslugaBaseHandler -- klasa BAZOWY OBIEKT OBSŁUGUJĄCY
        //SprawdzPoprawnoscZamowienia -- klasy KONKRETNE OBIEKTY OBSŁUGUJĄCE
        //SprawdzDostepnoscSkladnikow -- klasy KONKRETNE OBIEKTY OBSŁUGUJĄCE
        //SprawdzKodRabatowy -- klasy KONKRETNE OBIEKTY OBSŁUGUJĄCE

        InterfejsObslugi krok_1 = new SprawdzDostepnoscSkladnikow();
        InterfejsObslugi krok_2 = new SprawdzKodRabatowy();
        InterfejsObslugi krok_3 = new SprawdzPoprawnoscZamowienia();
        InterfejsObslugi krok_4 = new ObslugaBaseHandler();

        krok_1.setNext(krok_2);
        krok_2.setNext(krok_3);
        krok_3.setNext(krok_4);
        //krok_1->krok_2->krok_3->krok_4

        krok_1.handle(zadanie);
        //można by także dodać zabezpieczenie w konkretnych handlerach jeśli ("kod_promocyjny",false) żeby nie przekazywać wartości jeśli jest false dalej
        //ale pozostawiam w przykładzie, żeby nie dokładać logiki

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