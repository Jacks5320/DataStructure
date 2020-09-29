package demo4.a_stack;

/**
 * 数组模拟栈结构
 */
public class ArrayStack {
    private int maxSize;  // 栈的大小
    private int top;  // 栈顶指针
    private int[] stack;  // 存储数据

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;  // 初始化为 -1 标识栈为空
        this.stack = new int[maxSize];
    }

    /* 判断栈空 */
    public boolean isEmpty() {
        return top == -1;
    }

    /* 判断栈满 */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /* 插入数据：入栈 */
    public void push(int val) {
        if (isFull()) {
            System.out.println("栈满，不能添加数据");
            return;
        }
        top++;  // 将 top 上移
        stack[top] = val;  // 为 top 指向位置赋值
        /* 以上 2 行可以合成一行 */
        //stack[++top] = val;
    }

    /*删除数据：出栈*/
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，没有数据可以出栈~");
        }

        int ret = stack[top];
        top--;
        return ret;
        /* 以上 3 行可以合成一行 */
        //return stack[top--];
    }

    /* 取得栈顶元素 */
    public int getTopVal() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空，没有数据~");
        }
        return stack[top];
    }

    /* 遍历栈中元素：自顶向下遍历 */
    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈为空，没有数据~");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d \n", i, stack[i]);
        }
    }
}
