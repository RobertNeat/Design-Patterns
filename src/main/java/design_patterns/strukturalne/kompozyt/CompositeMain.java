package design_patterns.strukturalne.kompozyt;


/*
* Komponowanie obiektów w struktury drzewiaste i traktowanie ich jako oddzielnych obiektów
*
* KOMPONENT - wspólny interfejs jaki implementują kompozyty (pojemniki) i liście, definiuje wspólne zacowanie jakie będą dostarczały liście i node
* KOMPOZYT (node) - klasa opakowująca która zawiera inne kompozyty albo liście (lista jako pole klasy), komunikuje się ze swoją zawartością poprzez interfejs komponentu, jeśli otrzyma polecenie to deleguje zadania zwoim elementom podrzędnym i zwraca wynik zbiorczy (może wykonywać dodatkowe operacje na danych uzyskanych od swoich podelementów
* LISC (leaf) -podstawowy element drzewa, który wykonuje docelowe operacje, nie posiadają elementów podrzędnych
*
* */

import design_patterns.strukturalne.kompozyt.definition.Leaf;
import design_patterns.strukturalne.kompozyt.definition.Node;
import design_patterns.strukturalne.kompozyt.skladniki_dan.Danie;
import design_patterns.strukturalne.kompozyt.skladniki_dan.Kategoria;

import java.util.Map;

