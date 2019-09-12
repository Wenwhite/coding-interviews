package chap2;

import java.util.Stack;

/**
 * @ProjectName: coding-interviews
 * @Package: chap2
 * @ClassName: Test06
 * @Author: wenbai
 * @Description: 剑指offer第6题 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值。
 * @Date: 2019/9/12 21:23
 * @Version: 1.0
 */
public class Test06 {

    /**
     * 链表节点 尾节点的指针设为null
     */
    static class ListNode{
        int value;
        ListNode next;

        ListNode() {

        }

        ListNode(int value) {
            this.value = value;
        }

    }

    /**
     * 从尾到头打印 先进后出 首先想到栈
     * @param head 头节点
     */
    static void printList( ListNode head ){
        if (head==null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while ( node != null ) {
            stack.push(node.value);
            node = node.next;
        }

        while ( !stack.empty() ){
            System.out.print(stack.pop()+" ");
        }
    }

    /**
     * 【推荐】
     * 直接递归 先输出后面的节点 再输出本身
     * @param head
     */
    static void printList1( ListNode head ){
        if ( head == null ){
            return;
        }
        if ( head.next!=null ){
            printList1(head.next);
        }
        System.out.print(head.value+" ");

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node = head;

        for (int i = 1; i < 100; i++) {
            node.next = new ListNode(i);
            node.next.next = null;
            node = node.next;
        }


        printList(head);
        System.out.println();
        printList1(head);

    }


}
