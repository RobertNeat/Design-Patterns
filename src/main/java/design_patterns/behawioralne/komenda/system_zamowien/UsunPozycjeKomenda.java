package design_patterns.behawioralne.komenda.system_zamowien;

//usuwa wskazaną pozycję z zamówienia
public class UsunPozycjeKomenda implements InterfejsKomenda{
    Zamowienie zamowienie;

    int usuniety_index;
    String usunieta_pozycja;

    public UsunPozycjeKomenda(Zamowienie zamowienie, int index){
        this.zamowienie=zamowienie;
        this.usuniety_index=index;
    }

    @Override
    public void execute() {
        if(usuniety_index < this.zamowienie.pozycjeZamowienia.size() && usuniety_index>=0){
            this.usunieta_pozycja = this.zamowienie.pozycjeZamowienia.get(usuniety_index);
            this.zamowienie.pozycjeZamowienia.remove(usuniety_index);
        }
    }

    @Override
    public void undo() {
        if(usunieta_pozycja!=null && usunieta_pozycja!=""){
            this.zamowienie.pozycjeZamowienia.add(usuniety_index,usunieta_pozycja);
            usunieta_pozycja="";
            usuniety_index=-1;
        }
    }
}
