package design_patterns.behawioralne.strategia.definition;

public class Context {
    //kontekst przechowuje strategię jako referencję typu interfejsowego, dlatego można podmieniać strategie
    StrategyInterface strategy;

    public Context(StrategyInterface strategy){
        this.strategy=strategy;
    }

    //metoda podmieniania strategii po utworzeniu obiektu kontekstu
    public void setStrategy(StrategyInterface strategy){
        this.strategy=strategy;
    }

    //metoda delegująca wykonanie strategii na podstawie tego co klient przekazał do strategii (kontekst nie wie jaka strategia to wykona)
    public int executeStrategy(int a, int b){
        return strategy.execute(a,b);
    }
}
