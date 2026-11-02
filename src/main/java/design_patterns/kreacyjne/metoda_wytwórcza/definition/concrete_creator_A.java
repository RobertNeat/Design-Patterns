package design_patterns.kreacyjne.metoda_wytwórcza.definition;

public class concrete_creator_A extends abstract_creator{
    @Override
    public product_interface create_product(){
        return new concrete_product_A();
    }
}
