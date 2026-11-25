package design_patterns.behawioralne.stan.definition;

//Definiuje operacje dostępne dla wszystkich stanów.
//Zapewnia wspólny kontrakt dla klas ConcreteState.
public interface StateInterface {
    void performAction(Context context);//przekazanie konkretnemu stanowi dostępu do obiektu kontekstu.
    //interfejs nie musi deklarować metody zmiany stanu, ponieważ konkretne stany zarządzają przejściami
}
