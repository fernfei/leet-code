package queue;

import java.util.Stack;

/**
 * 用栈实现队列
 *
 * @author hufei
 */
public class MyQueue {

    private Stack<Integer> stackIn = new Stack<>();
    private Stack<Integer> stackOut = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        // 2
        // 1
        // 1 2
        // 2 1
        // 3
        // 1 2 3
        // 3 2 1
        // 4
        // 1 2 3 4
        //1.先将反转好的[2,1] stack给反转回来[1,2] 在添加元素[3]
        int size = stackOut.size();
        for (int i = 0; i < size; i++) {
            stackIn.push(stackOut.pop());
        }
        stackIn.push(x);
        //2.再将未反转的元素[1,2,3] 反转回来 [3,2,1]
        int size1 = stackIn.size();
        for (int i = 0; i < size1; i++) {
            stackOut.push(stackIn.pop());
        }
    }

    public int pop() {
        return stackOut.pop();
    }

    public int peek() {
        return stackOut.peek();
    }

    public boolean empty() {
        return stackOut.isEmpty();
    }
}

class Test {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        int peek = myQueue.peek();
        System.out.printf("");


    }
}
