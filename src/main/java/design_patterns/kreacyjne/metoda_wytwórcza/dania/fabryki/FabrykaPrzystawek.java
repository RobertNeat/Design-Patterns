package design_patterns.kreacyjne.metoda_wytwórcza.dania.fabryki;

import design_patterns.kreacyjne.metoda_wytwórcza.dania.Danie;
import design_patterns.kreacyjne.metoda_wytwórcza.dania.FabrykaDan;
import design_patterns.kreacyjne.metoda_wytwórcza.dania.konkretne_produkty.Przystawka;

public class FabrykaPrzystawek  extends FabrykaDan {
    @Override
    public Danie create_danie(){
        return new Przystawka();
    }
}
