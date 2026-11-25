package design_patterns.behawioralne.strategia.definition;

public interface StrategyInterface {
    //definiuje jakie operacje ma każda strategia (jakie operacje może wywoływać kontekst)
    int execute(int a, int b);
}
