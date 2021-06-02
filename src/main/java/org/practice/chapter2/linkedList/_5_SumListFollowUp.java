package org.practice.chapter2.linkedList;

public class _5_SumListFollowUp {
    public static void main(String[] args) throws Exception {
        Node list1 = new Node(6).append(1).append(7); //617
        Node list2 = new Node(2).append(9).append(5); //295 = 912 => 9->1->2->
        Node list3 = null;
        int num1 = 0;
        int num2 = 0;
        while(list1 != null) {
            int x = list1.data;
            num1 = num1 *10 + x;
            list1 = list1.next;
        }
        while(list2 != null) {
            int x = list2.data;
            num2 = num2 *10 + x;
            list2 = list2.next;
        }
        int result = num1 + num2;
        System.out.println(result);
        while (result>0){
            int x = result % 10;
            if(list3 == null){
                list3 = new Node(x);
            } else {
                Node node = new Node(x);
                node.next = list3;
                list3 = node;
            }
            result = result/10;
        }

        list3.display();
    }
}
