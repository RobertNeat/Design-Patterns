package design_patterns.strukturalne.pyłek.alergeny_i_potwary;

//(klasa pyłka), alergeny się powtarzają między potrawami
public class Alergen {
    private final int id;
    private final String name;
    private final String description;

    public Alergen(int id, String name, String description){
        this.id=id;
        this.name=name;
        this.description=description;
    }

    public void wypisz_alergen(){
        System.out.println("Nazwa: "+name);
        System.out.println("Opis: "+description);
    }

}
