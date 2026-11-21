package design_patterns.behawioralne.komenda.definition;

//interfejs POLECENIE
//definiuje metody konkretnych komend
public interface CommandInterface {
    void execute();
    void undo();//dodatkowa komenda na potrzeby CommandHistory aka. cofania komend
    //^ istnieje, ponieważ każda komenda musi wiedzieć jak odwrócić swoje działanie (implementacja wykonywania akcji odwrotnych)
}
