package datastructures.demo6.a_binarytree;

import datastructures.demo6.StudentNode;

/**
 * 学生二叉树结构
 */
public class StudentBinaryTree {
    StudentNode root;  // 根结点
    // 添加结点


    // 先序遍历：先输出父结点，再遍历左子树和右子树
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空~");
        }
    }

    // 后序遍历
    public void inOrder() {
        if (root != null) {
            root.inOrder();
        } else {
            System.out.println("二叉树为空~");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空~");
        }
    }
}
