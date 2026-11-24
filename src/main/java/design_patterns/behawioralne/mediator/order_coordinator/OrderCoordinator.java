package design_patterns.behawioralne.mediator.order_coordinator;

import design_patterns.behawioralne.mediator.definition.ComponentClass_A;

public class OrderCoordinator implements MediatorInterface{
    private Kelner kelner;
    private Bar bar;
    private Kuchnia kuchnia;

    public OrderCoordinator(Kelner kelner,Bar bar,Kuchnia kuchnia){
        this.kelner=kelner;
        this.bar=bar;
        this.kuchnia=kuchnia;
    }


    @Override
    public void notify(AbstractComponent sender, String event) {
        if(sender instanceof Kelner && event.equals("KELNER")){
            //można zamowienie przekazać do kuchni i do baru
            bar.performActionBar(((Kelner) sender).numer_zamowienia_bar);
            kuchnia.performActionKuchnia(((Kelner) sender).numer_zamowienia_kuchnia);
        }

        if(sender instanceof Bar && event.equals("BAR")){
            System.out.println("Bar wykonał swoje zadania (koordynator potwierdza)");
        }

        if(sender instanceof Kuchnia && event.equals("KUCHNIA")){
            System.out.println("Kuchnia wykonała swoje zadania (koordynator potwierdza)");
        }
    }
}
