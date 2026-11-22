package design_patterns.behawioralne.komenda.system_zamowien;

//dodaje wskazaną pozycję do zamówienia
public class DodajPozycjeKomenda implements InterfejsKomenda{
    Zamowienie zamowienie;
    String pozycjaDoDodania;

    public DodajPozycjeKomenda(Zamowienie zamowienie,String pozycjaDoDodania){
        this.zamowienie=zamowienie;
        this.pozycjaDoDodania=pozycjaDoDodania;
    }

    @Override
    public void execute() {
        zamowienie.pozycjeZamowienia.addLast(pozycjaDoDodania);
    }

    @Override
    public void undo() {
        if(this.zamowienie.pozycjeZamowienia.contains(pozycjaDoDodania)){
            this.zamowienie.pozycjeZamowienia.remove(pozycjaDoDodania);
            //zakładamy dla prostoty, że zamowienie posiada unikalne pozycje (inaczej model Listy<String> trzebabyłoby zamienić na Map<String,int>
        }else{
            System.out.println("[dodaj pozycje komenda _undo] zamowienie nie posiada dodanego elementu, prawdopodobnie usunięty przez inną operację .. cannot undo");
        }
    }
}
