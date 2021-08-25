package org.practice.tree;

public class BinarySearchTree {
    public static void main(String[] args) {

        Node<Integer> root = new Node<>(10);

//        insertRecursive(root, 8);
//        insertRecursive(root, 15);
//        insertRecursive(root, 5);
//        insertRecursive(root, 20);
//        insertRecursive(root, -2);
//        insertRecursive(root, 22);
//        insertRecursive(root, 7);

        InOrderTraversal.inOrderRecursive(root);

//        System.out.println("\n"+lookup(root, 5));

        printRange(root, 2, 15);

        System.out.println("Is binary search tree? "+isBinarySearchTree(root));

    }

    public static void insert(Node<Integer> root, int data) {
        while(root != null) {
            if(root.getLeftChild() == null && data < root.getData()) {
                root.setLeftChild(new Node<>(data));
                break;
            } else if(root.getRightChild() == null && data > root.getData()) {
                root.setRightChild(new Node<>(data));
                break;
            }

            if(data > root.getData()) {
                root = root.getRightChild();
            } else {
                root = root.getLeftChild();
            }
        }
    }

    public static Node<Integer> insertRecursive(Node<Integer> root, int data) {

        if(root == null) {
            return new Node<>(data);
        }

        if(data <= root.getData()) {
            root.setLeftChild(insertRecursive(root.getLeftChild(), data));
        } else {
            root.setRightChild(insertRecursive(root.getRightChild(), data));
        }

        return root;
    }

    public static Node<Integer> lookup(Node<Integer> root, int data) {
        if(root == null) {
            return null;
        }

        if(root.getData() == data) {
            return root;
        }

        if(data <= root.getData()) {
            return lookup(root.getLeftChild(), data);
        } else {
            return lookup(root.getRightChild(), data);
        }
    }

    public static void printRange(Node<Integer> root, int low, int high) {
        if(root == null){
            return;
        }

        if(low < root.getData()) {
            printRange(root.getLeftChild(), low, high);
        }
        if(low <= root.getData() && root.getData() <= high) {
            System.out.println(root.getData());
        }
        if(high >= root.getData()) {
            printRange(root.getRightChild(), low, high);
        }
    }

    public static boolean isBinarySearchTree(Node<Integer> root) {
        if(root == null) {
            return true;
        }

        if(root.getLeftChild() != null) {
            if(root.getLeftChild().getData() > root.getData()) {
                return false;
            }
        }
        if(root.getRightChild() != null) {
            if (root.getRightChild().getData() <= root.getData()) {
                return false;
            }
        }

        return isBinarySearchTree(root.getLeftChild()) && isBinarySearchTree(root.getRightChild());
    }
}
