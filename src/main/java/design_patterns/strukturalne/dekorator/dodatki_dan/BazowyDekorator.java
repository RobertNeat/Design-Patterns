package design_patterns.strukturalne.dekorator.dodatki_dan;

import java.util.List;

public class BazowyDekorator implements InterfejsDanie{
    InterfejsDanie danie;

    BazowyDekorator(InterfejsDanie danie){
        this.danie=danie;
    }

    @Override
    public List<String> execute() {
        return danie.execute();
    }
}
