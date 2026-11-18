package design_patterns.strukturalne.fasada.skladanie_zamowienia;

import design_patterns.strukturalne.fasada.skladanie_zamowienia.complex_skladanie_zamowienia.Platnosc;
import design_patterns.strukturalne.fasada.skladanie_zamowienia.complex_skladanie_zamowienia.PozycjaZamowienia;
import design_patterns.strukturalne.fasada.skladanie_zamowienia.complex_skladanie_zamowienia.ZlozenieZamowienia;

import java.util.List;

public class FacadeZlozenieZamowienia {
    List<PozycjaZamowienia> elementy_zamowienia;
    ZlozenieZamowienia zamowienie;
    Platnosc platnosc;

    public FacadeZlozenieZamowienia(List<PozycjaZamowienia> elementy_zamowienia){
        this.elementy_zamowienia=elementy_zamowienia;
        zamowienie = new ZlozenieZamowienia();
        platnosc = new Platnosc();
    }

    public Double kwotaPlatnosci(){
        return platnosc.calculateTotal(elementy_zamowienia);
    }

}
