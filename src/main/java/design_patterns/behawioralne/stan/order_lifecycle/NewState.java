package design_patterns.behawioralne.stan.order_lifecycle;

import java.time.LocalDateTime;

public class NewState implements OrderState{
    @Override
    public void startPreparation(Order order) {
        order.setPreparationStartedAt(LocalDateTime.now());//modyfikacja kontekstu
        System.out.println("Order preparation started.");
        order.setState(new PreparingState());
    }

    @Override
    public void markAsReady(Order order) {
        throw new IllegalStateException("Cannot mark order as ready. Preparation has not started.");
    }

    @Override
    public void deliver(Order order) {
        throw new IllegalStateException("Cannot deliver order. Order has not been prepared.");
    }

    @Override
    public void cancel(Order order,String reason) {
        order.setCancelledAt(LocalDateTime.now());
        order.setCancellationReason(reason);
        System.out.println("Order has been cancelled.");
        order.setState(new CancelledState());
    }
}
