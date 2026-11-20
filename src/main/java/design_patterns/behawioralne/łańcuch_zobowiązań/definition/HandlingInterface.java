package design_patterns.behawioralne.łańcuch_zobowiązań.definition;

// interfejs OBIEKT OBSŁUGUJĄCY
public interface HandlingInterface {
    public void handle(String request);
    public void setNext(HandlingInterface next_handler);
}
