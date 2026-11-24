package design_patterns.behawioralne.mediator.order_coordinator;

public class Bar  extends AbstractComponent {

    public void performActionBar(String numer_zamowienia){
        System.out.println("Stworzenie drinków dla zamówienia: "+numer_zamowienia);
        mediator.notify(this,"BAR");
    }
}
