package design_patterns.strukturalne.most.definition;

public class ConcreteImplementation_A implements ImplementationInterface{
    @Override
    public void createAction() {
        System.out.println("Some implementation of creation (A-style)");
    }

    @Override
    public void performAction() {
        System.out.println("Some action performance (A-style)");
    }

    @Override
    public void resetAction() {
        System.out.println("Some reset action (A-style)");
    }
}
