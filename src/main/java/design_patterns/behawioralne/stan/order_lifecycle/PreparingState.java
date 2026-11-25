package design_patterns.behawioralne.stan.order_lifecycle;

import java.time.LocalDateTime;

public class PreparingState implements OrderState{
    @Override
    public void startPreparation(Order order) {
        throw new IllegalStateException("Cannot prepare. Order already in preparation state");
    }

    @Override
    public void markAsReady(Order order) {
        order.setPreparationFinishedAt(LocalDateTime.now());//modyfikacja kontekstu
        System.out.println("Order is ready for pickup.");
        order.setState(new ReadyState());
    }

    @Override
    public void deliver(Order order) {
        throw new IllegalStateException("Cannot deliver order. Order in preparation state.");
    }

    @Override
    public void cancel(Order order,String reason) {
        order.setCancelledAt(LocalDateTime.now());
        order.setCancellationReason(reason);
        System.out.println("Order has been cancelled.");
        order.setState(new CancelledState());
    }
}
