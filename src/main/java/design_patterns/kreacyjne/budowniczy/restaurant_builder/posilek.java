package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public class posilek {
    private final int talerz;
    private final String skladniki;
    public posilek(dania_builder builder){//int talerz, String skladniki){
        this.skladniki=builder.skladniki;
        this.talerz= builder.talerz;
    }
}
