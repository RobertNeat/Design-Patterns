package design_patterns.kreacyjne.singleton;

/*
* Zapewnienie istnienia globalnie dostępnej pojedynczej instancji danej klasy (np. konfiguracji).
*
* # KEY-DEFINITIONS:
* SINGLETON - klasa ze statycznymi polami i prywatnym konstruktorem i metodą getInstance ograniczającą ilość istniejących instancji
*
* SingletonDefinition
*
* RestaurantConfigurationSingleton
* */

public class SingletonMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        String nazwa ="restauracja nadburzańska";
        String godziny="8:00-18:00";
        RestaurantConfigurationSingleton restauracjaConfig_1 = RestaurantConfigurationSingleton.getInstance(nazwa, godziny);
        RestaurantConfigurationSingleton restauracjaConfig_2 = RestaurantConfigurationSingleton.getInstance(nazwa, godziny);
        restauracjaConfig_2.setNazwaRestauracji("zmiana"); //nazwet zmiana wartości w instancji nie zmienia tego, że to ten sam reużywany obiekt

        //to ten sam obiekt mimo tego, że kod kliencki mysli, że operuje na nowej instancji
        if(restauracjaConfig_1.equals(restauracjaConfig_2)){
            System.out.println("config class was reused");
            System.out.println(restauracjaConfig_2.getNazwaRestauracji());
        }
    }
    public static void runAbstract() {
        SingletonDefinition singleton_1 = SingletonDefinition.getInstance();
        SingletonDefinition singleton_2 = SingletonDefinition.getInstance();

        if(singleton_1.equals(singleton_2)){
            System.out.println("the singleton class was reused");
        }
    }

}

//Jedna wspólna konfiguracja restauracji: nazwa, stawka VAT, godziny otwarcia