public class CompositeMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //przykład z wyznaczaniem jakich składników trzeba na pokrycie całego menu
        // kategoria - pojemnik na damnia (w menu występuje wiele kategorii takie jak "zupy", "przystawki", "dania główne", "desery")
        // danie - liść składający się ze składników

        //    Menu
        //    |
        //    |-- Zupy
        //    |   |-- Zupy krem
        //    |   |   |-- Krem pomidorowy
        //    |   |   |-- Krem z dyni
        //    |   |
        //    |   |-- Zupy tradycyjne
        //    |       |-- Rosół
        //    |       |-- Żurek
        //    |
        //    |-- Przystawki
        //    |   |-- Przystawki zimne
        //    |   |   |-- Bruschetta
        //    |   |   |-- Sałatka grecka
        //    |   |
        //    |   |-- Przystawki ciepłe
        //    |       |-- Grzanki czosnkowe
        //    |       |-- Pieczarki faszerowane
        //    |
        //    |-- Dania główne
        //    |   |-- Dania mięsne
        //    |   |   |-- Kurczak grillowany
        //    |   |   |-- Schabowy
        //    |   |
        //    |   |-- Dania wegetariańskie
        //    |       |-- Risotto
        //    |       |-- Makaron ze szpinakiem
        //    |
        //    |-- Desery
        //        |-- Desery na zimno
        //        |   |-- Sernik na zimno
        //        |   |-- Tiramisu
        //        |
        //        |-- Desery na ciepło
        //            |-- Szarlotka
        //            |-- Brownie


        // ==========================================
        // ZUPY
        // ==========================================

        Kategoria zupy = new Kategoria();

        Kategoria zupyKrem = new Kategoria();
        Kategoria zupyTradycyjne = new Kategoria();

        zupyKrem.add(new Danie(Map.of(
                "pomidory", 3,
                "cebula", 1,
                "czosnek", 2,
                "śmietana", 1
        )));

        zupyKrem.add(new Danie(Map.of(
                "dynia", 4,
                "cebula", 1,
                "czosnek", 1,
                "śmietana", 1
        )));

        zupyTradycyjne.add(new Danie(Map.of(
                "kurczak", 2,
                "marchew", 2,
                "pietruszka", 1,
                "seler", 1
        )));

        zupyTradycyjne.add(new Danie(Map.of(
                "kiełbasa", 2,
                "ziemniaki", 3,
                "czosnek", 2,
                "śmietana", 1
        )));

        zupy.add(zupyKrem);
        zupy.add(zupyTradycyjne);


        // ==========================================
        // PRZYSTAWKI
        // ==========================================

        Kategoria przystawki = new Kategoria();

        Kategoria przystawkiZimne = new Kategoria();
        Kategoria przystawkiCieple = new Kategoria();

        przystawkiZimne.add(new Danie(Map.of(
                "chleb", 2,
                "pomidory", 3,
                "czosnek", 1,
                "oliwa", 2
        )));

        przystawkiZimne.add(new Danie(Map.of(
                "pomidor", 2,
                "ogórek", 2,
                "ser feta", 3,
                "oliwki", 2,
                "cebula", 1
        )));

        przystawkiCieple.add(new Danie(Map.of(
                "chleb", 3,
                "czosnek", 3,
                "masło", 2,
                "ser żółty", 2
        )));

        przystawkiCieple.add(new Danie(Map.of(
                "pieczarki", 4,
                "ser żółty", 2,
                "cebula", 1,
                "masło", 1
        )));

        przystawki.add(przystawkiZimne);
        przystawki.add(przystawkiCieple);


        // ==========================================
        // DANIA GŁÓWNE
        // ==========================================

        Kategoria daniaGlowne = new Kategoria();

        Kategoria daniaMiesne = new Kategoria();
        Kategoria daniaWegetarianskie = new Kategoria();

        daniaMiesne.add(new Danie(Map.of(
                "kurczak", 3,
                "ziemniaki", 4,
                "czosnek", 2,
                "masło", 2,
                "marchew", 1
        )));

        daniaMiesne.add(new Danie(Map.of(
                "schab", 3,
                "ziemniaki", 4,
                "jajka", 2,
                "bułka tarta", 2,
                "masło", 1
        )));

        daniaWegetarianskie.add(new Danie(Map.of(
                "ryż", 3,
                "pieczarki", 3,
                "cebula", 2,
                "masło", 2,
                "ser żółty", 2
        )));

        daniaWegetarianskie.add(new Danie(Map.of(
                "makaron", 3,
                "szpinak", 3,
                "czosnek", 2,
                "śmietana", 2,
                "ser żółty", 2
        )));

        daniaGlowne.add(daniaMiesne);
        daniaGlowne.add(daniaWegetarianskie);


        // ==========================================
        // DESERY
        // ==========================================

        Kategoria desery = new Kategoria();

        Kategoria deseryNaZimno = new Kategoria();
        Kategoria deseryNaCieplo = new Kategoria();

        deseryNaZimno.add(new Danie(Map.of(
                "twaróg", 3,
                "śmietana", 2,
                "cukier", 2,
                "galaretka", 1
        )));

        deseryNaZimno.add(new Danie(Map.of(
                "mascarpone", 3,
                "kawa", 2,
                "cukier", 2,
                "jajka", 2
        )));

        deseryNaCieplo.add(new Danie(Map.of(
                "jabłka", 4,
                "mąka", 3,
                "masło", 2,
                "cukier", 2,
                "cynamon", 1
        )));

        deseryNaCieplo.add(new Danie(Map.of(
                "czekolada", 4,
                "mąka", 2,
                "masło", 2,
                "jajka", 2,
                "cukier", 2
        )));

        desery.add(deseryNaZimno);
        desery.add(deseryNaCieplo);


        // ==========================================
        // MENU GŁÓWNE
        // ==========================================

        Kategoria menu = new Kategoria();

        menu.add(zupy);
        menu.add(przystawki);
        menu.add(daniaGlowne);
        menu.add(desery);


        // ==========================================
        // WYNIK
        // ==========================================

        System.out.println("Całe menu: " + menu.execute_skladniki());

        System.out.println("Zupy: " + zupy.execute_skladniki());
        System.out.println("Przystawki: " + przystawki.execute_skladniki());
        System.out.println("Dania główne: " + daniaGlowne.execute_skladniki());
        System.out.println("Desery: " + desery.execute_skladniki());

    }


    public static void runAbstract(){
        Node tree = new Node();

        /*
        *      tree
        *     |    |
        *    n1   l1
        *   / |
        *  l2 n2
        *     |
        *     n3
        *     | \
        *     l3 l4
        * */

        Leaf l1 = new Leaf(1);
        Leaf l2 = new Leaf(2);
        Leaf l3 = new Leaf(3);
        Leaf l4 = new Leaf(4);

        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();

        n3.add(l3);
        n3.add(l4);

        n2.add(n3);

        n1.add(n2);
        n1.add(l2);

        tree.add(n1);
        tree.add(l1);

        System.out.println("Execute:"+tree.execute());
    }
}
