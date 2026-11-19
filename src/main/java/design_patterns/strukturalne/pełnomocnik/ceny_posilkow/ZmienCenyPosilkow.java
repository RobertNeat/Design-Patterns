package design_patterns.strukturalne.pełnomocnik.ceny_posilkow;

//service
public class ZmienCenyPosilkow implements AccessProxy {
    public void zmienCenyPosilkow(){
        //logika zmiany cen posiłków (dla prostoty przykładu implementacja pominięta)
        System.out.println("[ZmienCenyService] Nastapila zmiana cen posilkow");
    }
}
