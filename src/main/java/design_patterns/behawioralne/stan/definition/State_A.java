package design_patterns.behawioralne.stan.definition;

//Implementuje zachowanie charakterystyczne dla stanu 'State_A'
//Decyduje kiedy i na jaki stan przejść
//Korzystają z klasy 'Context' żeby zmieniać jego aktualny stan
public class State_A implements StateInterface{

    @Override
    public void performAction(Context context) {
        //wykonanie akcji
        System.out.println("--[State_A] perform actions");

        // Modyfikacja danych Context
        context.setCounter(context.getCounter() + 3);
        context.setText(context.getText() + "X");

        // Przejście A -> B (może być warunkowe)
        StateInterface state_b = new State_B();
        context.setState(state_b);
        //w tej implementacji instancje stanów są efemeryczne i wszystkie dane ponownego użycia trzeba zapisywać do klasy 'Context'
    }
}
