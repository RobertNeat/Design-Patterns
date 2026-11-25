package design_patterns.behawioralne.obserwator.definition;

public class ConcreteSubscriber_A implements SubscriberInterface{
    @Override
    public void update(String message) {
        //konkretni subskrybenci jedynie implementują jak będą reagowali na wywołania metody update
        System.out.println("ConcreteSubscriber_A:"+message);
    }
}
