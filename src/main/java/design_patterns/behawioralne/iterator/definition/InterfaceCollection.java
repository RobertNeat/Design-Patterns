package design_patterns.behawioralne.iterator.definition;

//np. java.util.Collection
// używamy generyków 'E' jako typu interfejsuIterator, żeby interfejsCollection nie zwrócił dowolnego typu interfejsIterator tylko konkretny typ ostateczny
public interface InterfaceCollection<E> {

    InterfaceIterator<E> createIterator();

}
