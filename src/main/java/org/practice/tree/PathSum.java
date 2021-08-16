package org.practice.tree;

public class PathSum {
    public static void main(String[] args) {
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(5);
        Node<Integer> f = new Node<>(6);
        Node<Integer> g = new Node<>(7);
        Node<Integer> h = new Node<>(8);

        a.setLeftChild(b);
        a.setRightChild(c);

        b.setLeftChild(d);
        b.setRightChild(e);

        System.out.println("Has path of sum 8: " + hasPathSum(a, 4));
    }

    public static boolean hasPathSum(Node<Integer> root, int sum) {
        if(root == null){
            return false;
        }

        if(root.getLeftChild() == null && root.getRightChild() == null){
            return sum == root.getData();
        }

        boolean hasPathSumLeft = hasPathSum(root.getLeftChild(), sum - root.getData());
        boolean hasPathSumRight = hasPathSum(root.getRightChild(), sum - root.getData());

        return hasPathSumLeft || hasPathSumRight;
    }
}
