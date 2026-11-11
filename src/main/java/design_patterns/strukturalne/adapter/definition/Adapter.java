package design_patterns.strukturalne.adapter.definition;

public class Adapter implements ClientInterface{
    private final Service service;//final zapewnia niezmienność referencji (dobrz praktyka)

    public Adapter(Service service){
        this.service=service;
    }

    @Override
    public void performOperation(String data) {
        //tłumaczenie wywołania i danych z oczekiwań klienta na format obsługiwany przez usługę
        //naiwne podejście, jeśli będzie więcej metod operacji na serwisie metoda konwersyjna musi być wydzielona do prywatnej metody konwertującej w Adapterze
        int translatedCode = Integer.parseInt(data);
        service.incompatibleMethod(translatedCode);
    }
}
