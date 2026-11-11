package design_patterns.strukturalne.adapter.definition_extended;

public class Adapter_ex implements ClientInterface_ex {
    private final Service_ex service;

    public Adapter_ex(Service_ex service) {
        this.service = service;
    }

    //metody konwertujące dane między klientem a serwisem - dobra praktyka dla skalowalności gdy serwis ma kilka metod które wymagają konwersji
    private int convertToService(String data){
        //można dodać dodatkową walidację danych, parsowanie, formatowanie danych przekazywanych do serwisu
        return Integer.parseInt(data);
    }

    private String convertToClient(int data){
        //można dodać dodatkowe formatowanie odpowiedzi
        return String.valueOf(data);
    }

    //metody wykonawcze
    @Override
    public String performServiceOperation(String data) {
        int data_int = this.convertToService(data);// A -> B
        int result_int = this.service.incompatibleMethod(data_int);// Wywołanie usługi
        return this.convertToClient(result_int);// B -> A
    }
}
