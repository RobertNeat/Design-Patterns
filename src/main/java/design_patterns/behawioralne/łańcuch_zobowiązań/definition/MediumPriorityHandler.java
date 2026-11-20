package design_patterns.behawioralne.łańcuch_zobowiązań.definition;

//KONKRETNY OBIEKT OBSŁUGUJĄCY aka. ConcreteHandlingClass
public class MediumPriorityHandler extends BaseHandlerClass{
    @Override
    public void handle(String request) {
        if(request.equals( "medium")){
            //handle
            System.out.println("Medium handler handled request");
        }else if (next_handler != null){
            //pass down
            next_handler.handle(request);
        }
    }
}
