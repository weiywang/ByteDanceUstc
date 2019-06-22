package main.java.DataStructure;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> innerStack;
    private Stack<Integer> minStack;

    public MinStack() {
        innerStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        innerStack.push(x);
        if(minStack.empty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public Integer pop() {
        if(!innerStack.empty()){
            Integer popNum = innerStack.pop();
            if(popNum.equals(minStack.peek())){
                minStack.pop();
                return popNum;
            }
        }
        return null;
    }

    public Integer top() {
        if(!innerStack.empty()) {
            return innerStack.peek();
        }
        return null;
    }

    public Integer getMin() {
        if(!minStack.empty()) {
            return minStack.peek();
        }
        return null;
    }
}
