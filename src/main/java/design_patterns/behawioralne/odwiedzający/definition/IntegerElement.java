package design_patterns.behawioralne.odwiedzający.definition;

//KONKRETNY ELEMENT
public class IntegerElement implements ElementInterface{
    private int value;

    public IntegerElement(int value){
        this.value=value;
    }

    public int getValueInteger(){
        return this.value;
    }

    //(podwójna dyspozycja) metoda przyjęcia odwiedzającego i przekazania swojego obiektu do jego metody
    @Override
    public void accept(VisitorInterface visitor) {
        visitor.visit(this);
    }
}
