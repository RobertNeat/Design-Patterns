package design_patterns.behawioralne.stan.definition;

//Implementuje zachowanie charakterystyczne dla stanu 'State_A'
//Decyduje kiedy i na jaki stan przejść
//Korzystają z klasy 'Context' żeby zmieniać jego aktualny stan
public class State_C implements StateInterface{
    @Override
    public void performAction(Context context) {
        //wykonanie akcji
        System.out.println("--[State_C] perform actions");


        // Modyfikacja danych Context
        context.setCounter(context.getCounter() * 2);
        context.setFlag(!context.isFlag());


        // Warunkowe przejście C -> A lub C -> B
        if(context.isInverse()){
            StateInterface state_b = new State_B();
            context.setState(state_b);
        }else{
            StateInterface state_a = new State_A();
            context.setState(state_a);
        }
        //w tej implementacji instancje stanów są efemeryczne i wszystkie dane ponownego użycia trzeba zapisywać do klasy 'Context'
    }
}
