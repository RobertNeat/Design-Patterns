package design_patterns.strukturalne.dekorator.dodatki_dan;

import java.util.List;

public class Dodatek extends BazowyDekorator{
    String dodatek_nazwa;

    public Dodatek(InterfejsDanie danie, String dodatek_nazwa){
        super(danie);
        this.dodatek_nazwa=dodatek_nazwa;
    }

    @Override
    public List<String> execute(){
        List<String> lista_skladnikow = danie.execute();
        lista_skladnikow.add(dodatek_nazwa);
        return lista_skladnikow;
    }
}
