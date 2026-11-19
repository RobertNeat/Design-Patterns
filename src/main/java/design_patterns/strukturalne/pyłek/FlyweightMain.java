package design_patterns.strukturalne.pyłek;

/*
* Wzorzec optymalizacyjny pozwalający przechowywać większą ilość obiektów (tego samego typu) w tej samej ilości pamięci RAM poprzez przechowywanie w pamięci podręcznej części wspólnej danych różnych obiektów.
*
* STAN WEWNĘTRZNY - dane niezmienne (jedynie do odczytu) w ramach wielu instancji obiektu. Dane które się powielają między obiektami tej samej klasy są zapisywane w klasie-pyłku.
* STAN ZEWNĘTRZNY - dane zmienne (indywidualne w ramach danej instancji), są przechowywane indywidualnie dla każdej instancji. Jest przechowywany poza obiektem w obiekcie kontenerowym (kontekst).
*
* PYŁEK - klasa zawierająca współdzieloną porcję stanu pierwotnego obiektu, która może być współdzielona między wielona instancjami
* KONTEKST - klasa zawierająca unikalną porcję stanu pierwotnego obiektu. Gdy kontekts zostanie skojarzony z klasą-pyłek otrzymywana jest pełna reprezentacja stanu pierwotnego obiektu.
* FABRYKA PYŁKÓW - zarządza pulą istniejących pyłków, jeśli żądany pyłek nie istnieje to zostaje stworzony. Fabryka pozwala na reużywanie tych samych obiektów-pyłków w różnych kontekstach.
*
* */

