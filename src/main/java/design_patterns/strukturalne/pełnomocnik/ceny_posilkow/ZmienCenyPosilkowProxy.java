package design_patterns.strukturalne.pełnomocnik.ceny_posilkow;

//proxy
public class ZmienCenyPosilkowProxy implements AccessProxy{
    private AccessProxy service;
    private final String role;

    public ZmienCenyPosilkowProxy(String role){
        this.role=role;
    }

    //uwaga: rola musi być nadawana w konstruktorze/setterze, ponieważ sygnatura metody zmiany posiłków musi być zgodna z servisem (a z założenia serwis może być niemutowalny np. pochodzić od zewnętrznego dostawcy)
    @Override
    public void zmienCenyPosilkow() {
        if(role == "manager"){
            System.out.println("[Proxy] użytkownik ma rolę manager .. przechodze do wykonania");

            //późna inicjalizacja service, żeby się nie tworzył za każdym razem jak jakikolwiek użytkownik wywoła akcję
            if(service == null){
                System.out.println("[Proxy] późna inicjalizacja service ...");
                service = new ZmienCenyPosilkow();
            }

            service.zmienCenyPosilkow();

        }else{
            System.out.println("[Proxy] użytkownik nie ma praw do zmiany ceny .. odrzucono");
        }
    }
}
