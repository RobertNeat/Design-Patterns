package design_patterns.behawioralne.pamiątka.etapy_przygotowania_dan;

import java.util.ArrayDeque;
import java.util.Deque;

public class Zarzadca {
    Danie danie;
    Deque<Danie.Memento> snapshot_history;

    public Zarzadca(Danie danie){
        this.danie=danie;
        this.snapshot_history=new ArrayDeque<>();
    }

    public void saveState(){
        Danie.Memento saved_memento = danie.save();
        snapshot_history.push(saved_memento);
    }


    public void undo(){
        if(!snapshot_history.isEmpty()){
            Danie.Memento popped_memento = snapshot_history.pop();
            danie.restore(popped_memento);
        }
    }
}
