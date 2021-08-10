package org.practice.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PreOrderTraversal {

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

        preOrder(a);
        System.out.println();
        preOrderRecursive(a);
    }

    public static void preOrderRecursive(Node<String> root) {
        if(root == null)
            return;

        System.out.print(root + "->");
        preOrderRecursive(root.getLeftChild());
        preOrderRecursive(root.getRightChild());
    }

    public static void preOrder(Node<String> root) {
        if(root == null) {
            return;
        }

        Stack<Node<String>> stack = new Stack<>();
        Set<Node<String>> visitedNode = new HashSet<>();
        stack.push(root);

        while(!stack.empty()) {
            Node<String> node = stack.pop();

            if(node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.print(node + "->");
            } else if(visitedNode.contains(node)) {
                System.out.print(node + "->");
            } else {
                visitedNode.add(node);

                if(node.getRightChild() != null)
                    stack.push(node.getRightChild());
                if(node.getLeftChild() != null)
                    stack.push(node.getLeftChild());
                stack.push(node);
            }
        }
    }
}
