package design_patterns.kreacyjne.budowniczy.definition;

public class product_A {
    private final int val_A;
    private final long val_B;
    private final Boolean val_C;
    public product_A(builder_A builder){
        this.val_A=builder.getVal_A();
        this.val_B=builder.getVal_B();
        this.val_C=builder.isVal_C();
    }

}
