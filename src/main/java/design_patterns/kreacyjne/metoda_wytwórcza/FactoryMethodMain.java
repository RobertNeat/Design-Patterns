package design_patterns.kreacyjne.metoda_wytwórcza;
/*
* # KEY-DEFINITIONS:
* PRODUKT - interfejs, wspólny dla wszystkich klas produktów
* (konkretne) PRODUKTY - niezależne względem siebie typy produktów zgodne z klasą-produktem
* TWÓRCA - klasa deklarująca bazową metodę wytwórczą
* (konkretni) TWÓRCY - nadpisują bazową metodę wytwórczą zwracając różny typ produktów
*/

// Metoda wytwórcza na przykładzie kateogrii i dań
// klasa 'Danie' (interfejs) - jest produktem jaki otrzymuje klasa-klient, każdy produkt implementuje metody 'jedz()', i 'naczynie()'
// klasy 'Przystawka','Zupa','Danie Główne','Deser' - konkretne produkty jakie są produkowane
// klasa 'Fabryka Dań' (abstrakcyjna) - klasa-twórca deklarująca metodę wytwórczą, która zwraca nowe obiekty-produkty
// klasy 'Fabryka Przystawek','Fabryka Zup','Fabryka Dań Głównych', 'Fabryka Deserów' - konkretni twórcy nadpisujący metodę wytwórczą
// klient wywołuje inicjalizacje na 'Daniu' albo 'Fabryce Dań' i wywołuje zgodne akcje na wybanej klasie konkretnego produktu


import design_patterns.kreacyjne.metoda_wytwórcza.dania.FabrykaDan;
import design_patterns.kreacyjne.metoda_wytwórcza.dania.fabryki.FabrykaDanGlownych;
import design_patterns.kreacyjne.metoda_wytwórcza.dania.fabryki.FabrykaDeserow;
import design_patterns.kreacyjne.metoda_wytwórcza.definition.*;

public class FactoryMethodMain {
    public static void main(String[] args){
        run();
    }

    //wersja na przykładzie dań
    public static void run() {
        //na podstawie jakiegoś parametru wejściowego pobierana jest konkretna implementacja na której będą wywoływane metody
        boolean config=true;
        FabrykaDan obiekt;
        if(config){
            obiekt= new FabrykaDeserow();
        }else{
            obiekt= new FabrykaDanGlownych();
        }
        //...można tak ze wszystkimi fabrykami, tylko mi się nie chce wypisywać, bo i tak jak switcha bym wziął to by wybierał jeden przykład

        obiekt.atrybutyDania();

        obiekt.create_danie().zapach();
        obiekt.create_danie().smak();

        System.out.println("factory_method - dania");
    }

    // wersja abstrakcyjna bazująca na surowych definicjach
    public static void runAbstract() {

        //na podstawie jakiegoś parametru wejściowego pobierana jest konkretna implementacja na której będą wywoływane metody
        boolean config=true;
        abstract_creator obiekt;
        if(config){
            obiekt= new concrete_creator_A();
        }else{
            obiekt= new concrete_creator_B();
        }

        obiekt.create_product();
        obiekt.use_product();//poprawne użycie przez klasę kreatora (na przykład jakaś akcja zbiorowa na danym obiekcie tj. wywołanie wszystkich metod albo cos takiego)

        obiekt.create_product().action_return_string("abc");
        obiekt.create_product().action_return_boolean(true);
        obiekt.create_product().action_return_int(123);//poprawne użycie ptrzez klasę kreatora

        //! Uwaga, konsument nie może operować na product_interface ani concrete_product_* bo łamałoby to istnienie wzorca
        // Nie wykonywać bo łamie kompletnie wzorzec (podważa istnienie klas twórców i sprowadza wzorzec do zwykłego dziedziczenia):
        //      product_interface błędne = new concrete_product_A();
        //      błędne.action_return_string("abc");

        System.out.println("factory_method - definicje");
    }

}

