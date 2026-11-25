package design_patterns.behawioralne.obserwator.order_status;

import java.util.ArrayList;

//wydzielenie zachowania subskrybcji do abstrakcji zamiast publisherinterface względem klasycznego podejścia
public abstract class AbstractPublisher {
    private ArrayList<SubscriberInterface> subscribers;

    public AbstractPublisher(){
        subscribers = new ArrayList<>();
    }

    public void subscribe(SubscriberInterface subscriber){
        if(!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    public void unsubscribe(SubscriberInterface subscriber){
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(String message, int procentWykonania){
        subscribers.forEach((subscriber)->{
            subscriber.update(message,procentWykonania);
        });
    }

}
