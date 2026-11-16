package design_patterns.strukturalne.kompozyt.skladniki_dan;

import java.util.Map;

public interface Komponent {
    Map<String,Integer> execute_skladniki();//metoda zapewniająca zwracanie składników
    // (dania zwracają z czego są zrobione, a kategorie sumują ilości posczególnych kałdników dla swoich dań)
}
