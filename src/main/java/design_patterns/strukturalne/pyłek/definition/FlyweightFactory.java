package design_patterns.strukturalne.pyłek.definition;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    //fabryka przechowuje pyłki po nazwie (można po większej ilości parametrów, ale trzebabyłoby stworzyć dodatkową klasę modelującą pola pyłka po których go wyszukujemy) ... zamiast 'String' w mapie byłby typ obiektowy np. ProductKey (gdzie to byłaby prosta klasa z dwoma polami String:name i String:hex_color
    static Map<String, Flyweight> flyweight_map = new HashMap<>();

    //metoda przyjmuje wszystkie pola, ale w tej implementacji jedynie wyszukiwanie po 'name' pyłka
    public static Flyweight getFlyweight(String name, String hex_color){
        Flyweight result = flyweight_map.get(name);
        if(result == null){
            result = new Flyweight(name, hex_color);
            flyweight_map.put(name,result);
        }
        return result;
    }
}
