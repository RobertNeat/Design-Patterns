package design_patterns.strukturalne.pełnomocnik.definition;

import java.util.HashMap;
import java.util.Map;

public class Proxy implements ServiceInterface{
    private ServiceInterface service;
    private Map<String,String> previous_resolutions = new HashMap<>();

//  wersja z inicjalizacją servisu przed stworzeniem proxy - zwykłe opakowanie
//    public Proxy(ServiceInterface service){
//        this.service=service;
//    }

    @Override
    public String resolve(String domain) {
        if(service == null){
            System.out.println("[Proxy] Service does not exist. Creating instance ... lazy initialization");
            service = new Service();
        }

        System.out.println("[Proxy] Intercepting DNS resolution request");

        //dodatkowy mechanizm pozwalający na cachowanie wyników i ograniczenie zbędnego ruchu sieciowego (wersja z cache-proxy)
        if(previous_resolutions.containsKey(domain)){
            System.out.println("[Proxy] Reused DNS resolution from cache");
            return previous_resolutions.get(domain);
        }else{
            String resolution = service.resolve(domain);
            previous_resolutions.put(domain,resolution);
            return resolution;
        }
    }
}
