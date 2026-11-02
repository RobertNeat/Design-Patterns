package design_patterns.kreacyjne.metoda_wytwórcza.definition;

public abstract class abstract_creator {
    public void use_product(){
        product_interface product = create_product();
        product.action_return_boolean(true);
    }

    public abstract product_interface create_product();
}
