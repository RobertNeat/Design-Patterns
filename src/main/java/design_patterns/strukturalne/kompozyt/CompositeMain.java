package design_patterns.strukturalne.kompozyt;


/*
* KOMPONENT - wspólny interfejs jaki implementują kompozyty (pojemniki) i liście, definiuje wspólne zacowanie jakie będą dostarczały liście i node
* KOMPOZYT (node) - klasa opakowująca która zawiera inne kompozyty albo liście (lista jako pole klasy), komunikuje się ze swoją zawartością poprzez interfejs komponentu, jeśli otrzyma polecenie to deleguje zadania zwoim elementom podrzędnym i zwraca wynik zbiorczy (może wykonywać dodatkowe operacje na danych uzyskanych od swoich podelementów
* LISC (leaf) -podstawowy element drzewa, który wykonuje docelowe operacje, nie posiadają elementów podrzędnych
*
*
*
*
* */

import design_patterns.strukturalne.kompozyt.definition.Leaf;
import design_patterns.strukturalne.kompozyt.definition.Node;

public class CompositeMain {
    public static void main(String[] args){
        runAbstract();
    }

    public static void run() {
        //Menu jako drzewo: kategorie zawierają dania i podkategorie, zestawy zawierają dania

        //menu->kuchnia (polska, włoska, niemiecka) -> typy dań (główne, desery, przystawki, okazjonalne) -> dania -> składniki

        //demonstracja wzorca
        System.out.println("composite");
    }


    public static void runAbstract(){
        Node tree = new Node();

        /*
        *      tree
        *     |    |
        *    n1   l1
        *   / |
        *  l2 n2
        *     |
        *     n3
        *     | \
        *     l3 l4
        * */

        Leaf l1 = new Leaf(1);
        Leaf l2 = new Leaf(2);
        Leaf l3 = new Leaf(3);
        Leaf l4 = new Leaf(4);

        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();

        n3.add(l3);
        n3.add(l4);

        n2.add(n3);

        n1.add(n2);
        n1.add(l2);

        tree.add(n1);
        tree.add(l1);

        System.out.println("Execute:"+tree.execute());
    }
}
