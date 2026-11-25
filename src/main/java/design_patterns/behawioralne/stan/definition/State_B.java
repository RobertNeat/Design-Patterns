package design_patterns.behawioralne.stan.definition;

//Implementuje zachowanie charakterystyczne dla stanu 'State_A'
//Decyduje kiedy i na jaki stan przejść
//Korzystają z klasy 'Context' żeby zmieniać jego aktualny stan
public class State_B implements StateInterface{

    @Override
    public void performAction(Context context) {
        //wykonanie akcji
        System.out.println("--[State_B] perform actions");

        // Modyfikacja danych Context
        context.setScore(context.getScore() + 1);
        context.setText(context.getText() + "Y");

        // Warunkowe przejście B -> A lub B -> C
        if(context.isInverse()){
            StateInterface state_a = new State_A();
            context.setState(state_a);
        }else{
            StateInterface state_c = new State_C();
            context.setState(state_c);
        }
        //w tej implementacji instancje stanów są efemeryczne i wszystkie dane ponownego użycia trzeba zapisywać do klasy 'Context'
    }
}
