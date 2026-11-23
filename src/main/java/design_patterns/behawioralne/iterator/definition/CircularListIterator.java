package design_patterns.behawioralne.iterator.definition;

import design_patterns.behawioralne.iterator.definition.circular_list.CircularListNode;

public class CircularListIterator<E> implements InterfaceIterator<E> {
    private CircularListNode<E> start;//zapamiętuje początkowy węzeł, żeby nie zapętlić iteracji
    private CircularListNode<E> current;//wskazuje aktualnie przetwarzany węzeł

    private boolean first_iteration = true;//pozwala odróżnić pierwsze przejście od powrotu do węzła startowego
    //'current != start' musi też sprawdzać czy jest 'first_iteration' bo inaczej nie można byłoby wypisać żadnego elementu przez początkowy stan

    public CircularListIterator(CircularListNode<E> start) {
        this.start = start;
        this.current = start;
    }

    @Override
    public boolean hasNext() {
        return current != null &&
                (first_iteration || current != start);
    }

    @Override
    public E next() {
        if (!hasNext()){
            throw new java.util.NoSuchElementException();
        }

        E value = current.value;

        current = current.next;
        first_iteration = false;

        return value;
    }

}
