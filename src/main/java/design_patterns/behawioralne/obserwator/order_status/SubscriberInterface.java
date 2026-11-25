package design_patterns.behawioralne.obserwator.order_status;

public interface SubscriberInterface {
    void update(String message, int procentWykonania);
}
