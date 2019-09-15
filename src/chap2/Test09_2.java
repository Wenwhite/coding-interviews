package chap2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test09_2
 * @Author: wenbai
 * @Description: 剑指offer第9题 2 用两个队列实现栈
 * 用两个栈实现一个队列 请实现
 * @Date: 2019/9/16 7:35
 * @Version: 1.0
 */
public class Test09_2 {

    static Queue<Integer> queue1 = new LinkedList<>();
    static Queue<Integer> queue2 = new LinkedList<>();

    static void push(int node) {
        if ( queue1.isEmpty() && queue2.isEmpty() ) {
            queue1.offer( node );
        }else if ( !queue1.isEmpty() ) {
            queue1.offer( node );
        }else {
            queue2.offer( node );
        }
    }

    static int pop() {
        if ( queue1.isEmpty() && queue2.isEmpty() ) {
            throw new RuntimeException("当前栈已空");
        }

        if ( !queue1.isEmpty() ) {
            int size = queue1.size();
            for (int i = 0; i < size-1; i++) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else {
            int size = queue2.size();
            for (int i = 0; i < size-1; i++) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }

    }



    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        push(4);
        System.out.println(pop());
        System.out.println(pop());
    }
}
