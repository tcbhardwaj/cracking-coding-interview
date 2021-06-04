package org.practice.chapter2.linkedList;

public class _5_SumLIst {
    public static void main(String[] args) throws Exception{
//        approach1();
        approach2();
    }

    public static void approach1() throws Exception {
        Node list1 = new Node(9).append(7).append(8); //879
        Node list2 = new Node(6).append(8).append(5); //586 = 1465 => 5-> 6-> 4-> 1->
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

        if(carry>0){
            list3.append(carry);
        }

        list3.display();
    }

    public static void approach2() throws Exception {
        Node list1 = new Node(9).append(7).append(8); //879
        Node list2 = new Node(6).append(8).append(5); //586 = 1465 => 5-> 4-> 6-> 5->
        Node list3 = null;
        Node last = null;
        int num1 = 0;
        int num2 = 0;
        int multiplier = 1;

        while(list1 != null) {
            int x = list1.data;
            num1 = num1 + x * multiplier;
            multiplier = multiplier * 10;
            list1 = list1.next;
        }
        multiplier = 1;
        while(list2 != null) {
            int x = list2.data;
            num2 = num2 + x * multiplier;
            multiplier = multiplier * 10;
            list2 = list2.next;
        }

        int result = num1 + num2;
        System.out.println(result);
        while(result > 0) {
            int x = result % 10;
            if(list3 == null){
                list3 = new Node(x);
                last = list3;
            } else {
                Node node = new Node(x);
                last.next = node;
                last = node;
            }
            result = result/10;
        }

        list3.display();
    }
}
