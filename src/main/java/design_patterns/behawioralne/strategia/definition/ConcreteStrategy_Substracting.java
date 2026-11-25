package design_patterns.behawioralne.strategia.definition;

//implementacja algorytmu 'odejmowania' jako rodzaju algorytmu na dwóch liczbach
public class ConcreteStrategy_Substracting implements StrategyInterface{
    @Override
    public int execute(int a, int b) {
        return a-b;
    }
}
