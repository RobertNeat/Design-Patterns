package design_patterns.kreacyjne.prototyp.daniespecjalne;

import design_patterns.kreacyjne.metoda_wytwórcza.dania.konkretne_produkty.Zupa;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class ZupaDnia implements DanieSpecjalneInterfejs{
    String nazwa;
    String opis;
    double cena;
    List<String> alergeny;
    LocalDate dataWprowadzenia;
    int szacowanyCzasPrzygotowaniaMin;

    public ZupaDnia(String nazwa, String opis, double cena, List<String> alergeny, LocalDate dataWprowadzenia, int szacowanyCzasPrzygotowaniaMin) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
        this.alergeny = alergeny;
        this.dataWprowadzenia = dataWprowadzenia;
        this.szacowanyCzasPrzygotowaniaMin = szacowanyCzasPrzygotowaniaMin;
    }

    ZupaDnia (ZupaDnia object_to_clone){
        this.nazwa=object_to_clone.nazwa;
        this.opis=object_to_clone.opis;
        this.cena=object_to_clone.cena;
        this.alergeny=object_to_clone.alergeny;
        this.dataWprowadzenia=object_to_clone.dataWprowadzenia;
        this.szacowanyCzasPrzygotowaniaMin= object_to_clone.szacowanyCzasPrzygotowaniaMin;
    }

    @Override
    public DanieSpecjalneInterfejs clone() {
        return new ZupaDnia(this);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof ZupaDnia)) return false;
        ZupaDnia zupa = (ZupaDnia) obj;
        return Objects.equals(zupa.nazwa,this.nazwa)
                && Objects.equals(zupa.opis,this.opis)
                && Double.compare(zupa.cena,this.cena)==0
                && zupa.dataWprowadzenia.equals(this.dataWprowadzenia)
                && zupa.szacowanyCzasPrzygotowaniaMin == this.szacowanyCzasPrzygotowaniaMin
                && Objects.equals(zupa.alergeny,this.alergeny);
    }
}
