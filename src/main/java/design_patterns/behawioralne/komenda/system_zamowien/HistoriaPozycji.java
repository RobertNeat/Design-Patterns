package design_patterns.behawioralne.komenda.system_zamowien;

import java.util.Stack;

public class HistoriaPozycji {
    private Stack<InterfejsKomenda> history;

    public HistoriaPozycji(){
        this.history=new Stack<>();
    }

    public void executeCommand(InterfejsKomenda komenda){
        komenda.execute();
        history.push(komenda);
    }

    public void undoCommand(){
        if(!history.isEmpty()){
            InterfejsKomenda komenda = history.pop();
            komenda.undo();
        }else{
            System.out.println("Cannot undo command");
        }
    }
}
