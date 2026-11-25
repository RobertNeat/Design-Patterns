package design_patterns.behawioralne.stan;

/*
* Pozwala obiektowi zmienić swoje zachowanie, gdy zmieni się jego stan wewnętrzny.
*
* KONTEKST - przechowuje odniesienie do jednego z konkretnych obiektów-stanów i deleguje mu zadania specyficzne dla danego stanu. Komunikuje się z obiektem stanu za pośrednictwem interfejsu.
* INTERFEJS STANU - deklaruje metody specyficzne poszczególnych stanów.
* KONKRETNE STANY - dostarczają własne implementacje metod dla poszczególnych stanów, inicjują zmianę stanu, przechowują referencję do obiektu kontekstu i mogą pobierać z niego dowolne informacje.
*
* skończona liczba stanów w której program może się znajdować
* reguły przejść między stamami są określone i znane
* */

import design_patterns.behawioralne.stan.definition.Context;
import design_patterns.behawioralne.stan.definition.State_A;
import design_patterns.behawioralne.stan.order_lifecycle.Order;

import java.util.List;

public class StateMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //Cykl życia zamówienia: nowe, w przygotowaniu, gotowe, wydane, anulowane

        //kontekst: Order
        //interfejs stanu: OrderState
        //konkretne stany: NewState, PreparingState, ReadyState, DeliveredState, CancelledState

        //Definicje stanów:
        // Nowe (New) – zamówienie zostało złożone i oczekuje na rozpoczęcie przygotowania.
        //--- Zamówienie zostało przyjęte przez restaurację.
        //--- Zamówienie oczekuje na rozpoczęcie przygotowania przez kuchnię.
        //--- Można rozpocząć przygotowywanie zamówienia.
        //--- Nie można oznaczyć zamówienia jako gotowe, ponieważ nie rozpoczęto jego przygotowania.
        //--- Nie można wydać zamówienia, ponieważ nie zostało jeszcze przygotowane.
        //--- Zamówienie może zostać anulowane.

        // W przygotowaniu (InPreparation) – kuchnia rozpoczęła przygotowywanie zamówienia.
        //--- Zamówienie zostało przekazane do realizacji przez kuchnię.
        //--- Kuchnia aktualnie przygotowuje zamówienie.
        //--- Nie można ponownie rozpocząć przygotowywania zamówienia, ponieważ już trwa.
        //--- Można oznaczyć zamówienie jako gotowe po zakończeniu przygotowywania.
        //--- Nie można wydać zamówienia, ponieważ nie zostało jeszcze przygotowane.
        //--- Zamówienie może zostać anulowane.

        //Gotowe (Ready) – zamówienie zostało przygotowane i oczekuje na odbiór.
        //--- Kuchnia zakończyła przygotowywanie zamówienia.
        //--- Zamówienie oczekuje na odbiór.
        //--- Klient może odebrać zamówienie.
        //--- Zamówienie może zostać anulowane.

        //Wydane (Delivered) – zamówienie zostało odebrane przez klienta.
        //--- Klient odebrał zamówienie.
        //--- Zamówienie zostało zrealizowane.
        //--- Nie można ponownie przygotowywać zamówienia.
        //--- Nie można ponownie oznaczyć go jako gotowe.
        //--- Nie można ponownie wydać zamówienia.
        //--- Nie można anulować zamówienia, które zostało już wydane.

        //Anulowane (Cancelled) – zamówienie zostało anulowane.
        //--- Zamówienie zostało anulowane.
        //--- Nie można rozpocząć jego przygotowania.
        //--- Nie można oznaczyć go jako gotowe.
        //--- Nie można wydać go klientowi.
        //--- Nie można ponownie anulować zamówienia.


        // ==========================================
        // SCENARIUSZ 1: Standardowa realizacja zamówienia
        // ==========================================

        System.out.println("\n========== SCENARIUSZ 1 ==========");

        Order order1 = new Order(
                "Jan Kowalski",
                List.of("Pizza Margherita", "Cola")
        );

        // 1. Zamówienie zostaje złożone (NewState)
        order1.displayOrderInfo();

        // 2. Kuchnia rozpoczyna przygotowanie
        order1.startPreparation();
        order1.displayOrderInfo();

        // 3. Kuchnia kończy przygotowanie
        order1.markAsReady();
        order1.displayOrderInfo();

        // 4. Kelner wydaje zamówienie klientowi
        order1.deliver();
        order1.displayOrderInfo();


        // ==========================================
        // SCENARIUSZ 2: Anulowanie podczas przygotowania
        // ==========================================

        System.out.println("\n========== SCENARIUSZ 2 ==========");

        Order order2 = new Order(
                "Anna Nowak",
                List.of("Burger", "Frytki", "Sok")
        );

        // 1. Zamówienie zostaje złożone
        order2.displayOrderInfo();

        // 2. Kuchnia rozpoczyna przygotowanie
        order2.startPreparation();

        // 3. Klient anuluje zamówienie
        order2.cancel("Zmowienie anulowane przez klienta");

        order2.displayOrderInfo();


        // ==========================================
        // SCENARIUSZ 3: Próba niedozwolonej operacji
        // ==========================================

        System.out.println("\n========== SCENARIUSZ 3 ==========");

        Order order3 = new Order(
                "Piotr Wiśniewski",
                List.of("Spaghetti", "Woda")
        );

        // Realizacja zamówienia
        order3.startPreparation();
        order3.markAsReady();
        order3.deliver();

        // Próba anulowania wydanego zamówienia
        try {
            order3.cancel("Zamowienie anulowane przez klienta");
        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        order3.displayOrderInfo();
    }

    public static void run_abstract() {
        // Inicjalizacja Context z początkowym stanem State_A
        Context context = new Context(new State_A());

        System.out.println("==Forward==");

        // Delegowanie operacji do aktualnego stanu (State_A)
        context.performAction(); // A → B | wypisanie: A
        context.displayData();
        context.performAction(); // B → C | wypisanie: B
        context.displayData();

        System.out.println("==Backward==");
        context.reverseDirection();

        context.performAction(); // C → B | wypisanie: C
        context.displayData();
        context.performAction(); // B → A | wypisanie: B
        context.displayData();
        context.performAction(); // A->C | wypisanie: A
        context.displayData();
    }
}
