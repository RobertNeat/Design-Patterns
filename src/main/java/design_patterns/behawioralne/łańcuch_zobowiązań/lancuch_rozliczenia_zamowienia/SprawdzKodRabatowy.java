package design_patterns.behawioralne.łańcuch_zobowiązań.lancuch_rozliczenia_zamowienia;

import java.util.Map;

public class SprawdzKodRabatowy extends ObslugaBaseHandler{
    @Override
    public void handle(Map<String, Boolean> request) {
        if(request.containsKey("kod_promocyjny") && request.get("kod_promocyjny").equals(true)){
            System.out.println("SprawdzKodRabatowy executed --- #");//execute own operation
            request.remove("kod_promocyjny");//drop executed key
            //pass down to next handler if map not empty
            if(!request.isEmpty()){
                next_handler.handle(request);
            }
        }else if (!request.isEmpty()){//check if request is not empty to avoid passing empty requests
            //if key not detected just pass down
            next_handler.handle(request);
        }
    }
}
