package org.practice.tree;

public class CountBinaryTreeNode {
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

        c.setLeftChild(e);
        c.setRightChild(f);

        System.out.println(countNode(a));

    }

    public static int countNode(Node<String> root) {
        if(root == null) {
            return 0;
        }
        int leftCount = countNode(root.getLeftChild());
        int rightCount = countNode(root.getRightChild());

        return  1 + leftCount + rightCount;
    }
}
