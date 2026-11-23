package design_patterns.behawioralne.iterator.definition;

import design_patterns.behawioralne.iterator.definition.circular_list.CircularListNode;

//ConcreteCollection
public class CircularList<E> implements InterfaceCollection<E> {
    private CircularListNode<E> head;
    private CircularListNode<E> tail;

    public CircularList(){
        this.head=null;
        this.tail=null;
    }

    public void add (E value){
        CircularListNode<E> new_node = new CircularListNode<>(value);

        //pierwszy element listy
        if(head == null){
            head=new_node;
            tail=new_node;

            //lista jednoelementowa wskazuje sama na siebie
            new_node.next = new_node;
        }else{
            tail.next = new_node;
            tail=new_node;

            //Ostatni element zawsze wskazuje na początek
            tail.next = head;
        }
    }

    public CircularListNode<E> getHead(){
        return head;
    }

    @Override
    public InterfaceIterator<E> createIterator() {
        return new CircularListIterator<>(head);
    }
}



//  ----|     ----------
//  |   \/    |        |
// [a]  [b]  [c]       |
//  /\   |   /\        |
//  |    -----|        |
//  |-------------------