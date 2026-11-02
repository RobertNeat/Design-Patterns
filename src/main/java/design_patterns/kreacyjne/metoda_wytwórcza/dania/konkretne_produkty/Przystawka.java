package design_patterns.kreacyjne.metoda_wytwórcza.dania.konkretne_produkty;

import design_patterns.kreacyjne.metoda_wytwórcza.dania.Danie;

public class Przystawka implements Danie {
    @Override
    public String smak(){
        return "lekko-slony";
    }

    @Override
    public String zapach(){
        return "pieczywo";
    }
}
