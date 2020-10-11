package datastructures.demo6.b_arraybinarytree;

/**
 * 顺序存储二叉树
 * 顺序存储结构的二叉树，只考虑完全二叉树
 * 特点：
 * - n 从 0 开始计数
 * - 第 n 个元素的左子结点为 `2 * n + 1`
 * - 第 n 个元素的右子结点为 `2 * n + 2`
 * - 第 n 个元素的父结点为 `(n - 1) / 2`
 */
public class ArrayBinaryTree {
    private int[] arr;  // 存储

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        // 重载方法，赋初始值
        preOrder(0);
    }

    public void inOrder() {
        inOrder(0);
    }

    public void postOrder() {
        postOrder(0);
    }

    /**
     * 前序遍历完全二叉树
     *
     * @param index 索引
     */
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空~");
            return;
        }
        // 先输出当前结点
        System.out.printf("%d\t",arr[index]);
        // 判断左子结点存不存在
        int temp = index * 2 + 1;
        if (temp < arr.length) {
            preOrder(temp);
        }
        // 判断右子结点是否存在
        temp += 1;  // 等价于 temp = index * 2 + 2
        if (temp < arr.length) {
            preOrder(temp);
        }
    }

    /**
     * 中序遍历完全二叉树
     * @param index 索引
     */
    public void inOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空~");
        }
        // 先左递归
        int temp = index * 2 + 1;
        if (temp < arr.length) {
            inOrder(temp);
        }
        // 再输出当前结点
        System.out.printf("%d\t",arr[index]);
        // 最后遍历右子树
        temp += 1;
        if (temp < arr.length) {
            inOrder(temp);
        }
    }

    /**
     * 后序遍历完全二叉树
     * @param index 索引
     */
    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空~");
            return;
        }
        // 先遍历左子树
        int temp = index * 2 + 1;
        if (temp < arr.length) {
            postOrder(temp);
        }
        // 再遍历右子树
        temp += 1;
        if (temp < arr.length) {
            postOrder(temp);
        }
        // 最后输出当前结点
        System.out.printf("%d\t", arr[index]);
    }
}
