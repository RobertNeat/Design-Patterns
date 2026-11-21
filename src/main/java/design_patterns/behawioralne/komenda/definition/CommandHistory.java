package design_patterns.behawioralne.komenda.definition;

import java.util.Stack;

//COMMAND HISTORY – dodatkowy mechanizm historii i cofania (nie jest częścią wzorca komenda, ale rozszerzeniem pozwalającym na cofanie akcji)
public class CommandHistory {
    //implementacja śledzenia stosu LIFO (last in first out) wykonanych komend
    //dzięki wykorzystaniu stosu można przywrócić działania w odwrotnej kolejności wykonywania i otrzymać ten sam stan edutora
    private Stack<CommandInterface> history;

    public CommandHistory(){
        this.history=new Stack<>();
    }

    //metoda opakowująca wykonanie komendy (wykonuje komendę i po wykonaniu odnotowuje jej wykonanie w historii)
    public void executeCommand(CommandInterface command){
        command.execute();//execute command
        this.history.push(command);//add command to LIFO for history tracking
    }

    //metoda cofania komend za pomocą historii (cofania pojedynczej komendy)
    public void undoCommand() {
        if (this.history.isEmpty()) {
            System.out.println("[history] Nothing to undo!");
            return;
        }

        CommandInterface last_command = this.history.pop();//get last command from LIFO
        last_command.undo();//undo the last command
    }
}
