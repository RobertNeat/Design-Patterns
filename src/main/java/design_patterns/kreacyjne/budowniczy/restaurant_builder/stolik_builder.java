package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public class stolik_builder implements builder{
    String lista_zamowienia;
    String platnosc;
    Boolean danie_wydane;
    @Override
    public builder reset() {
        this.lista_zamowienia="";
        this.platnosc="";
        this.danie_wydane=false;
        return this;
    }

    @Override
    public builder przyjecie() {
        this.lista_zamowienia="element1, element2, element3";
        return this;
    }

    @Override
    public builder realizacja() {
        this.lista_zamowienia+="cośtam domówione";
        return this;
    }

    @Override
    public builder przekazanie() {
        this.danie_wydane=true;
        this.platnosc="gotówka";
        return this;
    }

    public zamowienie getResult(){
        zamowienie zam = new zamowienie(this);
        this.reset();
        return zam;
    }
}
