package design_patterns.kreacyjne.fabryka_abstrakcyjna.definition;

public class product_A_family_B implements product_A{

    @Override
    public String fun_a(){
        return "product A family B";
    }

    @Override
    public char fun_b(){
        return 'b';
    }
}
