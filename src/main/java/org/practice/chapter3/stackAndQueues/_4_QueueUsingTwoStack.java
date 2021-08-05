package org.practice.chapter3.stackAndQueues;

import java.util.Stack;

public class _4_QueueUsingTwoStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();

    public void insert(int val) {
        if(stack.empty() && !tempStack.empty()){
            stack.push(tempStack.pop());
        }
        stack.push(val);
    }

    public int delete() {
        while(!stack.empty()){
            tempStack.push(stack.pop());
        }

         return tempStack.pop();
    }

    public static void main(String[] args) {
        _4_QueueUsingTwoStack obj = new _4_QueueUsingTwoStack();

        obj.insert(10);
        obj.insert(20);
        obj.insert(30);

        System.out.println(""+obj.delete());
        System.out.println(""+obj.delete());
        obj.insert(40);
        System.out.println(""+obj.delete());
    }
}