import design_patterns.strukturalne.pyłek.alergeny_i_potwary.Alergen;
import design_patterns.strukturalne.pyłek.alergeny_i_potwary.FabrykaAlergenów;
import design_patterns.strukturalne.pyłek.alergeny_i_potwary.Potrawa;
import design_patterns.strukturalne.pyłek.definition.Context;
import design_patterns.strukturalne.pyłek.definition.Flyweight;
import design_patterns.strukturalne.pyłek.definition.FlyweightFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FlyweightMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        // współdzielenie alergenów w różnych konfiguracjach między potrawami
        // każdy alergen posiada swoje właściwości

        int ilosc_potraw = 100;

        List<Potrawa> lista_potraw = new ArrayList<>();
        List<Alergen> lista_alergenow = new ArrayList<>();

        Random random = new Random();

        // stworzenie alergenów
        String[][] dane_alergenow = {
                {"Gluten", "Białka występujące w pszenicy, życie i jęczmieniu"},
                {"Mleko", "Mleko i produkty mleczne"},
                {"Jaja", "Białka jaj kurzych i innych ptaków"},
                {"Orzeszki ziemne", "Orzeszki ziemne i produkty pochodne"},
                {"Orzechy włoskie", "Orzechy włoskie i produkty pochodne"},
                {"Orzechy laskowe", "Orzechy laskowe i produkty pochodne"},
                {"Migdały", "Migdały i produkty pochodne"},
                {"Nerkowce", "Orzechy nerkowca i produkty pochodne"},
                {"Pistacje", "Pistacje i produkty pochodne"},
                {"Orzechy pekan", "Orzechy pekan i produkty pochodne"},
                {"Orzechy brazylijskie", "Orzechy brazylijskie i produkty pochodne"},
                {"Orzechy makadamia", "Orzechy makadamia i produkty pochodne"},
                {"Soja", "Soja i produkty pochodne"},
                {"Seler", "Seler i produkty pochodne"},
                {"Gorczyca", "Gorczyca i produkty pochodne"},
                {"Sezam", "Nasiona sezamu i produkty pochodne"},
                {"Łubin", "Łubin i produkty pochodne"},
                {"Ryby", "Ryby i produkty pochodne"},
                {"Skorupiaki", "Krewetki, kraby i homary"},
                {"Mięczaki", "Małże, ostrygi, kalmary i ślimaki"},
                {"Dwutlenek siarki", "Dwutlenek siarki i siarczyny"},
                {"Truskawki", "Truskawki i produkty pochodne"},
                {"Kiwi", "Kiwi i produkty pochodne"},
                {"Brzoskwinie", "Brzoskwinie i produkty pochodne"},
                {"Jabłka", "Jabłka i produkty pochodne"},
                {"Banany", "Banany i produkty pochodne"},
                {"Pomarańcze", "Pomarańcze i produkty pochodne"},
                {"Cytryny", "Cytryny i produkty pochodne"},
                {"Ananasy", "Ananasy i produkty pochodne"},
                {"Awokado", "Awokado i produkty pochodne"},
                {"Marchew", "Marchew i produkty pochodne"},
                {"Pomidory", "Pomidory i produkty pochodne"},
                {"Czosnek", "Czosnek i produkty pochodne"},
                {"Cebula", "Cebula i produkty pochodne"},
                {"Papryka", "Papryka i produkty pochodne"},
                {"Kukurydza", "Kukurydza i produkty pochodne"},
                {"Kakao", "Kakao i produkty pochodne"},
                {"Kawa", "Kawa i produkty pochodne"},
                {"Cynamon", "Cynamon i produkty pochodne"},
                {"Wanilia", "Wanilia i produkty pochodne"},
                {"Miód", "Miód i produkty pochodne"},
                {"Drożdże", "Drożdże i produkty pochodne"},
                {"Groszek", "Groszek i produkty pochodne"},
                {"Soczewica", "Soczewica i produkty pochodne"},
                {"Ciecierzyca", "Ciecierzyca i produkty pochodne"},
                {"Fasola", "Fasola i produkty pochodne"},
                {"Mak", "Nasiona maku i produkty pochodne"},
                {"Słonecznik", "Nasiona słonecznika i produkty pochodne"},
                {"Pestki dyni", "Pestki dyni i produkty pochodne"},
                {"Orzeszki piniowe", "Orzeszki piniowe i produkty pochodne"}
        };

        // stworzenie alergenów
        for (int i = 0; i < dane_alergenow.length; i++) {
            Alergen alergen = FabrykaAlergenów.getAlergen(
                    i,
                    dane_alergenow[i][0],
                    dane_alergenow[i][1]
            );

            lista_alergenow.add(alergen);
        }

        //potrawy
        String[][] dane_potraw = {
                {"Pizza Margherita",
                        "Mąka pszenna;Mozzarella;Pomidory;Bazylia;Oliwa z oliwek",
                        "Przygotuj ciasto;Rozprowadź sos pomidorowy;Dodaj mozzarellę i bazylię;Piecz w wysokiej temperaturze"},

                {"Spaghetti Carbonara",
                        "Makaron spaghetti;Jajka;Boczek;Parmezan;Pieprz",
                        "Ugotuj makaron;Podsmaż boczek;Wymieszaj jajka z parmezanem;Połącz składniki z makaronem"},

                {"Naleśniki",
                        "Mąka pszenna;Mleko;Jajka;Masło;Cukier",
                        "Przygotuj ciasto naleśnikowe;Rozgrzej patelnię;Usmaż cienkie naleśniki;Podawaj z dodatkami"},

                {"Sałatka grecka",
                        "Pomidor;Ogórek;Feta;Oliwki;Czerwona cebula;Oliwa z oliwek",
                        "Pokrój warzywa;Pokrusz fetę;Dodaj oliwki;Polej oliwą i wymieszaj"},

                {"Szarlotka",
                        "Mąka pszenna;Masło;Jajka;Jabłka;Cukier;Cynamon",
                        "Przygotuj kruche ciasto;Obierz i pokrój jabłka;Dodaj cynamon;Ułóż warstwy i upiecz"},

                {"Zupa pomidorowa",
                        "Pomidory;Marchew;Pietruszka;Seler;Makaron;Śmietana",
                        "Przygotuj wywar warzywny;Dodaj pomidory;Gotuj do miękkości;Dodaj śmietanę i makaron"},

                {"Omlet",
                        "Jajka;Mleko;Masło;Szczypiorek;Sól",
                        "Roztrzep jajka z mlekiem;Rozgrzej masło;Wlej masę jajeczną;Smaż do ścięcia"},

                {"Pierogi ruskie",
                        "Mąka pszenna;Ziemniaki;Twaróg;Cebula;Masło",
                        "Przygotuj ciasto;Ugotuj ziemniaki;Przygotuj farsz z twarogiem i cebulą;Ulep pierogi i ugotuj"},

                {"Brownie",
                        "Czekolada;Masło;Jajka;Mąka pszenna;Cukier;Orzechy włoskie",
                        "Rozpuść czekoladę z masłem;Ubij jajka z cukrem;Połącz składniki;Piecz do uzyskania wilgotnego środka"},

                {"Hummus",
                        "Ciecierzyca;Tahini;Czosnek;Cytryna;Oliwa z oliwek;Sezam",
                        "Ugotuj ciecierzycę;Dodaj tahini i czosnek;Zblenduj składniki;Dodaj sok z cytryny i oliwę"}
        };

        // stworzenie potraw z alergenami
        for (int i = 0; i < ilosc_potraw; i++) {

            String[] dane = dane_potraw[i % dane_potraw.length];

            List<String> skladniki = new ArrayList<>(
                    Arrays.asList(dane[1].split(";"))
            );

            List<String> kroki_przygotowania = new ArrayList<>(
                    Arrays.asList(dane[2].split(";"))
            );

            List<Alergen> alergeny_potrawy = new ArrayList<>();

            int ilosc_alergenow_potrawy = random.nextInt(5) + 1;

            for (int j = 0; j < ilosc_alergenow_potrawy; j++) {
                Alergen alergen = lista_alergenow.get(
                        random.nextInt(lista_alergenow.size())
                );

                if (!alergeny_potrawy.contains(alergen)) {
                    alergeny_potrawy.add(alergen);
                }
            }

            Potrawa potrawa = new Potrawa(
                    dane[0] + "_" + i,
                    skladniki,
                    kroki_przygotowania
            );

            potrawa.lista_alergenow = alergeny_potrawy;

            lista_potraw.add(potrawa);
        }

        // demonstracja
        System.out.println("Liczba potraw: " + lista_potraw.size());
        System.out.println("Liczba unikalnych alergenów: " + lista_alergenow.size());

        lista_potraw.get(0).wypisz_alergeny_potrawy();
    }

    public static void run_abstract(){
        //klient tworzy sobie wiele obiektów
        int ilosc_obiektow = 200;
        Random random = new Random();

        int value_x;
        int value_y;
        int value_z;

        Flyweight flyweight = FlyweightFactory.getFlyweight("object_1","#1a2b3c");

        //lista na dużą ilość obietów kontekstu
        List<Context> context_list = new ArrayList<>();

        for(int i=0;i<=ilosc_obiektow;i++){
             value_x = random.nextInt(255) + 1;
             value_y = random.nextInt(255) + 1;
             value_z = random.nextInt(255) + 1;

             Context new_context = new Context(value_x, value_y, value_z, flyweight);
             context_list.add(new_context);
        }
    }
}
