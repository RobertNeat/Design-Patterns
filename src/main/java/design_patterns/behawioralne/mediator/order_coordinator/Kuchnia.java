package design_patterns.behawioralne.mediator.order_coordinator;

public class Kuchnia extends AbstractComponent{
    public void performActionKuchnia(String numer_zamowienia){
        System.out.println("Odebranie zamowienia ze stolika: "+numer_zamowienia);
        mediator.notify(this,"KUCHNIA");
    }
}
