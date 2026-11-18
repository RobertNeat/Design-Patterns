package design_patterns.strukturalne.fasada.definition;

public class AdditionalFacade {
    private final Facade facade;

    public AdditionalFacade(Facade facade){
        this.facade=facade;
    }

    public void generatePreview(String input){
        System.out.println("Generating report preview ...");
        String report = facade.generateRaport(input);
        System.out.println(report);
        System.out.println("Preview generated!");
    }
}
