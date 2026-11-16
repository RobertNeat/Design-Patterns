package design_patterns.strukturalne.most.zamowienie;

//klasa 'konkretna implementacja'
public class StandardowaRealizacja implements RealizacjaZamowienia{
    @Override
    public void info() {
        System.out.println("Szybkosc realizacji: 25 min");
        System.out.println("Czas przygotowania: 15 min");
        System.out.println("Dodatkowe koszty: 0zł");
    }

    @Override
    public int okreslSzybkoscRealizacji() {
        return 25;
    }

    @Override
    public int okreslCzasPrzygotowania() {
        return 15;
    }

    @Override
    public double okreslDodatkoweKoszty() {
        return 0;
    }

    @Override
    public void wykonajZamowienie() {
        System.out.println("Przekazano 'stadardowa realizacje' do wykonania");
    }
}
