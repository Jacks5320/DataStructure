package demo4.a_stack;

import java.util.Scanner;

/**
 *  测试栈的基本功能
 */
public class StackTestDemo {
    public static void main(String[] args) {
        /* 数组模拟栈 */
        ArrayStack stack = new ArrayStack(4);
        /* 单链表模拟战 */
        //LinkedStack stack = new LinkedStack();

        Scanner sc = new Scanner(System.in);
        String str;  // 用于接收菜单输入
        boolean loop = true;  // 标志是否退出菜单

        while (loop) {
            System.out.println("show：展示栈中元素");
            System.out.println("push：添加元素");
            System.out.println("pop：弹出栈顶元素");
            System.out.println("top：展示栈顶数据");
            System.out.println("exit：结束程序");
            System.out.print("请输入操作命令：");
            str = sc.next();
            switch (str) {
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    System.out.print("请输入一个数：");
                    int pushVal = sc.nextInt();
                    stack.push(pushVal);
                    break;
                case "pop":
                    try {
                        int popVal = stack.pop();
                        System.out.println("出栈元素为：" + popVal);
                        //break;  // 不能写在这里，如果上面的 pop() 产生异常，就执行不到这里，处理完异常后，会直接跳到下一个 case 里面
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "top":
                    try {
                        int top = stack.getTopVal();
                        System.out.println("栈顶元素为：" + top);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出~");
    }
}
