package design_patterns.strukturalne.dekorator.dodatki_dan;

import java.util.List;

public class Danie implements InterfejsDanie{
    private List<String> skladniki_dania;

    public Danie(List<String> skladniki_dania){
        this.skladniki_dania=skladniki_dania;
    }

    @Override
    public List<String> execute() {
        return skladniki_dania;
    }
}
