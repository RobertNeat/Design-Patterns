package design_patterns.behawioralne.odwiedzający.definition;

//INTERFEJS ODWIEDZAJACY - deklaruje zestaw metod odwiedzania dla każdego typu odwiedzanego
public interface VisitorInterface {
    void visit(IntegerElement element);
    void visit(DoubleElement element);
}
