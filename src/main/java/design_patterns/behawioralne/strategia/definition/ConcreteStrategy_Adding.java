package design_patterns.behawioralne.strategia.definition;

//implementacja algorytmu 'dodawania' jako rodzaju algorytmu na dwóch liczbach
public class ConcreteStrategy_Adding implements StrategyInterface{
    @Override
    public int execute(int a, int b) {
        return a+b;
    }
}
