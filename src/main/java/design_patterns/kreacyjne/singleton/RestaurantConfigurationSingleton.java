package design_patterns.kreacyjne.singleton;

public class RestaurantConfigurationSingleton {
    //zmienna musi być volatile aby zapobiec wielowątkowemu sprawdzeniu instance != null (race condition)
    private static volatile RestaurantConfigurationSingleton instance;
    private String nazwaRestauracji;
    private String godzinyOtwarcia;

    //private constructor that only class can invoke
    private RestaurantConfigurationSingleton(String nazwaRestauracji, String godzinyOtwarcia){
        this.nazwaRestauracji=nazwaRestauracji;
        this.godzinyOtwarcia=godzinyOtwarcia;
    }

    public static RestaurantConfigurationSingleton getInstance(String nazwaRestauracji, String godzinyOtwarcia){
        if(instance==null){
            synchronized (RestaurantConfigurationSingleton.class) {//sprawdzenie dla wielu wątków synchronicznie (race condition)
                if(instance==null) {//sprawdzenie dla wielu wątków synchronicznie (race condition)
                    instance = new RestaurantConfigurationSingleton(nazwaRestauracji, godzinyOtwarcia);
                }
            }
        }else{
            //obsłużenie ponownego przypisania parametrów inicjalizacji (przy ponownym użyciu getInstace z innymi parametrami niż aktualnie w instancji wyjątek)
            //klient powinien zmieniać stan singletona po zainicjalozowaniu setterami
            if (!instance.nazwaRestauracji.equals(nazwaRestauracji) || !instance.godzinyOtwarcia.equals(godzinyOtwarcia)) {
                throw new IllegalStateException(
                        "Singleton został już zainicjalizowany z innymi parametrami!\n" +
                                "Obecne: [" + instance.nazwaRestauracji + ", " + instance.godzinyOtwarcia + "], " +
                                "Próba przekazania: [" + nazwaRestauracji + ", " + godzinyOtwarcia + "]"
                );
            }
        }
        return instance;
    }

    //gettery

    public String getNazwaRestauracji() {
        return nazwaRestauracji;
    }

    public String getGodzinyOtwarcia() {
        return godzinyOtwarcia;
    }

    //settery - kiedy klient operuje na re-uzytej instancji singletonu i musi zmienić jego parametry


    public void setNazwaRestauracji(String nazwaRestauracji) {
        this.nazwaRestauracji = nazwaRestauracji;
    }

    public void setGodzinyOtwarcia(String godzinyOtwarcia) {
        this.godzinyOtwarcia = godzinyOtwarcia;
    }
}
