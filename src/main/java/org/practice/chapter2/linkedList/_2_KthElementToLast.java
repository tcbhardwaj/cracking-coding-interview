package org.practice.chapter2.linkedList;

public class _2_KthElementToLast {

    public static void main(String[] args) throws Exception {
        Node head = new Node(10).append(20).append(30).append(40).append(50);

        Node k = findKthElementToLast(head, 5);

        System.out.println(k.data);
    }

    public static Node findKthElementToLast(Node head, int k) {
        int length = 0 ;

        Node p = head;
        while(p != null) {
            length++;
            p = p.next;
        }
        int i = 1;
        int index = length - k  + 1;
        p =  head;
        Node node = null;
        while(p != null && i <= index) {
            if(i == index){
                node = p;
            }
            i++;
            p = p.next;
        }

        return node;
    }
}
