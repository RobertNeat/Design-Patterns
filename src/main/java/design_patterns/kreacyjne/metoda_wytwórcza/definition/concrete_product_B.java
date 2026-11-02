package design_patterns.kreacyjne.metoda_wytwórcza.definition;

public class concrete_product_B implements product_interface{
    @Override
    public String action_return_string(String input){
        return input.toUpperCase();
    }

    @Override
    public int action_return_int(int input){
        if(input > 0){
            return input%3;
        }
        return 0;
    }

    @Override
    public boolean action_return_boolean(boolean input){
        return input;
    }
}
