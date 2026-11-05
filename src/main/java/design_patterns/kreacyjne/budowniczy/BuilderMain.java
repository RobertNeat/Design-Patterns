package design_patterns.kreacyjne.budowniczy;

/*
* Tworzenie złożonych obiektów etapami
* dla m generalnych klas obiektów tworzy się 2m+2 klas i interfejsów
*
* BUDOWNICZY - interfejs deklaracji wspólnych kroków dla konkretnych budowniczych
* (konkretni) BUDOWNICZOWIE - implementacje konkretnych budowniczych o takich samych krokach wspólnych (nadzbiór możliwych kroków konkretnego obiektu)
* (konkretne) PRODUKTY - obiekty tworzone przez konkretnych budowniczych zależnych jedynie od konkretnego budowniczego (nie muszą zależeć od innych konkretnych produktów)
* KIEROWNIK - definiuje kolejność w jakiej należy wywołać etapy konstrukcyjne, ukrywa proces konstrukcyjny przed klientem
*
*
* BUDOWNICZY: builder
* (konkretni) BUDOWNICZOWIE: stolik_builder, dania_builder, uwagi_builder
* (konkretne) PRODUKTY: zamówienie, posilek, uwaga
* KIEROWNIK: restaurant_manager
*
* zamówienie kroki: przyjęcie, zamówienie, wydanie
* posiłek: przygotowanie składników, ugotowanie, wydanie
* uwagi: przyjęcie, (krok pomijaby specjalnie), przekazanie
* więc interfejs dla nich będzie przyjęcie, realizacja, przekazanie
 */

//Składanie złożonego zamówienia: stolik, dania, uwagi, kod rabatowy, napiwek
import design_patterns.kreacyjne.budowniczy.definition.*;
import design_patterns.kreacyjne.budowniczy.restaurant_builder.*;

public class BuilderMain {
     public static void main(String[] args){
          run();
     }

     public static void run() {
          //demonstracja wzorca
         restaurant_manager manager = new restaurant_manager();
         dania_builder builder1 = new dania_builder();
         manager.przygotuj_posilek(builder1);
         posilek pos = builder1.getResult();

         stolik_builder builder2 = new stolik_builder();
         manager.przygotuj_zamowienie(builder2);
         zamowienie zam = builder2.getResult();
     }

     public static void runabstract(){
          //przykład abstrakcyjny
         director director = new director();
         builder_A builder_1 = new builder_A();
         director.constructproduct_A(builder_1,12,123,true);
         product_A prod =  builder_1.getResult();
         builder_1.reset();
         //can use builder_1 again because of reset()

         builder_B builder_2 = new builder_B();
         director.constructproduct_B(builder_2,123);
         product_B prod_2 = builder_2.getResult();
     }

}


