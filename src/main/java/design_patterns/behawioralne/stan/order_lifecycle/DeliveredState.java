package design_patterns.behawioralne.stan.order_lifecycle;

public class DeliveredState implements OrderState{
    @Override
    public void startPreparation(Order order) {
        throw new IllegalStateException("Cannot start preparation. Order has already been delivered.");
    }

    @Override
    public void markAsReady(Order order) {
        throw new IllegalStateException("Cannot mark order as ready. Order has already been delivered.");
    }

    @Override
    public void deliver(Order order) {
        throw new IllegalStateException("Cannot deliver order. Order has already been delivered.");
    }

    @Override
    public void cancel(Order order,String reason) {
        throw new IllegalStateException("Cannot cancel order. Order has already been delivered.");
    }
}
