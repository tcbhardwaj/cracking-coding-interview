package org.practice.chapter2.linkedList;

import java.util.ArrayList;
import java.util.List;

public class _6_Palindrome {
    public static void main(String[] args) throws Exception {
        Node head = new Node(1).append(2).append(3).append(2).append(1);

        int top = 0;
        List<Integer> stack = new ArrayList<>();
        Node p = head;

        while(p!= null){
            stack.add(top++, p.data);
            p = p.next;
        }
        boolean isPalindrom = true;
        p = head;
        while(p != null) {
            if(p.data != stack.get(--top)) {
                isPalindrom = false;
                break;
            }
            p = p.next;
        }

        if(isPalindrom){
            System.out.println("List is palindrome");
        } else {
            System.out.println("List is NOT palindrome");
        }

    }
}
