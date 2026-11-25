package design_patterns.behawioralne.obserwator.order_status;

public interface PublisherInterface {
    void subscribe(SubscriberInterface subscriber);
    void unsubscribe(SubscriberInterface subscriber);
    void notifySubscribers(String message, int procentWykonania);
}
