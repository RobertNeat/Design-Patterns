package design_patterns.strukturalne.fasada.skladanie_zamowienia.complex_skladanie_zamowienia;

//przyjmuje kwotę całkowitą i nakłada procentowy rabat
public class Rabat {
    public Double applyRabat(Double value,int rabat){
        return value - ((value*rabat)/100);
    }
}
