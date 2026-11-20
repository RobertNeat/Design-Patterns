package design_patterns.behawioralne.łańcuch_zobowiązań.lancuch_rozliczenia_zamowienia;

import design_patterns.behawioralne.łańcuch_zobowiązań.definition.HandlingInterface;

import java.util.Map;

public interface InterfejsObslugi {
    public void handle(Map<String,Boolean> request);
    public void setNext(InterfejsObslugi next_handler);
}
