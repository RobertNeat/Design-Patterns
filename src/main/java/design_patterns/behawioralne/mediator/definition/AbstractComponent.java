package design_patterns.behawioralne.mediator.definition;

//(spoza wzorca) zapewnia, że każdy komponent tak samo implementuje odniesienie do interfejsu (i nie występują implementacje z wykorzystaniem konkretnych klas mediatorów tj. uzależnionych implementacji)
//dla surowej wersji wzorca trzebabyłoby identycznie zrobić ale klasę standardową, ale jeśli wykorzystujemy klasę abstrakcyjną to nie można jej zainicjalizować co dodaje dodatkową ochronę
public abstract class AbstractComponent {
    protected MediatorInterface mediator;

    public void setMediator(MediatorInterface mediator){
        this.mediator=mediator;
    }

}
