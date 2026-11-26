package design_patterns.behawioralne.odwiedzający.definition;

public class SquareVisitor implements VisitorInterface{
    @Override
    public void visit(IntegerElement element) {
        System.out.println("Square integer: "+Math.pow(element.getValueInteger(),2));
    }

    @Override
    public void visit(DoubleElement element) {
        System.out.println("Square double: "+Math.pow(element.getValueDouble(),2));
    }
}
