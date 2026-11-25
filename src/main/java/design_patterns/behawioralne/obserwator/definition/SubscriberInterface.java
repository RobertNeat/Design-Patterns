package design_patterns.behawioralne.obserwator.definition;

//interfejs przez który publikujący powiadamia subskrybentów
public interface SubscriberInterface {
    void update(String message);//każdy subskrybent implementując interfejs udostępnia metodę update() dzięki której publisher może powiadamiać subskrybentów
}
