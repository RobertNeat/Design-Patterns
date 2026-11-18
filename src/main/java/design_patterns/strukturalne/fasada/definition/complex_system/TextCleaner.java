package design_patterns.strukturalne.fasada.definition.complex_system;

public class TextCleaner {

    public String clean(String input){
        System.out.println("Cleaning text ...");
        return input.trim().replaceAll("\\s+"," ");
    }
}
