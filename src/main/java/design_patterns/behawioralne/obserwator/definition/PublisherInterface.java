package design_patterns.behawioralne.obserwator.definition;

//publikujący używający tego samego interfejsu udostępniają takie same metody, więc subskrybenci nie muszę znać ich dokładnej implementacji
public interface PublisherInterface {
    void subscribe(SubscriberInterface subscriber);
    void unsubscribe(SubscriberInterface subscriber);
    void notifySubscribers(String message);
}
