package design_patterns.behawioralne.komenda.system_zamowien;

import java.util.ArrayList;
import java.util.List;

//standardowo klasa zamowienia powinna sama zmieniać swój stan, ale dla zmniejszenia boilercode implementuję zarządzanie 'pozycjeZamowienia' w konkretnych komendach
public class Zamowienie {
    public List<String> pozycjeZamowienia;

    public Zamowienie(){
        pozycjeZamowienia = new ArrayList<>();
    }
}
