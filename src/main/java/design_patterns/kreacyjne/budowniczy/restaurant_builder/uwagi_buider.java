package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public class uwagi_buider implements builder{
    String notatka;

    @Override
    public void reset() {
        notatka="";
    }

    @Override
    public void przyjecie() {
        notatka="uwagi klienta";
    }

    @Override
    public void realizacja() {
        //uwaga nie ma realizacji, celowy brak implementacji
    }

    @Override
    public void przekazanie() {
        notatka+=",podpis osoby przyjmującej";
    }

    public uwaga getResult(){
        uwaga uw=new uwaga(this.notatka);
        this.reset();
        return uw;
    }
}
