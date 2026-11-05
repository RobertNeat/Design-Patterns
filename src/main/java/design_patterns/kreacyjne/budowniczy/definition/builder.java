package design_patterns.kreacyjne.budowniczy.definition;

//deklaruje etapy budowania dla każdego z konkretnych budowniczych
//typy przekazywane do poszczególnych metod mogą być innymi klasami - dla prostoty przekazanie typów standardowych
public interface builder {
    void reset();//pozwala na wielokrone używanie tej samej instancji budowniczego do twoirzenia następnych obiektów
    void setValueA(int ValA);
    void setValueB(long ValB);
    void setValueC(Boolean ValC);
}
