package design_patterns.behawioralne.pamiątka;


/*
* Pozwala zapisywać i przywracać wcześniejszy stan obiektu bez ujawniania szczegółów jego implementacji.
*
* ŹRÓDŁO (originator) - tworzy migawki swojego stanu i przywraca wcześniejszy stan z migawek.
* PAMIĄTKA (memento) - klasa zagnieżdżona w klasie źródło, tworzy niezmienny obiekt pamiątki stanu źródła na polecenie obiektu źródło
* ZARZĄDCA (caretaker) - zarządza historią migawek stanu źródła, decyduje kiedy tworzyć i przywracać migawki.
*
*
* Źródło wykonuje faktyczne operacje tworzenia pamiątek i przywracania. Zarządca jedynie je przechowuje historię (listę obiektów snapshotów które zostały stworzone po drodze).
*
* */

import design_patterns.behawioralne.pamiątka.definition.Caretaker;
import design_patterns.behawioralne.pamiątka.definition.Originator;

public class MementoMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //demonstracja wzorca
        System.out.println("memento");
    }

    public static void run_abstract(){
        //generyczne podejście <T> ale dla złożonych typów jak lista wartości by trzeba było dopracować implementację
        Originator<Integer> originator = new Originator<>();

        originator.setValue(10);

        Caretaker<Integer> caretaker = new Caretaker<>(originator);

        caretaker.saveState();

        originator.setValue(20);
        caretaker.saveState();

        originator.setValue(30);

        System.out.println(originator.getValue());//30
        caretaker.undo();
        System.out.println(originator.getValue());//20
        caretaker.undo();
        System.out.println(originator.getValue());//10

    }

}
