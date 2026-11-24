package design_patterns.behawioralne.mediator.definition;

public class ComponentClass_A extends AbstractComponent{
    //metoda reprezentująca konkretną logikę biznesową klasy ComponentClass_A
    public void performActionA(){
        System.out.println("A_COMPLETED");
        mediator.notify(this,"ComponentClass_A executed business logic");
    }
}
