package design_patterns.behawioralne.iterator.definition;

//np. java.util.Iterator
// używamy generyków 'E' jako typów danych, żeby umożliwić przechowywanie dowolnego typu danych per kolekcja (tj. cała kolekcja przechowuje dany typ)
public interface InterfaceIterator<E> {
    E next();//zwraca kolejny element i przesuwa iterator
    //E previous();//zwraca poprzedni element i przesuwa iterator wstecz
    boolean hasNext();//sprawdza, czy istnieje kolejny element
}
