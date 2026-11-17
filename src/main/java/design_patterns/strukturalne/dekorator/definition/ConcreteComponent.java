package design_patterns.strukturalne.dekorator.definition;

public class ConcreteComponent implements ComponentInterface{
    private String value_str;

    public ConcreteComponent(String value_str) {
        this.value_str=value_str;
    }

    @Override
    public String execute() {
        return value_str;
    }
}
