package com.interview.algorithms.stack.queues;

import com.example.datastructures.Stack;
/**
 * 
 * @author ajitkoti
 *
 */
public class InPlaceStackReversal {
    public static void reverse(Stack<String> stack){
        String element = stack.pop();
        if(stack.size() != 1) {
            reverse(stack);
        }
        pushToBottomOfStack(element,stack);
    }
 
 
    private static void pushToBottomOfStack(String data, Stack<String> stack){
        String element = stack.pop();
        if(stack.size() != 0){
            pushToBottomOfStack(data, stack);
        }
        else {
            stack.push(data);
        }
        stack.push(element);
    }
 
    public static void main(String args[]) {
        Stack<String> myStack = new Stack<String>(5);
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        System.out.println("Original Stack : " + myStack);
        InPlaceStackReversal.reverse(myStack);
        System.out.println("Revered Stack : " + myStack);
 
    }
}

