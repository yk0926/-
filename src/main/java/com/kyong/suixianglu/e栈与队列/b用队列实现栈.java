package com.kyong.suixianglu.e栈与队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/29 11:28
 */
//225\用队列实现栈
public class b用队列实现栈 {

    Queue<Integer> queueA;
    Queue<Integer> queueB;

    public b用队列实现栈() {
        queueA = new LinkedList<Integer>();
        queueB = new LinkedList<Integer>();
    }

    public void push(int x) {
        queueB.offer(x);
        while (!queueA.isEmpty()){
            queueB.offer(queueA.poll());
        }
        Queue<Integer> temp = queueA;
        queueA = queueB;
        queueB = temp;
    }

    public int pop() {
        return queueA.poll();
    }

    public int top() {
        return queueA.peek();
    }

    public boolean empty() {
        return queueA.isEmpty();
    }
}
