package design_patterns.kreacyjne.budowniczy.definition;

public class director {
    public void constructproduct_A(builder builder, int val_A, long val_B, boolean val_C){
        //the order is known by the director
        builder.setValueA(val_A);
        builder.setValueC(val_C);
        builder.setValueB(val_B);
    }
    public void constructproduct_B(builder builder, int val_A){
        builder.setValueC(true);
        builder.setValueB(123);
        builder.setValueA(val_A);
    }
}
