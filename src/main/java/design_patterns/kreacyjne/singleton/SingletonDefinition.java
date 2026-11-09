package design_patterns.kreacyjne.singleton;

public class SingletonDefinition {
    //zmienna musi być volatile aby zapobiec wielowątkowemu sprawdzeniu instance != null (race condition)
    private static volatile SingletonDefinition instance;

    //private constructor that only class can invoke
    private SingletonDefinition(){
    }

    public static SingletonDefinition getInstance(){
        if(instance==null){
            synchronized (RestaurantConfigurationSingleton.class) {//sprawdzenie dla wielu wątków synchronicznie (race condition)
                if(instance==null) {//sprawdzenie dla wielu wątków synchronicznie (race condition)
                    instance = new SingletonDefinition();
                }
            }
        }else{
            //obsłużenie ponownego przypisania parametrów inicjalizacji -- przykład w klasie 'RestaurantConfigurationSingleton'
        }
        return instance;
    }
}
