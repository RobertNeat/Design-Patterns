package design_patterns.strukturalne.most.definition;

//rozszerzona abstrakcja
public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(ImplementationInterface impl){
        super(impl);//wywołanie konstruktora klasy nadrzędnej - dobra praktyka
    }

    public void perform_create_reset(){
        impl.performAction();
        impl.createAction();
        impl.resetAction();
    }
}
