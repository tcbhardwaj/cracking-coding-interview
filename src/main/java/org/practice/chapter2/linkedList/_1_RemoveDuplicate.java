package org.practice.chapter2.linkedList;

public class _1_RemoveDuplicate {
    public static void main(String[] args) throws Exception {
        Node head = new Node(10);
        head = head.append(20).append(20).append(40).append(30).append(10);
        head.display();

        Node p = head;
        while(p != null) {
            Node q = p;
            while(q != null && q.next != null) {
                if(p.data == q.next.data){
                    q.next = q.next.next;
                }
                q = q.next;
            }
            p = p.next;
        }

        head.display();
    }
}
