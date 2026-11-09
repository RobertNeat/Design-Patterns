package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public interface builder {
    builder reset();
    builder przyjecie();
    builder realizacja();
    builder przekazanie();
}
