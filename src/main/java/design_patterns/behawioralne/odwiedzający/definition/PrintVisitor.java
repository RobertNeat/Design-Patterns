package design_patterns.behawioralne.odwiedzający.definition;

//KONKRETNY ODWIEDZAJĄCY -
public class PrintVisitor implements VisitorInterface{
    @Override
    public void visit(IntegerElement element) {
        System.out.println("Integer: "+element.getValueInteger());
    }

    @Override
    public void visit(DoubleElement element) {
        System.out.println("Double: "+element.getValueDouble());
    }
}
