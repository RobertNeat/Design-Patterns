package design_patterns.kreacyjne.budowniczy.definition;

public class builder_B implements builder{
    private int val_A;
    private long val_B;
    private boolean val_C;

    @Override
    public void reset() {
        val_A=0;
        val_B=0;
        val_C=false;
    }

    @Override
    public void setValueA(int ValA) {
        this.val_A = ValA-1;
    }

    @Override
    public void setValueB(long ValB) {
        this.val_B = ValB-2;
    }

    @Override
    public void setValueC(Boolean ValC) {
        this.val_C = ValC;
    }

    public product_B getResult(){
        product_B result = new product_B(this.val_A, this.val_B, this.val_C);
        reset();
        return result;
    }
}
