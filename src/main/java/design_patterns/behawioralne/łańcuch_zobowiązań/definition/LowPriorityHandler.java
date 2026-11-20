package design_patterns.behawioralne.łańcuch_zobowiązań.definition;

//KONKRETNY OBIEKT OBSŁUGUJĄCY aka. ConcreteHandlingClass
public class LowPriorityHandler extends BaseHandlerClass{
    @Override
    public void handle(String request) {
        if(request.equals("low")){
            //handle
            System.out.println("Low handler handled request");
        }else if (next_handler != null){
            //pass down
            next_handler.handle(request);
        }
    }
}
