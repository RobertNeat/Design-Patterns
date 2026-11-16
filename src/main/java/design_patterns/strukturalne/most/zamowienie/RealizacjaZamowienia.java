package design_patterns.strukturalne.most.zamowienie;

//'implementacja'
public interface RealizacjaZamowienia {
    void info();
    int okreslSzybkoscRealizacji();//min
    int okreslCzasPrzygotowania();//min
    double okreslDodatkoweKoszty();//koszt w zl
    void wykonajZamowienie();
}
