package design_patterns.behawioralne.iterator.definition;

import design_patterns.behawioralne.iterator.definition.binary_tree.BinaryTreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

//ConcreteIterator
public class InOrderTreeIterator<E> implements InterfaceIterator<E> {
    //użycie struktury z zaimplementowanym stosem i metodami push(), pop(), peek()
    //stos przechowuje węzły, które jeszcze nie zostały zwrócone przez iterator
    Deque<BinaryTreeNode<E>> stack = new ArrayDeque<>();

    //iterator otrzymuje korzeń drzewa jako początkowy uchwyt struktury
    public InOrderTreeIterator(BinaryTreeNode<E> root){
        pushLeft(root);
    }

    //metoda pomocnicza pozwalająca na odkładanie węzłów przy schodzeniu w lewo
    private void pushLeft(BinaryTreeNode<E> node){
        while(node != null){
            stack.push(node);
            node=node.left;
        }
    }


    @Override
    public E next() {
        BinaryTreeNode<E> node = stack.pop();

        if(node.right != null) {
            pushLeft(node.right);
        }

        // wartość zwracana jest Object a sygnatura każe nam zwtacać <E>
        return node.value;
    }

    // zakomentowane trakże w interfejsie
//    @Override
//    public E previous() {
//        return null;
//    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
