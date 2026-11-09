package design_patterns.kreacyjne.budowniczy.definition;

public class builder_A implements builder{
    private int val_A;
    private long val_B;
    private boolean val_C;

    @Override
    public builder reset() {
        val_A=0;
        val_B=0;
        val_C=false;
        return this;
    }

    @Override
    public builder setValueA(int ValA) {
        this.val_A = ValA+1;
        return this;
    }

    @Override
    public builder setValueB(long ValB) {
        this.val_B = ValB+2;
        return this;
    }

    @Override
    public builder setValueC(Boolean ValC) {
        this.val_C = !ValC;
        return this;
    }

    public product_A getResult(){
        return new product_A(this);
    }

    public int getVal_A() {
        return val_A;
    }

    public long getVal_B() {
        return val_B;
    }

    public boolean isVal_C() {
        return val_C;
    }
}
