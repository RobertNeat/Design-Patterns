package design_patterns.behawioralne.iterator.definition.circular_list;

public class CircularListNode<E> {
    public E value;//wartość bieżącego węzła
    public CircularListNode<E> next;//referencja na następny węzeł

    public CircularListNode(E value){
        this.value = value;
    }

}
