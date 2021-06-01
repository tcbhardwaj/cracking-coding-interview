package org.practice.chapter2.linkedList;

public class _4_PartitionLIst {
    public static void main(String[] args) throws Exception {
        Node head = new Node(10).append(30).append(50).append(20).append(40);
        int partition = 20;
        Node partitionList = partitionList(head, partition);

       partitionList.display();

    }

    public static Node partitionList(Node head, int partition) throws Exception {

        Node p = head;
        Node beforeHead = null;
        Node beforePartitionEnd = null;
        Node afterHead = null;
        Node afterPartitionEnd = null;
        while( p != null) {
            if(p.data < partition){
                if(beforeHead == null){
                    beforeHead = p;
                    beforePartitionEnd = p;
                } else{
                    beforePartitionEnd.next = p;
                    beforePartitionEnd = p;
                }
            } else {
                if(afterHead == null) {
                    afterHead = p;
                    afterPartitionEnd = p;
                } else {
                    afterPartitionEnd.next = p;
                    afterPartitionEnd = p;
                }
            }
            p = p.next;
        }

        if(beforeHead == null){
            return afterHead;
        }
        beforePartitionEnd.next = null;
        afterPartitionEnd.next = null;
        beforeHead.display();
        afterHead.display();
        beforeHead.append(afterHead);

        return beforeHead;
    }
}
