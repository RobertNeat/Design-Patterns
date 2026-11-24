package design_patterns.behawioralne.mediator.definition;

public class ComponentClass_C extends AbstractComponent{
    //metoda reprezentująca konkretną logikę biznesową klasy ComponentClass_C
    public void performActionC(){
        System.out.println("C_COMPLETED");
        mediator.notify(this,"ComponentClass_C executed business logic");
    }
}
