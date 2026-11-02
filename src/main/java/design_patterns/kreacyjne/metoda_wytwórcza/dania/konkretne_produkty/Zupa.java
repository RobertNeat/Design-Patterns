package design_patterns.kreacyjne.metoda_wytwórcza.dania.konkretne_produkty;

import design_patterns.kreacyjne.metoda_wytwórcza.dania.Danie;

public class Zupa implements Danie {
    @Override
    public String zapach(){
        return "wodnisty i wilgotny";
    }
    @Override
    public String smak(){
        return "kremowy smak";
    }

}
