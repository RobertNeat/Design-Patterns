package design_patterns.behawioralne.metoda_szablonowa.definition;

public class ConcreteTamplate_A extends AbstractTemplate{
    @Override
    protected void stepOne() {
        System.out.println("[flavour A] Step 1");
    }

    @Override
    protected void stepTwo() {
        System.out.println("[flavour A] Step 2");
    }
}
