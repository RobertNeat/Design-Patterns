package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public class stolik_builder implements builder{
    String lista_zamowienia;
    String platnosc;
    Boolean danie_wydane;
    @Override
    public void reset() {
        this.lista_zamowienia="";
        this.platnosc="";
        this.danie_wydane=false;
    }

    @Override
    public void przyjecie() {
        this.lista_zamowienia="element1, element2, element3";
    }

    @Override
    public void realizacja() {
        this.lista_zamowienia+="cośtam domówione";
    }

    @Override
    public void przekazanie() {
        this.danie_wydane=true;
        this.platnosc="gotówka";
    }

    public zamowienie getResult(){
        zamowienie zam = new zamowienie(lista_zamowienia,platnosc,danie_wydane);
        this.reset();
        return zam;
    }
}
