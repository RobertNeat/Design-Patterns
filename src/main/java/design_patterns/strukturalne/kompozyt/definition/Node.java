package design_patterns.strukturalne.kompozyt.definition;

import java.util.ArrayList;
import java.util.List;

public class Node implements Komponent{
    private List<Komponent> children = new ArrayList<>();

    public void add(Komponent komponent){
        children.add(komponent);
    }

    public void remove(Komponent child){
        children.remove(child);
    }

    public List<Komponent> getChildren(){
        return children;
    }

    //metoda wykonująca pracę oddelegowuje pracę liściom i node zwraca ostateczny wynik
    @Override
    public int execute() {
        int compound_value = 0;
        for (Komponent komponent:children){
            compound_value+=komponent.execute();
        }
        return compound_value;
    }
}
