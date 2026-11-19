package design_patterns.strukturalne.pełnomocnik;

/*
* Stworzenie obiektu zastępczego w miejsce innego obiektu, który nadzoruje dostęp do obiektu pierwotnego. Pozawala na wykonywanie czynności przed lub po przekazaniu żądania.
*
* INTERFEJS USŁUGI - deklaruje interfejs z którym pełnomocnik musi być zgodny, aby móc udawać obiekt usługi
* USŁUGA (service) - klasa udostępniająca jakąś użyteczną logikę biznesową
* PEŁNOMOCNIK (proxy) - klasa zawierająca pole z odniesieniem do konkretnego obiektu usługi. Po wykonaniu swoich zadań Pełnomocnik przekazuje żądanie do obiektu usługi.
*
*
* */

import design_patterns.strukturalne.pełnomocnik.ceny_posilkow.AccessProxy;
import design_patterns.strukturalne.pełnomocnik.ceny_posilkow.ZmienCenyPosilkowProxy;
import design_patterns.strukturalne.pełnomocnik.definition.Proxy;
import design_patterns.strukturalne.pełnomocnik.definition.ServiceInterface;

public class ProxyMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //Kontrola dostępu tylko menedżer może zmieniać ceny
        AccessProxy proxy_user = new ZmienCenyPosilkowProxy("user");
        proxy_user.zmienCenyPosilkow();

        AccessProxy proxy_manager = new ZmienCenyPosilkowProxy("manager");
        proxy_manager.zmienCenyPosilkow();
    }


    public static void run_abstract(){
        //przekazanie obiektu service do proxy
        //ServiceInterface service = new Service(); //<-- przy użyciu zwykłego proxy bez lazy initialization
        ServiceInterface proxy = new Proxy(); // lazy initialization

        // Pierwsze wywołanie - DNS resolution
        String ip1 = proxy.resolve("google.com");
        System.out.println("IP 1: " + ip1);

        // Drugie wywołanie - wynik z cache
        String ip2 = proxy.resolve("google.com");
        System.out.println("IP 2: " + ip2);

        // Trzecie wywołanie - wynik z cache
        String ip3 = proxy.resolve("google.com");
        System.out.println("IP 3: " + ip3);
    }
}
