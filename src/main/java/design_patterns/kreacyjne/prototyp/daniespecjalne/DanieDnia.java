package design_patterns.kreacyjne.prototyp.daniespecjalne;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class DanieDnia implements DanieSpecjalneInterfejs{
    String nazwa;
    String opis;
    double cena;
    List<String> skladniki;
    LocalDate dataWprowadzenia;
    int szacowanyCzasPrzygotowaniaMin;

    public DanieDnia(String nazwa, String opis, double cena, List<String> skladniki, LocalDate dataWprowadzenia, int szacowanyCzasPrzygotowaniaMin) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
        this.skladniki = skladniki;
        this.dataWprowadzenia = dataWprowadzenia;
        this.szacowanyCzasPrzygotowaniaMin = szacowanyCzasPrzygotowaniaMin;
    }

    DanieDnia(DanieDnia object_to_clone){
        this.nazwa=object_to_clone.nazwa;
        this.opis=object_to_clone.opis;
        this.cena=object_to_clone.cena;
        this.skladniki=object_to_clone.skladniki;
        this.dataWprowadzenia=object_to_clone.dataWprowadzenia;
        this.szacowanyCzasPrzygotowaniaMin= object_to_clone.szacowanyCzasPrzygotowaniaMin;
    }

    @Override
    public DanieSpecjalneInterfejs clone() {
        return new DanieDnia(this);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof DanieDnia)) return false;
        DanieDnia danie = (DanieDnia) obj;
        return Objects.equals(danie.nazwa,this.nazwa)
                && Objects.equals(danie.opis,this.opis)
                && Double.compare(danie.cena,this.cena)==0
                && danie.dataWprowadzenia.equals(this.dataWprowadzenia)
                && danie.szacowanyCzasPrzygotowaniaMin == this.szacowanyCzasPrzygotowaniaMin
                && Objects.equals(danie.skladniki,this.skladniki);
    }
}
