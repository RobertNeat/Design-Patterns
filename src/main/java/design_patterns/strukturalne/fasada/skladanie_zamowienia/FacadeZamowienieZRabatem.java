package design_patterns.strukturalne.fasada.skladanie_zamowienia;

import design_patterns.strukturalne.fasada.skladanie_zamowienia.complex_skladanie_zamowienia.PozycjaZamowienia;
import design_patterns.strukturalne.fasada.skladanie_zamowienia.complex_skladanie_zamowienia.Rabat;

import java.util.List;

public class FacadeZamowienieZRabatem {
    FacadeZlozenieZamowienia zamowienie_zwykle;
    Rabat rabat;

    public FacadeZamowienieZRabatem(List<PozycjaZamowienia> sklad_zamowienia){
        this.zamowienie_zwykle=new FacadeZlozenieZamowienia(sklad_zamowienia);
        rabat=new Rabat();
    }

    public Double cenaZRabatem(int rabat){
        return this.rabat.applyRabat(zamowienie_zwykle.kwotaPlatnosci(), rabat);
    }
}
