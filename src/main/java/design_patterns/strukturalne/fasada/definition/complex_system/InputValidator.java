package design_patterns.strukturalne.fasada.definition.complex_system;

public class InputValidator {
    public boolean validate(String input){
        if(input == null || input.isBlank()){
            throw new IllegalStateException(
                    "input cannot be empty"
            );
        }

        return true;
    }
}
