package design_patterns.strukturalne.fasada.skladanie_zamowienia.complex_skladanie_zamowienia;

import java.util.List;

//przyjmuje listę zamówionych pozycji i sumuje koszty całkowite
public class Platnosc {
    private Double total;

    public Platnosc(){
        total=0.0;
    }

    public Double calculateTotal(List<PozycjaZamowienia> elementy_zamowienia){
        elementy_zamowienia.forEach(pozycjaZamowienia -> {
            total+=(pozycjaZamowienia.cenaJednostkowa* pozycjaZamowienia.ilosc);
        });
        return total;
    }
}
