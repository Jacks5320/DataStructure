package datastructures.demo6.a_binarytree;

import datastructures.demo6.StudentNode;

/**
 * 二叉树功能测试
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        add();
    }

    // 添加结点
    public static void add() {
        /*
            二叉树结构
                   1
                 /   \
                2     3
              /   \
             4     5
             前序遍历：1,2,4,5,3
             中序遍历：4,2,5,1,3
             后序遍历：4,5,2,3,1
         */
        // 创建二叉树
        StudentBinaryTree binaryTree = new StudentBinaryTree();
        // 创建结点
        StudentNode root = new StudentNode(1, "刘备");
        StudentNode node1 = new StudentNode(2, "关羽");
        StudentNode node2 = new StudentNode(3, "张飞");
        StudentNode node3 = new StudentNode(4, "小乔");
        StudentNode node4 = new StudentNode(5, "貂蝉");
        binaryTree.root = root;
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        // 先序遍历
        //binaryTree.preOrder();  // 1,2,4,5,3
        // 中序遍历
        binaryTree.inOrder();  // 4,2,5,1,3
        // 后序遍历
        //binaryTree.postOrder();  // 4,5,2,3,1
    }
}
