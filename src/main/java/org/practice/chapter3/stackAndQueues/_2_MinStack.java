package org.practice.chapter3.stackAndQueues;

import java.util.ArrayList;
import java.util.List;

public class _2_MinStack {
    private List<Integer> stack = new ArrayList<>();
    private List<Integer> minStack = new ArrayList<>();
    int top = -1;
    int minTop = -1;

    public void push(int val) {
        if(minTop == -1){
            minStack.add(++minTop, val);
        } else if (minTop >= 0 && val <= minStack.get(minTop)){
            minStack.add(++minTop, val);
        }

        stack.add(++top, val);
    }

    public int pop() {
        if(top == -1){
            System.out.println("Stack is empty");
            return Integer.MAX_VALUE;
        }

        int x = stack.remove(top--);
        if(x == minStack.get(minTop)){
            minStack.remove(minTop--);
        }

        return x;
    }

    public int min() {
        if(minTop == -1 || top == -1) {
            System.out.println("Stack is empty");
            return Integer.MAX_VALUE;
        }

        return minStack.get(minTop);
    }

    public static void main(String[] args) {
        _2_MinStack minStack = new _2_MinStack();
        minStack.push(10);
        minStack.push(8);
        System.out.println(minStack.min());
        minStack.push(5);
        minStack.push(3);
        minStack.push(3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }


}
