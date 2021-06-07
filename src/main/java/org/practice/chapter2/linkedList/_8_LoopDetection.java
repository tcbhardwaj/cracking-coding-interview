package org.practice.chapter2.linkedList;

import java.util.HashSet;
import java.util.Set;

public class _8_LoopDetection {
    public static void main(String[] args) throws Exception {
        Node node = new Node(5);
        Node list1 = new Node(1).append(node).append(5).append(node);


        System.out.println(node);
        Node circularNode = approach1(list1);
        System.out.println(circularNode);
    }

    public static Node approach1(Node list1) {
        Set<Node> listSet = new HashSet<>();
        Node duplicateNode = null;
        while(list1 != null) {
            boolean inserted = listSet.add(list1);
            if(!inserted) {
                duplicateNode = list1;
                break;
            }
            list1 = list1.next;
        }
        return duplicateNode;
    }
}
