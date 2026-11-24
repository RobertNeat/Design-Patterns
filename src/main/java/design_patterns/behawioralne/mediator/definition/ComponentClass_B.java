package design_patterns.behawioralne.mediator.definition;

public class ComponentClass_B extends AbstractComponent{
    //metoda reprezentująca konkretną logikę biznesową klasy ComponentClass_B
    public void performActionB(){
        System.out.println("B_COMPLETED");
        mediator.notify(this,"ComponentClass_B executed business logic");
    }
}
