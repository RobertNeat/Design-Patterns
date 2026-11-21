package design_patterns.behawioralne.komenda;


/*
* Zamiana żądania w samodzielny obiekt zawierający wszystkie informacje o żądaniu. Pozawala na parametryzowanie metod na podstawie typu żądania, opóźnianie i kolejkowanie wykonania żądań, a także cofanie operacji.
*
* KLASA NADAWCA - klasa odpowiedzialna za inicjowanie żądań, zawiera pole zawierające odwołanie do obiektu polecenie. Nadawca uruchamia polecenie zamiast przesyłać żądanie do odbiorcy. Nadawca otrzymuje obiekt polecenie za pomocą konstruktora od klienta.
* interfejs POLECENIE - deklaruje pojedynczą metodą służącą wykonaniu polecenia.
* KONKRETNE POLECENIA - implementują różne rodzaje żądań, nie powinny wykonywać pracy samodzielnie (przekazują pracę do obiektów logiki biznesowej). Parametry żądania są zadeklarowane jako pola konkretnego polecenia. Obiekty poleceń są niezmienialne, a inicjalizacja pól wykonuje się za pośrednictwem konstruktora (tj. interfejs POLECENIE definiuje jedynie metodę wykonania polecenia, a klasy KONKRETNE POLECENIA tworzą własne konstruktory jakie potrzebują z różną ilością parametrów).
* KLASA ODBIORCA - zawiera logikę biznesową, odbiorcy wykonują działania (konkretną pracę).
*
*
* */

import design_patterns.behawioralne.komenda.definition.*;

public class CommandMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //Operacje na zamówieniu jako obiekty, z możliwością cofnięcia: dodaj danie, usuń danie
    }

    public static void run_abstract(){
        //KLASA NADAWCA
        //bieżąca metoda

        //interfejs POLECENIE
        //CommandInterfce

        //KONKRETNE POLECENIA:
        //CommandCopy
        //CommandPaste
        //CommandCut
        //*cofanie akcji nie jest częścią komend, lecz historii

        //KLASA ODBIORCA:
        //TextEditor

        //COMMAND HISTORY – dodatkowy mechanizm historii i cofania
        //CommandHistory

        TextEditor editor = new TextEditor();
        editor.setTextAt("Ala",0);
        editor.setTextAt("ma",1);
        editor.setTextAt("kota",2);

        CommandHistory editor_history = new CommandHistory();

        CommandInterface copy_command = new CommandCopy(editor,1);
        editor_history.executeCommand(copy_command);
        //copy_command.execute(); <-- błędny sposób omijający historię

        CommandInterface paste_Command = new CommandPaste(editor,3);
        editor_history.executeCommand(paste_Command);
        //paste_Command.execute(); <-- błędny sposób omijający historię

        System.out.println("[EDITOR copy-paste]:"+editor.getText());

        CommandInterface cut_command = new CommandCut(editor,0);
        editor_history.executeCommand(cut_command);
        //cut_command.execute(); <-- błędny sposób omijający historię

        System.out.println("[EDITOR cut]:"+editor.getText());

        editor_history.undoCommand();
        editor_history.undoCommand();
        editor_history.undoCommand();

        System.out.println("[EDITOR restore]:"+editor.getText());

    }
}