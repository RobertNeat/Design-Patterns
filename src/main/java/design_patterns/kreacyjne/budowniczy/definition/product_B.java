package design_patterns.kreacyjne.budowniczy.definition;

public class product_B{
    private int val_A;
    private long val_B;
    private boolean val_C;

    public product_B(builder_B builder){
        this.val_A=builder.getVal_A();
        this.val_B=builder.getVal_B();
        this.val_C=builder.isVal_C();
    }
}
