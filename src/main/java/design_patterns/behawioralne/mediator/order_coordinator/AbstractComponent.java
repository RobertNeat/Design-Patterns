package design_patterns.behawioralne.mediator.order_coordinator;

public abstract class AbstractComponent {
    protected MediatorInterface mediator;

    public void setMediator(MediatorInterface mediator){
        this.mediator=mediator;
    }

}
