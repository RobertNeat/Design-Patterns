package design_patterns.strukturalne.fasada.definition.complex_system;

public class ReportFormatter {
    public String format(String content){
        System.out.println("Formatting report ...");
        return """
                =====================
                    REPORT
                =====================
                
                %s
                
                =====================
                """.formatted(content);
    }
}
