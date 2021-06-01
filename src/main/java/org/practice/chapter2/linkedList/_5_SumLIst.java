package org.practice.chapter2.linkedList;

public class _5_SumLIst {
    public static void main(String[] args) throws Exception {
        Node list1 = new Node(7).append(1).append(6); //617
        Node list2 = new Node(5).append(9); //95 = 712 => 2-> 1-> 7->
        Node list3 = null;
        Node lastNode = null;
        int carry = 0;
        while(list1 != null && list2 != null) {
            int sum = list1.data + list2.data;
            int data = sum % 10;
            if(list3 == null){
                Node node = new Node(data+carry);
                list3 = node;
                lastNode = node;
            } else {
                Node node = new Node(data+carry);
                lastNode.next = node;
                lastNode = node;
            }
            carry = (int) sum / 10;
            list1 = list1.next;
            list2 = list2.next;
        }

        if(list1 == null) {
            while(list2 != null){
                list3.append(list2.data+carry);
                carry = 0;
                list2 = list2.next;
            }
        } else {
            while(list1 != null){
                list3.append(list1.data+carry);
                carry = 0;
                list1 = list1.next;
            }
        }

        list3.display();
    }
}
