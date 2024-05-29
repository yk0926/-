package com.kyong.suixianglu.e栈与队列;

import java.util.Stack;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/29 11:13
 */
//232.用栈实现队列
public class a用栈实现队列 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public a用栈实现队列() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){
            in2out();
        }
       return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
