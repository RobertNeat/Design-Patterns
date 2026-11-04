package design_patterns.kreacyjne.fabryka_abstrakcyjna;

import design_patterns.kreacyjne.fabryka_abstrakcyjna.definition.*;
import design_patterns.kreacyjne.fabryka_abstrakcyjna.kuchnie_swiata.*;

/*
* Używanie różnych 'rodzin' różnych 'klas produktów'
* dla m 'rodzin produktów' i n 'typów produktów' tworzy się (m*n)+m+n+1 klas i interfejsów
*
* # KEY-DEFINITIONS:
* PRODUKTY - interfejsy wspólne dla 'typów produktów' w różnych 'rodzinach produktów'
* (konkretne) PRODUKTY - implementacje konkretnych produktów według 'rodzin produktów'
* FABRYKA ABSTRAKCYJNA - interfejs fabryki tworzący dany 'typ produktów'
* (konkretne) FABRYKI - implementują metody wytwórcze dla danego 'typu produktów' dla konkretnej 'rodziny produktów'
*
* Przykład bardziej abstrakcjyjny /definition
* Produkty: product_A, product_B
* konkretne PRODUKTY: product_A_family_A, product_B_family_A, product_B_family_A, product_B_family_B
* FABRYKA ABSTRAKCYJNA: global_facory
* konkretne Fabryki: family_A_factory, family_B_factory
*
* Fabryka abstrakcyjna na przykładzie zestawów menu zależnych od typu kuchni (rodzaje posiłków x kuchnie regionalene)
* Produkty: zupa, glowne, deser
* konkretne PRODUKTY: zupa_wloska, glowne_włoskie, deser_wloski, zupa_polska, glowne_polskie, deser_polski, zupa_niemiecka, danie_niemieskie, deser_niemiecki
* FABRYKA ABSTRAKCYJNA: kuchnia
* konkretne Fabryki: kuchnia_wloska, kuchnia_polska, kuchnia_niemiecka
*
 */
public class AbstractFactoryMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //aplikacja inicjalizuje kuchnię
        kuchnia kuchnia;

        //jeśli jesteśmy w restauracji włoskiej to jemy włoskie jedzenie (ustawienie konkretnej fabryki w zależności od parametru)
        if (true) {
            kuchnia = new kuchnia_wloska();
        }

        //kuchnia tworzy poszczególne dania (klienta nie obchodzi to jaka to jest kuchnia ani kto ostatecznie przygotuje danie)
        //dla klienta jest jedyne, że zpodziewa się, że zupa będzie w miseczce, danie główne na talerzu, a deser na talerzyku
        zupa zup = kuchnia.create_zupa();
        glowne gl = kuchnia.create_glowne();
        deser des = kuchnia.create_deser();

        //klient operuje na daniach nie zwracając uwagi na to jakie danie otrzymał, ale wie, że może wykonać określone operacje na określonym interfejsie, więc może używać otrzymane obiekty
        System.out.println(zup.funkcja_zupy());
        System.out.println(gl.funkcja_glownego());
        System.out.println(des.funkcja_deseru());
    }

    // wersja abstrakcyjna bazująca na surowych definicjach
    public static void runAbstract() {
        //aplikacja inicjalizuje fabrykę abstrakcyjną
        global_facory factory;

        //na podstawie konfiguracji inicjalizowana jest odpowiednia fabryka
        if(true){
            factory = new family_A_factory();
        }else{
            factory = new family_B_factory();
        }

        //kod kliencki wykonuje tworzenie obiektów z wykorzystaniem abstrakcyjnego interfejsu
        // i wykonuje operacje z na interfejsach
        product_A prod_a = factory.create_product_a();
        prod_a.fun_a();
        prod_a.fun_b();

        product_B prod_b = factory.create_product_b();
        prod_b.fun_c();
        prod_b.fun_d();
    }
}


