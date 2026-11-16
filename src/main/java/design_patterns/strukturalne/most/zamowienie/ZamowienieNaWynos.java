package design_patterns.strukturalne.most.zamowienie;

//klasa 'wzbogacona abstrakcja'
public class ZamowienieNaWynos extends RodzajZamowienia{
    public ZamowienieNaWynos(RealizacjaZamowienia rezaliacja) {
        super(rezaliacja);
    }

    @Override
    public void info() {
        System.out.println("Cena za km: 0 zl");
        System.out.println("Czas dostawy: 2 min");
        System.out.println("Miejsce w lokalu (stolik):"+false);

        realizacja.info();//wywołanie metody z implementacji
    }

    @Override
    public void przyjmijZamowienie() {
        System.out.println("Przyjeto zamowienie do realizacji na wynos");
        //można wykonać metody a realizacji (jak w metodzie info)
        //lub pozyskiwać wyliczone wartości z implementacji i na nich działać w abstrakcji
    }

    @Override
    public void zrealizujZamowienie() {
        System.out.println("Zrealizowano zamowienie do realizacji na wynos");
        //można wykonać metody a realizacji (jak w metodzie info)
        //lub pozyskiwać wyliczone wartości z implementacji i na nich działać w abstrakcji
    }
}
