package design_patterns.strukturalne.pyłek.alergeny_i_potwary;

import java.util.HashMap;
import java.util.Map;

//(fabryka pyłków) - zarządzanie (pobieranie lub tworzenie alergenów)
public class FabrykaAlergenów {
    static Map<String, Alergen> alergen_map = new HashMap<>();

   public static Alergen getAlergen(int id, String name, String description){
       Alergen result = alergen_map.get(name);
       if( result == null){
           result = new Alergen(id, name, description);
           alergen_map.put(name,result);
       }
       return result;
   }

}
