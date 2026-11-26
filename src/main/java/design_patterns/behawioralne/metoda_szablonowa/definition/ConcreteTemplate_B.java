package design_patterns.behawioralne.metoda_szablonowa.definition;

public class ConcreteTemplate_B extends AbstractTemplate{
    @Override
    protected void stepOne() {
        System.out.println("[flavour B] Step 1");
    }

    @Override
    protected void stepTwo() {
        System.out.println("[flavour B] Step 2");
    }

    @Override
    protected void hookAfterStepOne(){
        System.out.println("[flavour B] post step 1 hook implementation");
    }
}
