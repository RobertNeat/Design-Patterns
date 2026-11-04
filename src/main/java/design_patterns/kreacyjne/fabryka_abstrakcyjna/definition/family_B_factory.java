package design_patterns.kreacyjne.fabryka_abstrakcyjna.definition;

public class family_B_factory implements global_facory{
    @Override
    public product_A create_product_a(){
        return new product_A_family_B();
    }
    @Override
    public product_B create_product_b(){
        return new product_B_family_B();
    }
}
