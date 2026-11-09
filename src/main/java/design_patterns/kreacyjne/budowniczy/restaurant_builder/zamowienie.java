package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public class zamowienie {
    String lista_zamowienia;
    String platnosc;
    Boolean danie_wydane;

    public zamowienie(stolik_builder builder) {
        this.lista_zamowienia = builder.lista_zamowienia;
        this.platnosc = builder.platnosc;
        this.danie_wydane = builder.danie_wydane;
    }
}
