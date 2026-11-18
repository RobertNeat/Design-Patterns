package design_patterns.strukturalne.fasada;

/*
* Dodanie uproszczonego interfejsu do istniejącego systemu i ukrycie złożoności
*
* FASADA - deklaruje klasę o oproszczonym interfejsie, deleguje swoje zadania innym klasom, zarządza całym cyklem życia używanych przez siebie obiektów.
* DODATKOWA FASADA -
* ZŁOŻONY PODSYSTEM -
*
*
*
*
* */


import design_patterns.strukturalne.fasada.definition.AdditionalFacade;
import design_patterns.strukturalne.fasada.definition.Facade;

public class FacadeMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //Jeden prosty punkt wejścia do składania zamówienia, który ukrywa kuchnię, płatności i rabaty
        System.out.println("facade");
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
