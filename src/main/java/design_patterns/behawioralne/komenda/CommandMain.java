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
import design_patterns.behawioralne.komenda.system_zamowien.*;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CommandMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //Przykład skladania zamowienia w którym klient może dodawać lub usuwać swoje pozycje, zamawiać dodatkowe dania

        //KLASA NADAWCA
        //bieżąca metoda

        //interfejs POLECENIE
        //InterfejsKomenda

        //KONKRETNE POLECENIA
        //DodajPozycjeKomenda
        //UsunPozycjeKomenda

        //KLASA ODBIORCA
        //Zamowienie <--- zamowienie ktore trafia na kuchnie do realizacji

        //HistoriaPozycji <-- jeśli klient się rozmyśli z danej pozycji

        Zamowienie zamowienie = new Zamowienie();

        HistoriaPozycji historia = new HistoriaPozycji();

        InterfejsKomenda dodaj_zupa = new DodajPozycjeKomenda(zamowienie,"zupa");
        historia.executeCommand(dodaj_zupa);

        InterfejsKomenda dodaj_deser = new DodajPozycjeKomenda(zamowienie,"deser");
        historia.executeCommand(dodaj_deser);

        InterfejsKomenda usun_zupa = new UsunPozycjeKomenda(zamowienie,0);
        historia.executeCommand(usun_zupa);

        System.out.println(Arrays.toString(zamowienie.pozycjeZamowienia.toArray()));

        historia.undoCommand();


        System.out.println(Arrays.toString(zamowienie.pozycjeZamowienia.toArray()));


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