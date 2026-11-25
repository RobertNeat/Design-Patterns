package design_patterns.behawioralne.obserwator.order_status;

public class KelnerSubscriber implements SubscriberInterface{

    @Override
    public void update(String message, int procentWykonania) {
        System.out.println("[Kelner] otrzynamo powiadomienie:"+message+", wykonanie: "+procentWykonania);
    }
}
