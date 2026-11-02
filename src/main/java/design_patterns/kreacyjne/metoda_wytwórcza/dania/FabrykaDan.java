package design_patterns.kreacyjne.metoda_wytwórcza.dania;

public abstract class FabrykaDan {
    public void atrybutyDania(){
        Danie danie = create_danie();
        System.out.println(danie.smak());
        System.out.println(danie.zapach());
    }
    public abstract Danie create_danie();
}
