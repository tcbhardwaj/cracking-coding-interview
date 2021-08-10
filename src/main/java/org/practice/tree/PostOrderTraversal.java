package org.practice.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PostOrderTraversal {
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

        postOrder(a);
        System.out.println();
        postOrderRecursive(a);
    }

    public static void postOrderRecursive(Node<String> root) {
        if(root == null)
            return;
        postOrderRecursive(root.getLeftChild());
        postOrderRecursive(root.getRightChild());
        System.out.print(root + "->");
    }

    public static void postOrder(Node<String> root) {
        if(root == null)
            return;

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
                stack.push(node);
                if(node.getRightChild() != null) {
                    stack.push(node.getRightChild());
                }
                if(node.getLeftChild() != null) {
                    stack.push(node.getLeftChild());
                }
            }
        }
    }
}
