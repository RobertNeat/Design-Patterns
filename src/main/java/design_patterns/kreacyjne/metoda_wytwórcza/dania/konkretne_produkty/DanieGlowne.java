package design_patterns.kreacyjne.metoda_wytwórcza.dania.konkretne_produkty;

import design_patterns.kreacyjne.metoda_wytwórcza.dania.Danie;

public class DanieGlowne implements Danie {
    @Override
    public String zapach(){
        return "wyrafinowany";
    }
    @Override
    public String smak(){
        return "umami";
    }

}
