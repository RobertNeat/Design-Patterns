package design_patterns.kreacyjne.metoda_wytwórcza.dania.fabryki;

import design_patterns.kreacyjne.metoda_wytwórcza.dania.Danie;
import design_patterns.kreacyjne.metoda_wytwórcza.dania.FabrykaDan;
import design_patterns.kreacyjne.metoda_wytwórcza.dania.konkretne_produkty.DanieGlowne;

public class FabrykaDanGlownych  extends FabrykaDan {
    @Override
    public Danie create_danie(){
        return new DanieGlowne();
    }
}
