package algorithms.demo1.a_recursion;

/**
 * 递归通俗理解就是，方法自己调用自己。
 *
 * 程序运行时有：堆，栈、方法区、本地方法栈、程序计数器
 *
 * 执行到一个方法时，就创建一个新的受保护的独立空间（栈帧）放到栈区，这个独立空间中的数据（局部变量）是独立的。
 *
 * 栈帧中包含局部变量表、操作数栈、指向运行时常量池的引用、方法返回地址等。
 *
 * 当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕。
 */

public class RecursionDemo {
    public static void main(String[] args) {
        /* 比较两个方法的区别 */
        //rec(4);   // 只会打印 2
        rec2(4);  // 打印顺序为 2 3 4
    }

    /* 有 else 包裹 */
    public static void rec(int n) {
        if (n > 2) {
            rec(n - 1);
        } else {
            System.out.println("n = " + n);
        }
    }

    /* 没有 else 包裹 */
    public static void rec2(int n) {
        if (n > 2) {
            rec2(n - 1);
        }
        System.out.println("n = " + n);
    }
}
