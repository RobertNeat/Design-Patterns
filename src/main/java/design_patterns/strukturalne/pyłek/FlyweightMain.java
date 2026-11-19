package design_patterns.strukturalne.pyłek;

/*
* Wzorzec optymalizacyjny pozwalający przechowywać większą ilość obiektów (tego samego typu) w tej samej ilości pamięci RAM poprzez przechowywanie w pamięci podręcznej części wspólnej danych różnych obiektów.
*
* STAN WEWNĘTRZNY - dane niezmienne (jedynie do odczytu) w ramach wielu instancji obiektu. Dane które się powielają między obiektami tej samej klasy są zapisywane w klasie-pyłku.
* STAN ZEWNĘTRZNY - dane zmienne (indywidualne w ramach danej instancji), są przechowywane indywidualnie dla każdej instancji. Jest przechowywany poza obiektem w obiekcie kontenerowym (kontekst).
*
* PYŁEK - klasa zawierająca współdzieloną porcję stanu pierwotnego obiektu, która może być współdzielona między wielona instancjami
* KONTEKST - klasa zawierająca unikalną porcję stanu pierwotnego obiektu. Gdy kontekts zostanie skojarzony z klasą-pyłek otrzymywana jest pełna reprezentacja stanu pierwotnego obiektu.
* FABRYKA PYŁKÓW - zarządza pulą istniejących pyłków, jeśli żądany pyłek nie istnieje to zostaje stworzony. Fabryka pozwala na reużywanie tych samych obiektów-pyłków w różnych kontekstach.
*
* */

import design_patterns.strukturalne.pyłek.definition.Context;
import design_patterns.strukturalne.pyłek.definition.Flyweight;
import design_patterns.strukturalne.pyłek.definition.FlyweightFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlyweightMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //Współdzielenie obiektów typu przepis
        System.out.println("flyweight");
    }

    public static void run_abstract(){
        //klient tworzy sobie wiele obiektów
        int ilosc_obiektow = 200;
        Random random = new Random();

        int value_x;
        int value_y;
        int value_z;

        Flyweight flyweight = FlyweightFactory.getFlyweight("object_1","#1a2b3c");

        //lista na dużą ilość obietów kontekstu
        List<Context> context_list = new ArrayList<>();

        for(int i=0;i<=ilosc_obiektow;i++){
             value_x = random.nextInt(255) + 1;
             value_y = random.nextInt(255) + 1;
             value_z = random.nextInt(255) + 1;

             Context new_context = new Context(value_x, value_y, value_z, flyweight);
             context_list.add(new_context);
        }
    }
}
