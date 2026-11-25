package design_patterns.behawioralne.stan.order_lifecycle;

import java.time.LocalDateTime;

public class ReadyState implements OrderState{
    @Override
    public void startPreparation(Order order) {
        throw new IllegalStateException("Cannot start preparation. Order is already ready.");
    }

    @Override
    public void markAsReady(Order order) {
        throw new IllegalStateException("Cannot mark order as ready. Order is already ready.");
    }

    @Override
    public void deliver(Order order) {
        order.setDeliveredAt(LocalDateTime.now());//modyfikacja kontekstu
        System.out.println("Danie wydane. Kelner wydaje gotowe danie do klienta");
        order.setState(new DeliveredState());
    }

    @Override
    public void cancel(Order order,String reason) {
        order.setCancelledAt(LocalDateTime.now());
        order.setCancellationReason(reason);
        System.out.println("Order has been cancelled.");
        order.setState(new CancelledState());
    }
}
