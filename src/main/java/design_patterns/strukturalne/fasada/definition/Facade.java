package design_patterns.strukturalne.fasada.definition;

import design_patterns.strukturalne.fasada.definition.complex_system.*;

public class Facade {
    InputValidator validator;
    TextCleaner cleaner;
    ContentGenerator generator;
    ReportFormatter formatter;
    ReportSaver saver;


    public Facade(){
        validator = new InputValidator();
        cleaner = new TextCleaner();
        generator = new ContentGenerator();
        formatter = new ReportFormatter();
        saver = new ReportSaver();
    }

    public void generateRaport(String input){
        if(validator.validate(input)){
        String cleaned = cleaner.clean(input);
        String content = generator.generate(cleaned);
        String report = formatter.format(content);
        System.out.println("Wynegerowany raport:\n"+report);
        saver.save(report);
        }
        else{
            System.out.println("Raport could not be generated");
        }
    }

}
