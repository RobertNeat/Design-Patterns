package design_patterns.behawioralne.łańcuch_zobowiązań.definition;

//BAZOWY OBIEKT OBSŁUGUJĄCY
public class BaseHandlerClass implements HandlingInterface{
    HandlingInterface next_handler;


    @Override
    public void handle(String request) {
        if(request.equals("base") ){
            //handle
            System.out.println("Base handler handled request");
        }else if (next_handler != null){
            //pass down
            next_handler.handle(request);
        }
    }

    @Override
    public void setNext(HandlingInterface next_handler) {
        this.next_handler=next_handler;
    }
}
