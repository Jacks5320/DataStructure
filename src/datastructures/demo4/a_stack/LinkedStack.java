package datastructures.demo4.a_stack;

/**
 * 用单链表链表模拟栈
 */
public class LinkedStack {
    /* 头节点，代表栈顶 */
    StackNode head = new StackNode(0);
    public int length = 0;

    /* 封装节点 */
    public static StackNode getNode(int val) {
        return new StackNode(val);
    }

    /* 栈空 */
    public boolean isEmpty() {
        return head.next == null;
    }

    /* 入栈 */
    public void push(int value) {
        StackNode node = getNode(value);
        /* 头插法 */
        node.next = head.next;
        head.next = node;
        length++;
    }

    /* 出栈 */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空~");
        }
        int val = head.next.data;  // 取出第一个数据
        head.next = head.next.next;  // (head -> 1 -> 2) ==> (head -> 2) ==>  (1 被 取出)
        length--;
        return val;
    }

    /* 遍历栈 */
    public void showStack() {
        if (head.next == null) {
            System.out.println("栈为空~");
            return;
        }

        StackNode temp = head.next;

        for (int i = length - 1; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, temp.data);
            temp = temp.next;
        }

        /*
        int i = length;

        while (temp.next != null) {
            temp = temp.next;
            System.out.printf("stack[%d]=%d", i--, temp.data);
        }
         */
    }

    /* 获取栈顶元素 */
    public int getTopVal() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空~");
        }
        return head.next.data;
    }
}

class StackNode {
    public int data;  // 数据域
    public StackNode next;  // 指针域

    public StackNode(int data) {
        this.data = data;
    }
}