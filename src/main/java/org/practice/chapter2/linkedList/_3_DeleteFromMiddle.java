package org.practice.chapter2.linkedList;

public class _3_DeleteFromMiddle {
    public static void main(String[] args) throws Exception {
        Node head = new Node(10).append(20);
        Node node = new Node(30);
        head = head.append(node).append(40).append(50);
        Node deletedNode = deleteFromMiddle(head, node);
        System.out.println(deletedNode.data);
        head.display();
    }

    public static Node deleteFromMiddle(Node head, Node nodeToDelete) {
        Node p = head;
        Node deletedNode = null;
        while(p != null && p.next != null) {
            if(p.next == nodeToDelete){
                deletedNode = p.next;
                p.next = p.next.next;
            }
            p = p.next;
        }
        return deletedNode;
    }
}
