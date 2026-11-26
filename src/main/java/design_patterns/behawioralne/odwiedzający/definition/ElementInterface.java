package design_patterns.behawioralne.odwiedzający.definition;

//INTERFEJS ELEMENT - deklaruje metodę przyjmowania odwiedzającego
public interface ElementInterface {
    void accept(VisitorInterface visitor);
}
