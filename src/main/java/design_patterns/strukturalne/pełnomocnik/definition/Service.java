package design_patterns.strukturalne.pełnomocnik.definition;

import java.net.InetAddress;
import java.net.UnknownHostException;

//usługa sieciowa wykonująca DNS resolution na adres IP (potencjalnie długa operacja sieciowa)
public class Service implements ServiceInterface {

    //konstruktor, żeby widzieć kiedy obiekt się inicjalizuje
    public Service(){
        System.out.println("[Service] Creating Service instance");
    }

    @Override
    public String resolve(String domain){
        try{
            System.out.println("[Service] Performing DNS resolution for: "+domain);
            InetAddress address = InetAddress.getByName(domain);
            return address.getHostAddress();
        }catch(UnknownHostException e){
            throw new RuntimeException("Could not resolve domain: "+domain,e);
        }
    }
}
