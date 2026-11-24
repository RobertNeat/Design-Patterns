package design_patterns.behawioralne.pamiątka;

/*
* Pozwala zapisywać i przywracać wcześniejszy stan obiektu bez ujawniania szczegółów jego implementacji.
*
* ŹRÓDŁO (originator) - tworzy migawki swojego stanu i przywraca wcześniejszy stan z migawek.
* PAMIĄTKA (memento) - klasa zagnieżdżona w klasie źródło, tworzy niezmienny obiekt pamiątki stanu źródła na polecenie obiektu źródło
* ZARZĄDCA (caretaker) - zarządza historią migawek stanu źródła, decyduje kiedy tworzyć i przywracać migawki.
*
* Źródło wykonuje faktyczne operacje tworzenia pamiątek i przywracania. Zarządca jedynie je przechowuje historię (listę obiektów snapshotów które zostały stworzone po drodze).
* */

import design_patterns.behawioralne.pamiątka.definition.Caretaker;
import design_patterns.behawioralne.pamiątka.definition.Originator;


import design_patterns.behawioralne.pamiątka.etapy_przygotowania_dan.*;

import java.util.ArrayList;
import java.util.List;

public class MementoMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //Zapis i przywracanie stanu zamówienia podczas etapów przygotowywania


        //ŹRÓDŁO: Danie
        //PAMIĄTKA: Memento
        //ZARZĄDCA: Zarządca

        // 1. Utworzenie dania
        Danie danie = new Danie();

        danie.setNazwa("Pizza Margherita");
        danie.setStopien_przygotowania(0);
        danie.setSkladniki(new ArrayList<>());
        danie.setAktualny_etap("PRZYGOTOWANIE_SKLADNIKOW");

        // 2. Utworzenie zarządcy
        Zarzadca zarzadca = new Zarzadca(danie);

        // 3. Dodanie składników
        List<String> skladniki = danie.getSkladniki();
        skladniki.add("Ciasto");
        skladniki.add("Sos pomidorowy");
        skladniki.add("Mozzarella");
        skladniki.add("Bazylia");

        danie.setStopien_przygotowania(20);

        // 4. Zapis pierwszej migawki
        zarzadca.saveState();

        // 5. Obróbka termiczna
        danie.setStopien_przygotowania(60);
        danie.setAktualny_etap("OBROBKA_TERMICZNA");

        // 6. Zapis drugiej migawki
        zarzadca.saveState();

        // 7. Doprawianie
        danie.setStopien_przygotowania(90);
        danie.setAktualny_etap("DOPRAWIANIE");

        // 8. Wyświetlenie aktualnego stanu
        System.out.println("Aktualny stan:");
        wyswietlStan(danie);

        // 9. Cofnięcie do poprzedniego snapshotu
        zarzadca.undo();

        System.out.println("\nPo pierwszym UNDO:");
        wyswietlStan(danie);
    }

    private static void wyswietlStan(Danie danie) {
        System.out.println("Nazwa: " + danie.getNazwa());
        System.out.println("Stopień przygotowania: "
                + danie.getStopien_przygotowania() + "%");
        System.out.println("Składniki: " + danie.getSkladniki());
        System.out.println("Aktualny etap: " + danie.getAktualny_etap());
    }


    public static void run_abstract(){
        //generyczne podejście <T> ale dla złożonych typów jak lista wartości by trzeba było dopracować implementację
        Originator<Integer> originator = new Originator<>();

        originator.setValue(10);

        Caretaker<Integer> caretaker = new Caretaker<>(originator);

        caretaker.saveState();

        originator.setValue(20);
        caretaker.saveState();

        originator.setValue(30);

        System.out.println(originator.getValue());//30
        caretaker.undo();
        System.out.println(originator.getValue());//20
        caretaker.undo();
        System.out.println(originator.getValue());//10

    }

}
