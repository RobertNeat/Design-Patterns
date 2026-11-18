package design_patterns.strukturalne.fasada.skladanie_zamowienia.complex_skladanie_zamowienia;

import java.util.List;

//przechowuje listę zamówionych pozycji do realizacji
public class ZlozenieZamowienia {
    List<PozycjaZamowienia> elementy_zamowienia;

    public List<PozycjaZamowienia> getElementy_zamowienia() {
        return elementy_zamowienia;
    }

    public void dodajPozycje(PozycjaZamowienia pozycja){
        this.elementy_zamowienia.add(pozycja);
    }

    public void zrealizujZamowienie(){
        //zamowienie zrealizowane (przekazane do kuchni i wydania)
        elementy_zamowienia.clear();
    }

}
