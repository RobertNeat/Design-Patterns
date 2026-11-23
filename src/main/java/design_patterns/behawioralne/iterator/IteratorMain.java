package design_patterns.behawioralne.iterator;


/*
* Pozwala sekwencyjnie przechodzić po elementach kolekcji bez ujawniania jej struktury
*
* iterator - przechowuje zadania związane z przechodzeniem przez elementy kolekcji
* iterator - hermetuzyje wszystkie szczegóły przechodzenia przez kolejne elementy
* iterator - udostępnia metodę pobierającą elementy kolekcji
*
* interfejs ITERATOR - deklaruje działania niezbędne do sekwencyjnego przechodzenia przez elementy kolekcji
* KONKRETNY ITERATOR - klasa implementująca specyficzny algorytm przeglądania kolekcji
* interfejs KOLEKCJA - deklaruje przynajmniej jedną metodę która zwracaja typ zgodny z interfejsem iterator (tj. kolekcja zwraca swój iterator)
* KONKRETNA KOLEKCJA - klasa zwracająca nową instancję konkretnego iteratora
*
* */

//ConcreteIterator
//ConcreteCollection


import design_patterns.behawioralne.iterator.definition.BinaryTree;
import design_patterns.behawioralne.iterator.definition.CircularList;
import design_patterns.behawioralne.iterator.definition.InterfaceIterator;
import design_patterns.behawioralne.iterator.definition.binary_tree.BinaryTreeNode;

public class IteratorMain {
    public static void main(String[] args){
        run_abstract();
    }

    public static void run() {
        //bez implementacji na przykładzie restauracji bo by było to samo tylko z dodatkową warstwą semantyki nad strukturą danych
    }

    public static void run_abstract(){
        //1.stworzenie kolekcji drzewa binarnego (to nie część wzorca, tylko przygotowanie danych)
        BinaryTree<Integer> tree = new BinaryTree<>(10);

        //dodawanie węzłów do drzewa (to nie część wzorca, tylko przygotowanie danych)
        BinaryTreeNode<Integer> root = tree.getRoot();

        BinaryTreeNode<Integer> node_5 = tree.addLeft(root,5);
        BinaryTreeNode<Integer> node_15 = tree.addRight(root,15);

        tree.addLeft(node_5, 3);
        tree.addRight(node_5, 7);

        tree.addRight(node_15, 20);

        //          10
        //         /  \
        //        5   15
        //      /  \    \
        //     3    7   20

        //stworzenie iteratora na drzewie binarnym za pomocą abstrakcji (klient nie wie jaki to iterator i jak przechodzi wewnętrznie po strukturze)
        InterfaceIterator<Integer> iterator = tree.createIterator();
        System.out.println("-- Drzewo binarne");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //iterator wewnętrznie najpierw udaje się do node '3'
        //a później przez: 5 7 10 15 20


        //--------------------------------------------------
        //2. Kolekcja listy cyklicznej

        //Stworzenie kolekcji
        CircularList<Integer> list = new CircularList<>();

        //dodanie elementów
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        //Stworzenie iteratora
        InterfaceIterator<Integer> iterator_list = list.createIterator();
        System.out.println("-- Lista Cykliczna");

        //przejście po kolekcji (nie różni się niczym od przejścia po drzewie bo używamy tego samego interfejsu iteratora)
        while(iterator_list.hasNext()) {
            System.out.println(iterator_list.next());
        }
    }
}
