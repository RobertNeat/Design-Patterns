package design_patterns.behawioralne.mediator.order_coordinator;

import java.util.Random;

public class Kelner extends AbstractComponent{
    public String numer_zamowienia_bar;
    public String numer_zamowienia_kuchnia;

    public void performActionKelner(int numer_stolika){
        numer_zamowienia_bar = "#bar_"+new Random().nextInt(255) + 1;
        numer_zamowienia_kuchnia = "#kuchnia_"+new Random().nextInt(255) + 1;
        System.out.println("Odebranie zamowienia ze stolika: "+numer_stolika);
        mediator.notify(this,"KELNER");
    }
}
