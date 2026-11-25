package design_patterns.behawioralne.stan.order_lifecycle;

public interface OrderState {
    void startPreparation(Order order);//Rozpoczęcie przygotowywania zamówienia.
    void markAsReady(Order order);  //Oznaczenie zamówienia jako gotowego.
    void deliver(Order order);      //Wydanie zamówienia klientowi.
    void cancel(Order order, String reason);       //Anulowanie zamówienia.
}
