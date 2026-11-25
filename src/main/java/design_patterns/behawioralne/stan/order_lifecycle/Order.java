package design_patterns.behawioralne.stan.order_lifecycle;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

//Context
public class Order {
    private OrderState state;

    String orderId;		//Unikalny identyfikator zamówienia.
    String customerName;//Imię klienta składającego zamówienie.
    List<String> items;	//Lista produktów w zamówieniu.
    double totalPrice;	//Łączna cena zamówienia.
    LocalDateTime createdAt;//Data i godzina złożenia zamówienia.

    //informacje modyfikowane na różnych etapach
    private LocalDateTime preparationStartedAt;
    private LocalDateTime preparationFinishedAt;
    private LocalDateTime deliveredAt;
    private LocalDateTime cancelledAt;
    private String cancellationReason;

    public Order(String customerName, List<String> items){
        this.state=new NewState();//poczatkowy stan to zawsze stan 'NewState'

        this.orderId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.customerName=customerName;
        this.items=items;
        this.totalPrice = Math.round(
                ThreadLocalRandom.current().nextDouble(20.0, 150.0) * 100.0
        ) / 100.0;
        this.createdAt=LocalDateTime.now();
    }

    //metoda przypisania nowego stanu
    public void setState(OrderState state) {
        this.state = state;
    }

    //metody delegujące
    public void startPreparation() {
        state.startPreparation(this);
    }
    public void markAsReady() {
        state.markAsReady(this);
    }
    public void deliver() {
        state.deliver(this);
    }
    public void cancel(String reason) {
        state.cancel(this, reason);
    }

    //metoda pobrania obiektu stanu
    public OrderState getCurrentState() {
        return state;
    }

    public void displayOrderInfo() {

        System.out.println("===== ORDER INFO =====");

        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Items: " + items);
        System.out.println("Total price: " + totalPrice + " PLN");

        System.out.println("Created at: " + createdAt);
        System.out.println("Preparation started: " + preparationStartedAt);
        System.out.println("Preparation finished: " + preparationFinishedAt);
        System.out.println("Delivered at: " + deliveredAt);
        System.out.println("Cancelled at: " + cancelledAt);
        System.out.println("Cancellation reason: " + cancellationReason);

        System.out.println("Current state: " +
                state.getClass().getSimpleName());

        System.out.println("======================");
    }


    //gettery i settery

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getPreparationStartedAt() {
        return preparationStartedAt;
    }

    public void setPreparationStartedAt(LocalDateTime preparationStartedAt) {
        this.preparationStartedAt = preparationStartedAt;
    }

    public LocalDateTime getPreparationFinishedAt() {
        return preparationFinishedAt;
    }

    public void setPreparationFinishedAt(LocalDateTime preparationFinishedAt) {
        this.preparationFinishedAt = preparationFinishedAt;
    }

    public LocalDateTime getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(LocalDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public LocalDateTime getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(LocalDateTime cancelledAt) {
        this.cancelledAt = cancelledAt;
    }

    public String getCancellationReason() {
        return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
        this.cancellationReason = cancellationReason;
    }
}
