package org.practice.tree;

public class MaxDepth {
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

        f.setLeftChild(g);

        System.out.println("Max depth: "+ maxDepth(a));

    }

    public static int maxDepth(Node<String> root) {

        if(root == null) {
            return 0;
        }

        if(root.getLeftChild() == null && root.getRightChild() == null){
            return 0;
        }

        int maxLeftDepth = maxDepth(root.getLeftChild());
        int maxRightDepth = maxDepth(root.getRightChild());

        return 1 + Math.max(maxLeftDepth, maxRightDepth);
    }
}
