package design_patterns.behawioralne.iterator.definition;

import design_patterns.behawioralne.iterator.definition.binary_tree.BinaryTreeNode;

//ConcreteCollection
public class BinaryTree<E> implements InterfaceCollection<E> {

    BinaryTreeNode<E> tree_root;


    public BinaryTree(E root_value){
        this.tree_root=new BinaryTreeNode<>(root_value);
    }

    //jak na ten moment nadal nie wiem co w tej metodzie ma się wykonać .. podejrzewam że dopiero się doda implementację jak powstanie InOrderTreeIterator?
    @Override
    public InterfaceIterator<E> createIterator() {
        return new InOrderTreeIterator<>(tree_root);
    }


    public BinaryTreeNode<E> getRoot(){
        return tree_root;
    }


    //addLeft(parent,value)
    public BinaryTreeNode<E> addLeft(BinaryTreeNode<E> parent, E value){
        BinaryTreeNode<E> new_left_node = new BinaryTreeNode<>(value);
        parent.left = new_left_node;
        return new_left_node;
    }


    //addRight(parent,value)
    public BinaryTreeNode<E> addRight(BinaryTreeNode<E> parent, E value){
        BinaryTreeNode<E> new_right_node = new BinaryTreeNode<>(value);
        parent.right = new_right_node;
        return new_right_node;
    }
}
