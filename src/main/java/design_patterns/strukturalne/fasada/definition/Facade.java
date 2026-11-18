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

    public String generateRaport(String input){
        if(!validator.validate(input)) {
            throw new IllegalStateException("Invalid input");
        }
        String cleaned = cleaner.clean(input);
        String content = generator.generate(cleaned);
        String report = formatter.format(content);
        return report;
    }

    //rozdzielenie logiki generowania raportu od zapisywania pozwala użyć ponowanie części generowania raportu w dodatkowej fasadzie
    public void generateAndSaveReport(String input){
        String report = generateRaport(input);
        System.out.println(report);
        saver.save(report);
    }

}
