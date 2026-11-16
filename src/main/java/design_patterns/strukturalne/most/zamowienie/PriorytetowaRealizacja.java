package design_patterns.strukturalne.most.zamowienie;

//klasa 'konkretna implementacja'
public class PriorytetowaRealizacja implements RealizacjaZamowienia {
    @Override
    public void info() {
        System.out.println("Szybkosc realizacji: 15 min");
        System.out.println("Czas przygotowania: 10 min");
        System.out.println("Dodatkowe koszty: 15zł");
    }

    @Override
    public int okreslSzybkoscRealizacji() {
        return 15;
    }

    @Override
    public int okreslCzasPrzygotowania() {
        return 10;
    }

    @Override
    public double okreslDodatkoweKoszty() {
        return 15;
    }

    @Override
    public void wykonajZamowienie() {
        System.out.println("Przekazano 'priorytetowa realizacje' do wykonania");
    }
}
