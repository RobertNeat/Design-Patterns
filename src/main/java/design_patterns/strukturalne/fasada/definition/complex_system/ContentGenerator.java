package design_patterns.strukturalne.fasada.definition.complex_system;

public class ContentGenerator {
    public String generate(String input){
        System.out.println("Generating content ...");
        return "Generated repost based on: "+input;
    }
}
