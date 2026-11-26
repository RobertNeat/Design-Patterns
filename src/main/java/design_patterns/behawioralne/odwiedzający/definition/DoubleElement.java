package design_patterns.behawioralne.odwiedzający.definition;

//KONKRETNY ELEMENT
public class DoubleElement implements ElementInterface{
    private double value;

    public DoubleElement(double value){
        this.value=value;
    }

    public double getValueDouble(){
        return this.value;
    }

    //(podwójna dyspozycja) metoda przyjęcia odwiedzającego i przekazania swojego obiektu do jego metody
    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}
