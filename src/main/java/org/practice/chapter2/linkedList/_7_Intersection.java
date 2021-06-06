package org.practice.chapter2.linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _7_Intersection {
    public static void main(String[] args) throws Exception {
        Node commonNode = new Node(5);
        Node list1 = new Node(1).append(commonNode).append(5);
        Node list2 = new Node(1).append(2).append(commonNode).append(5);
        approach1(list1, list2);
    }

    public static void approach1(Node list1, Node list2) {
        Set<Node> set1 = new HashSet<>();
        boolean isIntersection = false;

        while(list1 != null){
            set1.add(list1);
            list1 = list1.next;
        }
        while(list2 != null){
            if(!set1.add(list2)) {
                isIntersection = true;
                break;
            }
            list2 = list2.next;
        }

        System.out.println(isIntersection);
    }
}
