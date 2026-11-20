package design_patterns.behawioralne.łańcuch_zobowiązań.lancuch_rozliczenia_zamowienia;

import java.util.Map;

public class ObslugaBaseHandler implements InterfejsObslugi {
    InterfejsObslugi next_handler;

    @Override
    public void handle(Map<String, Boolean> request) {
        if(request.containsKey("obsluga") && request.get("obsluga").equals(true)){
            System.out.println("ObslugaBaseHandler executed --- #");//execute own operation
            request.remove("obsluga");//drop executed key
            //pass down to next handler if map not empty
            if(!request.isEmpty()){
                next_handler.handle(request);
            }
        }else if (!request.isEmpty()  && next_handler != null){//check if request is not empty to avoid passing empty requests and make sure to not pass to empty next handler (so the last element won't make NullPointerException)
            //if key not detected just pass down
            next_handler.handle(request);
        }
    }

    @Override
    public void setNext(InterfejsObslugi next_handler) {
        this.next_handler=next_handler;
    }
}
