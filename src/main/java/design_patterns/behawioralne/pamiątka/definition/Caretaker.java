package design_patterns.behawioralne.pamiątka.definition;

import java.util.ArrayDeque;
import java.util.Deque;

public class Caretaker<T> {
    //przechowuje referencję do originator
    Originator<T> originator;

    //przechowuje listę obiektów migawek (stos LIFO)
    Deque<Originator.Memento<T>> shapshot_history; //<-- tutaj coś nie tak z typami mam (zadeklarowaliśmy klasę pamiatki jako private)

    public Caretaker(Originator<T> originator){
        this.originator=originator;
        this.shapshot_history=new ArrayDeque<>();
    }

    public void saveState(){
        Originator.Memento<T> saved_memento = originator.save();
        shapshot_history.push(saved_memento);
    }

    public void undo(){
        if(!shapshot_history.isEmpty()){
            Originator.Memento<T> popped_memento = shapshot_history.pop();
            originator.restore(popped_memento);
        }
    }
}
