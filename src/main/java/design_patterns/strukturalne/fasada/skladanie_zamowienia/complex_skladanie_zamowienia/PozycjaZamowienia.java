package design_patterns.strukturalne.fasada.skladanie_zamowienia.complex_skladanie_zamowienia;

//prosta klasa pomocnicza reprezentująca encję dania
public class PozycjaZamowienia {
    String nazwaDania;
    int ilosc;
    Double cenaJednostkowa;

    public PozycjaZamowienia(String nazwaDania, int ilosc, Double cenaJednostkowa){
        this.nazwaDania=nazwaDania;
        this.ilosc=ilosc;
        this.cenaJednostkowa=cenaJednostkowa;
    }

    public String getNazwaDania() {
        return nazwaDania;
    }

    public void setNazwaDania(String nazwaDania) {
        this.nazwaDania = nazwaDania;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Double getCenaJednostkowa() {
        return cenaJednostkowa;
    }

    public void setCenaJednostkowa(Double cenaJednostkowa) {
        this.cenaJednostkowa = cenaJednostkowa;
    }
}
