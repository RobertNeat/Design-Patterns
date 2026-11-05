package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public class zamowienie {
    String lista_zamowienia;
    String platnosc;
    Boolean danie_wydane;

    public zamowienie(String lista_zamowienia, String platnosc, Boolean danie_wydane) {
        this.lista_zamowienia = lista_zamowienia;
        this.platnosc = platnosc;
        this.danie_wydane = danie_wydane;
    }
}
