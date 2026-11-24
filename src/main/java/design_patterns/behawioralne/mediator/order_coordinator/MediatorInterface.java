package design_patterns.behawioralne.mediator.order_coordinator;

import design_patterns.behawioralne.mediator.order_coordinator.AbstractComponent;

public interface MediatorInterface {
    public void notify(AbstractComponent sender, String event);
}
