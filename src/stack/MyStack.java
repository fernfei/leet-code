package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 * @author hufei
 */
public class MyStack {
    /**
     * 输入队列
     */
    private Queue<Integer> a;
    /**
     * 输出队列
     */
    private Queue<Integer> b;

    public MyStack() {
        a = new LinkedList<>();
        b = new LinkedList<>();
    }

    public void push(int x) {
        a.offer(x);
        // 将b队列中元素全部转给a队列
        while (!b.isEmpty()) {
            a.offer(b.poll());
        }
        // 交换a和b,使得a队列没有在push()的时候始终为空队列
        Queue<Integer> temp = a;
        a = b;
        b = temp;
    }

    /**
     * 返回栈顶并删除
     * @return
     */
    public int pop() {
        return b.poll();
    }

    /**
     * 返回栈顶
     * @return
     */
    public int top() {
        return b.peek();
    }

    public boolean empty() {
        return b.isEmpty();
    }

}
class Test{
    public static void main(String[] args) {
        String a = "11231";
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        int top = myStack.top();
        int pop = myStack.pop();

        Queue<Integer> hufei = new LinkedList<>();
        hufei.offer(1);
        hufei.offer(3);
        hufei.offer(2);
        System.out.println("end");
    }
}
