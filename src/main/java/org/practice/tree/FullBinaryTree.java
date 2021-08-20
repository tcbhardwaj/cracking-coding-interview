package org.practice.tree;

public class FullBinaryTree {

    public static void main(String[] args) {
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");
        Node<String> g = new Node<>("G");

        a.setLeftChild(b);
        a.setRightChild(c);
        b.setLeftChild(d);

        System.out.println("Is full binary tree: "+ isFullBinaryTree(a));

    }

    public static boolean isFullBinaryTree(Node<String> root) {
        if(root == null){
            return true;
        }
        if(root.getLeftChild() == null && root.getRightChild() == null) {
            return true;
        }

        if(root.getLeftChild() != null && root.getRightChild() != null) {
            return isFullBinaryTree(root.getLeftChild()) && isFullBinaryTree(root.getRightChild());
        }

        return false;
    }
}
