package org.practice.chapter3.stackAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class _3_StackOfPlate {
    List<Stack<Integer>> stackList = new ArrayList<>();
    int CAPACITY = 3;
    public void push(Integer val) {
        Stack lastStack = getLastStack();

        if(lastStack != null && lastStack.size() < CAPACITY ) {
            lastStack.push(val);
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            stackList.add(stack);
        }
    }

    public int pop() {
        Stack<Integer> lastStack = getLastStack();

        if(lastStack == null) {
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }
        int val = lastStack.pop();
        if(lastStack.isEmpty() || lastStack.size() == 0) {
            stackList.remove(stackList.size()-1);
        }
        return val;
    }

    public void show() {
        System.out.println("Total stack:" + stackList.size());
        stackList.forEach(stack -> {
            stack.forEach(i -> System.out.print(i));
            System.out.println();
        });
    }

    private Stack<Integer> getLastStack(){
        if(stackList.isEmpty()){
            return null;
        }
        return stackList.get(stackList.size()-1);
    }

    public static void main(String[] args) {
        _3_StackOfPlate stackOfPlate = new _3_StackOfPlate();
        stackOfPlate.push(1);
        stackOfPlate.push(2);
        stackOfPlate.push(3);
        stackOfPlate.push(4);
        stackOfPlate.push(5);
        stackOfPlate.push(6);
        stackOfPlate.push(7);
        stackOfPlate.show();
        stackOfPlate.pop();
        stackOfPlate.show();
        stackOfPlate.pop();
        stackOfPlate.pop();
        stackOfPlate.show();

    }
}
