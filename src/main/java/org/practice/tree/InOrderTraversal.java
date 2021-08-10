package org.practice.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class InOrderTraversal {
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

        c.setLeftChild(d);
        c.setRightChild(e);

        inOrder(a);
        System.out.println();
        inOrderRecursive(a);


    }

    public static void inOrderRecursive(Node<String> root) {

        if(root == null){
            return;
        }
        inOrderRecursive(root.getLeftChild());
        System.out.print(root + "->");
        inOrderRecursive(root.getRightChild());

    }

    public static void inOrder(Node<String> root) {
        if(root == null)
            return;

        Stack<Node<String>> stack = new Stack<>();
        Set<Node<String>> visitedNode = new HashSet<>();

        stack.push(root);

        while(!stack.empty()) {

            Node<String> top = stack.pop();


            if(top.getLeftChild() == null && top.getRightChild() == null) {
                System.out.print(top + "->");
            } else if(visitedNode.contains(top)) {
                System.out.print(top + "->");
            } else {
                visitedNode.add(top);

                if(top.getRightChild() != null) {
                    stack.push(top.getRightChild());
                }
                stack.push(top);
                if(top.getLeftChild() != null) {
                    stack.push(top.getLeftChild());
                }
            }
        }
    }
}
