package design_patterns.kreacyjne.prototyp.definition;

import java.util.HashMap;
import java.util.Map;

//REJESTR PROTOTYPÓW
public class RegistryCache {
    private Map<String, PrototypeInterface> cache = new HashMap<>();

    public RegistryCache() {
        ConcretePrototypeA proto_1  = new ConcretePrototypeA("abc",4);
        cache.put("prototype integer 4",proto_1);

        ConcretePrototypeB proto_2 = new ConcretePrototypeB(123,false);
        cache.put("prototype boolean false",proto_2);
    }

    public PrototypeInterface put(String key, PrototypeInterface prototype) {
        cache.put(key, prototype);
        return prototype;
    }

    public PrototypeInterface get(String key) {
        return cache.get(key).clone();
    }
}
