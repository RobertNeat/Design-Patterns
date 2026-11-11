package design_patterns.strukturalne.adapter;


/*
* Używanie klasy o niekompatybilnym interfejsie w kodzie klienckim,
* pozwala na stworzenie klasy opakowującej i konwersję danych w locie (w klasie adaptera).
*
* # KEY-DEFINITIONS:
* INTERFEJS KLIENTA - deklaruje metodę komunikacji z adapterem
* ADAPTER - klasa implementująca interfejs klienta opakowując obiekt-usługę, otzrymuje wywołania od klienta i tłumaczy na wywołania zrozumiałe dla obiektu odostępniającego usługę (*może implementować dwustronną konwersję)
* USŁUGA - klasa, która ma niekompatybilny interfejs względem klienta
*
* ClientInterface
* Adapter
* Service
*
* PaymentInterface
* PaymentAdapter
* PaymentService
* */

//Integracja z zewnętrznym systemem płatności o niezgodnym interfejsie (płatność w pln a system płatności potrzebuje euro)

import design_patterns.strukturalne.adapter.definition.Adapter;
import design_patterns.strukturalne.adapter.definition.ClientInterface;
import design_patterns.strukturalne.adapter.definition.Service;
import design_patterns.strukturalne.adapter.definition_extended.Adapter_ex;
import design_patterns.strukturalne.adapter.definition_extended.ClientInterface_ex;
import design_patterns.strukturalne.adapter.definition_extended.Service_ex;
import design_patterns.strukturalne.adapter.external_payment.PaymentAdapter;
import design_patterns.strukturalne.adapter.external_payment.PaymentInterface;
import design_patterns.strukturalne.adapter.external_payment.PaymentService;

public class AdapterMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        PaymentService euro_payment_service = new PaymentService();
        PaymentAdapter adapter = new PaymentAdapter(euro_payment_service);
        double result = adapter.performPlnPayment(123,23);
        System.out.println("Result: "+result);
    }

    public static void runAbstract() {
        Service inpompatibleService = new Service();
        //stworzenie adaptera z przekazaniem zainicjalizowanego obiektu niekompatybilnego serwisu
        ClientInterface adapter = new Adapter(inpompatibleService);

        adapter.performOperation("123");
    }

    public static void runAbstractTwoWay() {
        //implementacja z konwersją dwukierunkową
        Service_ex inpompatibleService = new Service_ex();
        //stworzenie adaptera z przekazaniem zainicjalizowanego obiektu niekompatybilnego serwisu
        ClientInterface_ex adapter = new Adapter_ex(inpompatibleService);

        String result = adapter.performServiceOperation("123");
        System.out.println(result);
    }

}

