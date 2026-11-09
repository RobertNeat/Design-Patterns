package design_patterns.kreacyjne.budowniczy.definition;

//deklaruje etapy budowania dla każdego z konkretnych budowniczych
//typy przekazywane do poszczególnych metod mogą być innymi klasami - dla prostoty przekazanie typów standardowych
public interface builder {
    builder reset();//pozwala na wielokrone używanie tej samej instancji budowniczego do twoirzenia następnych obiektów
    builder setValueA(int ValA);
    builder setValueB(long ValB);
    builder setValueC(Boolean ValC);
}
