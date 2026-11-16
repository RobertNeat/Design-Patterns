package design_patterns.strukturalne.most.zamowienie;

//wzorzec most nie narzuca określonego typu (klasy abstrakcyjnej/ interfejsu) który ma 'absrakcja' przyjąć
//zazwyczaj wybiera się klasę abstrakcyjną jako abstrakcję jeśli potrzeba jest przechowywać instancję 'implementacji' (zapobiega to powielaniu kodu we wzbogaconych abstrakcjach)
//'abstrakcja'
public abstract class RodzajZamowienia {
    protected RealizacjaZamowienia realizacja;

    RodzajZamowienia(RealizacjaZamowienia rezaliacja){
        this.realizacja =rezaliacja;
    }

    public abstract void info();

    public abstract void przyjmijZamowienie();

    public abstract void zrealizujZamowienie();

    public void zmienRealizacje(RealizacjaZamowienia realizacja) {
        this.realizacja = realizacja;
    }
}
