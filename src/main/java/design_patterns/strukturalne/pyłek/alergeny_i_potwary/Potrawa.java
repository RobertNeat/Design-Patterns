package design_patterns.strukturalne.pyłek.alergeny_i_potwary;


import java.util.List;

//(kontekst) potrawa zawiera alergeny, ale potrway mogą być różne
public class Potrawa {
    String nazwa_potrawy;
    List<String> skladniki;
    List<String> kroki_przygotowania;

    public List<Alergen> lista_alergenow;

    public Potrawa(String nazwa_potrawy, List<String> skladniki, List<String> kroki_przygotowania){
        this.nazwa_potrawy=nazwa_potrawy;
        this.skladniki=skladniki;
        this.kroki_przygotowania=kroki_przygotowania;
    }

    public void wypisz_alergeny_potrawy(){
        lista_alergenow.forEach((Alergen alergen)->{
            alergen.wypisz_alergen();
        });
    }
}
