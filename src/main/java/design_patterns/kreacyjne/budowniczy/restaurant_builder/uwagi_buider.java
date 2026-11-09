package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public class uwagi_buider implements builder{
    String notatka;

    @Override
    public builder reset() {
        notatka="";
        return this;
    }

    @Override
    public builder przyjecie() {
        notatka="uwagi klienta";
        return this;
    }

    @Override
    public builder realizacja() {
        //uwaga nie ma realizacji, celowy brak implementacji
        return this;
    }

    @Override
    public builder przekazanie() {
        notatka+=",podpis osoby przyjmującej";
        return this;
    }

    public uwaga getResult(){
        uwaga uw=new uwaga(this);
        this.reset();
        return uw;
    }
}
