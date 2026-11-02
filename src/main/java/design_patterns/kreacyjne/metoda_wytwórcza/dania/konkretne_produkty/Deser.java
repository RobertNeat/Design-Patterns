package design_patterns.kreacyjne.metoda_wytwórcza.dania.konkretne_produkty;

import design_patterns.kreacyjne.metoda_wytwórcza.dania.Danie;

public class Deser implements Danie {
    @Override
    public String zapach(){
        return "owocowy";
    }
    @Override
    public String smak(){
        return "słodki";
    }

}
