package design_patterns.strukturalne.fasada;

/*
* Dodanie uproszczonego interfejsu do istniejącego systemu i ukrycie złożoności
*
* FASADA - deklaruje klasę o oproszczonym interfejsie, deleguje swoje zadania innym klasom, zarządza całym cyklem życia używanych przez siebie obiektów.
* DODATKOWA FASADA - rozszerza podstawową fasadę o dodatowe funkcjonalności albo wystawia inne zestawy metod
* ZŁOŻONY PODSYSTEM - system z wieloma klasami i metodami, których używanie może być skomplikowane dla klienta
*
* */


import design_patterns.strukturalne.fasada.definition.AdditionalFacade;
import design_patterns.strukturalne.fasada.definition.Facade;
import design_patterns.strukturalne.fasada.skladanie_zamowienia.FacadeZamowienieZRabatem;
import design_patterns.strukturalne.fasada.skladanie_zamowienia.FacadeZlozenieZamowienia;
import design_patterns.strukturalne.fasada.skladanie_zamowienia.complex_skladanie_zamowienia.PozycjaZamowienia;

import java.util.List;

public class FacadeMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //Jeden prosty punkt wejścia do składania zamówienia, który ukrywa kuchnię, płatności i rabaty
        System.out.println("facade");

        PozycjaZamowienia element_1 = new PozycjaZamowienia("frytki",1,11.2);
        PozycjaZamowienia element_2 = new PozycjaZamowienia("hamburger",2,13.5);
        PozycjaZamowienia element_3 = new PozycjaZamowienia("cola",1,8.5);
        List<PozycjaZamowienia> zamowienie_1 = List.of(element_1,element_2,element_3);

        FacadeZlozenieZamowienia facade_1 = new FacadeZlozenieZamowienia(zamowienie_1);
        System.out.println("Cena bez rabatu: "+facade_1.kwotaPlatnosci());

        FacadeZamowienieZRabatem facade_2 = new FacadeZamowienieZRabatem(zamowienie_1);
        System.out.println("Cena z rabatem 30%: "+facade_2.cenaZRabatem(30));
    }


    public static void run_abstract(){
        //complex_system zawiera 'system' obsługi raportów
        // - InputValidator - sprawdza poprawność danych wejściowych
        // - TextCleaner - usuwa zbędne spacje i znaki
        // - ContentGenerator - generuje treść raportu
        // - ReportFormatter - formatuje raport
        // - ReportSaver - zapisuje raport

        /*
        * Bez fasady klient musi znać wszystkie klasy i pamiętać o kolejności:
        * String input = "  Hello world!    ";
        * InputValidator validator = new InputValidator();
        * TextCleaner cleaner = new TextCleaner();
        * ReportFormatter formatter = new ReportFormatter();
        * ContentGenerator generator = new ContentGenerator();
        * ReportSaver saver = new ReportSaver();
        *
        * if(validator.validate(input)){
        * String cleaned = cleaner.clean(input);
        * String content = generator.generate(cleaned);
        * String report = formatter.format(content);
        * saver.save(report);
        * }
        */

        //fasada podstawowa - tworzy raporty i zapisuje
        Facade facade = new Facade();
        facade.generateAndSaveReport("  Hello world!    ");

        //fasada rozszerzona - generuje podgląd raportu bez zapisywania
        AdditionalFacade preview_facade = new AdditionalFacade(facade);
        preview_facade.generatePreview("    PREVIEW ONLY!   ");

    }
}
