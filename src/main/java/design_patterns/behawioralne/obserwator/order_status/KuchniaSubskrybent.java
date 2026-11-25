package design_patterns.behawioralne.obserwator.order_status;


public class KuchniaSubskrybent implements SubscriberInterface {

    @Override
    public void update(String message, int procentWykonania) {
        System.out.println("[Kuchnia] otrzynamo powiadomienie:"+message+", wykonanie: "+procentWykonania);
    }
}
