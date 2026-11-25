package design_patterns.behawioralne.stan.order_lifecycle;

public class CancelledState implements OrderState{
    @Override
    public void startPreparation(Order order) {
        throw new IllegalStateException("Cannot start preparation. Order has been cancelled.");
    }

    @Override
    public void markAsReady(Order order) {
        throw new IllegalStateException("Cannot mark order as ready. Order has been cancelled.");
    }

    @Override
    public void deliver(Order order) {
        throw new IllegalStateException("Cannot deliver order. Order has been cancelled.");
    }

    @Override
    public void cancel(Order order, String reason) {
        throw new IllegalStateException("Cannot cancel order. Order has already been cancelled.");
    }
}
