package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hufei
 */
public class MyStack2 {

    /**
     * 输入队列
     */
    private Queue<Integer> queue = new LinkedList<>();

    public MyStack2() {
    }

    public void push(int x) {
        int length = queue.size();
        queue.offer(x);
        for (int i = 0; i < length; i++) {
            // 1 2 3
            // 3 2 1
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
class Test2{
    public static void main(String[] args) {
        MyStack2 myStack2 = new MyStack2();
        myStack2.push(1);
        myStack2.push(2);
        myStack2.push(3);
        System.out.printf("myStack2 : %d \n", myStack2.top());

    }
}
