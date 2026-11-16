package design_patterns.strukturalne.kompozyt.skladniki_dan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kategoria implements Komponent{
    private List<Komponent> dania = new ArrayList<>();

    public void add(Komponent komponent){
        dania.add(komponent);
    }

    public void remove(Komponent child){
        dania.remove(child);
    }

    public List<Komponent> getChildren(){
        return dania;
    }

    @Override
    public Map<String, Integer> execute_skladniki() {
        Map<String,Integer> skladniki_sekcji = new HashMap<>();
        for(Komponent danie : dania){
            Map<String,Integer> skladniki_dania = danie.execute_skladniki();
            skladniki_dania.forEach((key,value)->{
                if(skladniki_sekcji.containsKey(key)){
                    skladniki_sekcji.replace(key,skladniki_sekcji.get(key),skladniki_sekcji.get(key)+value);
                }else{
                    skladniki_sekcji.put(key,value);
                }
            });
        }
        return skladniki_sekcji;
    }
}
