package chap2;

import java.util.Queue;
import java.util.Stack;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test09_1
 * @Author: wenbai
 * @Description: 剑指offer第9题 1 用两个栈实现队列
 * 用两个栈实现一个队列 请实现
 * @Date: 2019/9/15 21:54
 * @Version: 1.0
 */
public class Test09_1 {

    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队列操作 将元素存储在stact1中
     * @param node
     */
    static void enQueue(int node) {
        stack1.push( node );
    }

    /**
     * 出队列时 由于是先进先出 所以当stact2为空时 将stact1中的元素以后进先出的顺序存入stact2中
     * 此时stact2中的顺序与队列要求的先进先出顺序相同 然后进行出栈操作
     * @return 出队列元素
     */
    static int deQueue() {
        if ( stack1.empty() && stack2.empty() ) {
            throw new RuntimeException("队列为空");
        }

        if ( stack2.empty() ) {
            while ( !stack1.empty() ) {
                stack2.push( stack1.pop() );
            }

        }
        return stack2.pop();
    }


    public static void main(String[] args) {
        enQueue(1);
        enQueue(2);
        enQueue(3);
        System.out.println(deQueue());
        System.out.println(deQueue());
        enQueue(4);
        System.out.println(deQueue());
        System.out.println(deQueue());
    }

}
