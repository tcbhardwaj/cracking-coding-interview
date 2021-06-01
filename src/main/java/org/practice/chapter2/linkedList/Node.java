package org.practice.chapter2.linkedList;

public class Node {
    int data;
    Node next = null;

    public Node(int data){
        this.data = data;
    }
    public Node createNode(int data){
        Node node = new Node(data);

        return node;
    }

    public Node append(int data) throws Exception {
        if(this == null)
            throw new Exception("Head is null");

        Node p = this;
        while(p.next != null) {
            p = p.next;
        }
        p.next = createNode(data);
        return this;
    }

    public Node append(Node node) throws Exception {
        if(this == null)
            throw new Exception("Head is null");

        Node p = this;
        while(p.next != null) {
            p = p.next;
        }
        p.next = node;
        return this;
    }

    public void display() {
        Node p = this;
        System.out.println();
        while(p != null) {
            System.out.print(p.data+" -> ");
            p = p.next;
        }
    }
}
