package design_patterns.behawioralne.obserwator.definition;

import java.util.ArrayList;

public class Publisher implements PublisherInterface{

    //lista subskrybentów
    private ArrayList<SubscriberInterface> subscribers;

    public Publisher(){
        subscribers=new ArrayList<>();
    }

    //metoda subskrybowania dla konkretnych subskrybentów
    public void subscribe(SubscriberInterface subscriber){
        if(!subscribers.contains(subscriber)) {//zabezpieczenie przed wielokrotnym zasubskrybowaniem
            subscribers.add(subscriber);
        }
    }

    //metoda un-subskrybowania dla konkretnych subskrybentów
    public void unsubscribe(SubscriberInterface subscriber){
        subscribers.remove(subscriber);
    }

    //metoda którą publisher wykorzystuje, żeby powiadamiać zasubskrybowanych odbiorców
    public void notifySubscribers(String message){
        subscribers.forEach((subscriber)->{
            subscriber.update(message);
        });
    }

    public void changeState(String newState){
        System.out.println("Publisher: Zmiana stanu w 'jakiejs' metodzie publishera");
        notifySubscribers(newState);// <-- wiadomość nowego stanu jest przekazywana subskrybentom
    }
}
