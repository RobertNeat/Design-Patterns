package design_patterns.behawioralne.pamiątka.etapy_przygotowania_dan;

import java.util.ArrayList;
import java.util.List;

public class Danie {
    private String nazwa;
    private int stopien_przygotowania; // 0-100%
    private List<String> skladniki;
    private String aktualny_etap;//PRZYGOTOWANIE_SKLADNIKOW, OBROBKA_TERMICZNA, DOPRAWIANIE, SERWOWANIE


    //metoda do tworzenia pamiątki (konstruktor Memento kopiuje listę składników)
    public Memento save(){
        return new Memento(this.nazwa, this.stopien_przygotowania, this.skladniki, this.aktualny_etap);
    }

    //metoda przywracająca stan pamiątki
    public void restore(Memento memento){
        this.nazwa=memento.nazwa;
        this.stopien_przygotowania=memento.stopien_przygotowania;
        this.skladniki=new ArrayList<>(memento.skladniki);//przy przywracaniu skomplikowanych obiektów trzeba je skopiować, żeby nie przekazać do originator referencji tablicy z memento (co by mogło skutkować zmianami tablicy w originator kiedy w memento się zmieniają wartości)
        this.aktualny_etap=memento.aktualny_etap;
    }


    //wewnętrzna klasa pamiątki
    protected static class Memento{
        private final String nazwa;
        private final int stopien_przygotowania;
        private final List<String> skladniki;
        private final String aktualny_etap;

        public Memento(String nazwa, int stopien_przygotowania, List<String> skladniki, String aktualny_etap){
            this.nazwa=nazwa;
            this.stopien_przygotowania=stopien_przygotowania;
            this.skladniki=new ArrayList<>(skladniki);//tworzenie nowej instancji, żeby nie przekazać referencji do oryginału
            this.aktualny_etap=aktualny_etap;
        }
    }


    //settery i gettery
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getStopien_przygotowania() {
        return stopien_przygotowania;
    }

    public void setStopien_przygotowania(int stopien_przygotowania) {
        this.stopien_przygotowania = stopien_przygotowania;
    }

    public List<String> getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(List<String> skladniki) {
        this.skladniki = skladniki;
    }

    public String getAktualny_etap() {
        return aktualny_etap;
    }

    public void setAktualny_etap(String aktualny_etap) {
        this.aktualny_etap = aktualny_etap;
    }
}
