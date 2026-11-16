package design_patterns.strukturalne.most.zamowienie;

//klasa 'konkretna implementacja'
public class EkspresowaRealizacja implements RealizacjaZamowienia{
    @Override
    public void info() {
        System.out.println("Szybkosc realizacji: 10 min");
        System.out.println("Czas przygotowania: 5 min");
        System.out.println("Dodatkowe koszty: 35zł");
    }

    @Override
    public int okreslSzybkoscRealizacji() {
        return 10;
    }

    @Override
    public int okreslCzasPrzygotowania() {
        return 5;
    }

    @Override
    public double okreslDodatkoweKoszty() {
        return 35;
    }

    @Override
    public void wykonajZamowienie() {
        System.out.println("Przekazano 'ekspresowa realizacje' do wykonania");
    }
}
