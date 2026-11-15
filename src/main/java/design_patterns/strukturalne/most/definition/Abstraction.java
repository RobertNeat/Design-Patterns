package design_patterns.strukturalne.most.definition;

public class Abstraction implements AbstractionInterface{
    protected ImplementationInterface impl;

    public Abstraction(ImplementationInterface impl) {
        this.impl = impl;
    }

    @Override
    public void perform_reset() {
        impl.performAction();
        impl.resetAction();
    }

    @Override
    public void perform_create() {
        impl.performAction();
        impl.createAction();
    }
}
