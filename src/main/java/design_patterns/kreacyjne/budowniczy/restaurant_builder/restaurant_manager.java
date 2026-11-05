package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public class restaurant_manager {
    public void przygotuj_zamowienie(builder builder){
        builder.przyjecie();
        builder.przekazanie();
        builder.realizacja();
    }
    public void przygotuj_posilek(builder builder){
        builder.przekazanie();
        builder.przyjecie();
        builder.realizacja();
    }
    public void przygotuj_uwage(builder builder){
        builder.realizacja();
        builder.przekazanie();
        builder.przyjecie();
    }

}
