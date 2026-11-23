package design_patterns.behawioralne.iterator.definition.binary_tree;

//klasa dodatkowa modelująca węzeł w drzewie binarnym (potrzebna, ponieważ wykorzystana jest struktura drzewa jako przykład kolekcji)
//nie wchodzi w skład zworca projektowego iterator
public class BinaryTreeNode<E> {
    public E value;
    public BinaryTreeNode<E> left;
    public BinaryTreeNode<E> right;


    public BinaryTreeNode(E value){
        this.value=value;
    }
}
