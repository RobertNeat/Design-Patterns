package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public class uwaga {
    String notatka;

    public uwaga(uwagi_buider builder) {
        this.notatka = builder.notatka;
    }
}
