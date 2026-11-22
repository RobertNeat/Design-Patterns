package design_patterns.behawioralne.komenda.system_zamowien;

//usuwa pozycję ostatnią na liście zamowienia (jakby klient się rozmyślił)
public class UsunOstatniaPozycjeKomenda implements InterfejsKomenda{
    Zamowienie zamowienie;
    String usuniete_zamowienie;

    public UsunOstatniaPozycjeKomenda(Zamowienie zamowienie){
        this.zamowienie=zamowienie;
        this.usuniete_zamowienie="";
    }

    @Override
    public void execute() {
        if(!this.zamowienie.pozycjeZamowienia.isEmpty()){
            this.usuniete_zamowienie = this.zamowienie.pozycjeZamowienia.getLast();
            this.zamowienie.pozycjeZamowienia.removeLast();
        }
    }

    @Override
    public void undo() {
        this.zamowienie.pozycjeZamowienia.addLast(this.usuniete_zamowienie);
        this.usuniete_zamowienie="";
    }
}
