package design_patterns.kreacyjne.prototyp;

/*
* Kopiowanie istniejących obiektów (oddelegowane do obiketu kopiowanego) bez tworzenia zależności między kodem a klasami istniejących obiektów.
*
* # KEY-DEFINITIONS:
* REJESTR PROTOTYPÓW(*) - udostępnia łatwy dostęp do często używnaych prototypów, przechowuje zestaw prefabrykowanych obiektów które są gotowe do skopiowania (najprościej tablica asocjacyjna nazwa->prototyp)
* PROTOTYP - interfesj, deklaruje metody klanujące (zazwyczaj pojedyncza metoda 'clone()')
* (konkretny) PROTOTYP - implementuje metodę klanującą
* KLIENT - może stworzyć kopię dowolnego obiektu implementującego interfejs prototypu
*
* RegistryCache
* PrototypeInterface
* ConcretePrototypeA
* ConcretePrototypeB
*
* Klonowanie gotowych zestawów, na przykład “lunch dnia”, z drobnymi zmianami
* RejestrDanSpecjalnych
* DanieSpeclajneInterfejs
* DanieDnia, ZupaDnia
* */

import design_patterns.kreacyjne.prototyp.daniespecjalne.DanieSpecjalneInterfejs;
import design_patterns.kreacyjne.prototyp.daniespecjalne.RejestrDanSpecjalnych;
import design_patterns.kreacyjne.prototyp.daniespecjalne.ZupaDnia;
import design_patterns.kreacyjne.prototyp.definition.ConcretePrototypeA;
import design_patterns.kreacyjne.prototyp.definition.PrototypeInterface;
import design_patterns.kreacyjne.prototyp.definition.RegistryCache;

import java.time.LocalDate;
import java.util.List;

public class PrototypeMain {
    public static void main(String[] args){
        run();
    }

    public static void run() {
        //uzycie rejestru do przywoływania często używanych obiektów
        RejestrDanSpecjalnych cache = new RejestrDanSpecjalnych();
        DanieSpecjalneInterfejs danie_1 = cache.get("STANDARDOWY_STEK");
        DanieSpecjalneInterfejs danie_2 = cache.get("STANDARDOWY_STEK");
        if(danie_1!=danie_2 && danie_1.equals(danie_2)){
            System.out.println("Danie zostało slonowane (różne obiekty, ale ten sam stan wewnętrzny)");
        }

        //użycie bezpośrednio obiektów do klonowania (kalsyczne GoF)
        DanieSpecjalneInterfejs zupa_1 =  new ZupaDnia(
                "Zupa pieczarkowa",
                "Zupa na bazie kurek z zasmażaną cebulką i śmietaną",
                22.0,
                List.of("seler", "śmietana"),
                LocalDate.now(),
                15
        );
        DanieSpecjalneInterfejs zupa_2 = zupa_1.clone();
        if(zupa_2!=zupa_1 && zupa_2.equals(zupa_1)){
            System.out.println("Zupa została sklonowana (dwa różne obiekty, ale ten sam stan wewnętrzny)");
        }
    }

    public static void runAbstract(){

        //uzycie rejestru do przywoływania często używanych obiektów
        RegistryCache cache = new RegistryCache();

        PrototypeInterface prorotype_a = cache.get("prototype integer 4");
        PrototypeInterface prototype_b = cache.get("prototype boolean false");
        PrototypeInterface prototype_c = cache.get("prototype boolean false");

        if (prototype_c!=prototype_b && prototype_c.equals(prototype_b)){
            System.out.println("Cloned object match (not the same object but has the same values)");
        }

        //uzycie bezpośrednie obiektów do klonowania (klasyczne GoF prototype)
        PrototypeInterface prototype_1 = new ConcretePrototypeA("test_1",125);
        PrototypeInterface prototype_2 = prototype_1.clone();
        if(prototype_1!=prototype_2 && prototype_1.equals(prototype_2)){
            System.out.println("Classic clones match (not the same object but the same cloned values");
        }
    }

}

