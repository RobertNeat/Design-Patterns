package design_patterns.strukturalne.kompozyt.skladniki_dan;

import java.util.Map;

public class Danie implements Komponent{
    private Map<String,Integer> skladniki;

    public Danie(Map<String,Integer> skladniki){
        this.skladniki=skladniki;
    }

    @Override
    public Map<String, Integer> execute_skladniki() {
        return skladniki;
    }
}
