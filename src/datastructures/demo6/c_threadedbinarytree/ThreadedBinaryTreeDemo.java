package datastructures.demo6.c_threadedbinarytree;

/**
 * 线索化二叉树
 * - n 个结点的二叉链表含有 n + 1 个空指针域【一共有 2 * n 个指针，除根节点外，每个结点都有 1 个指针指向自己，所以有效指针为 `n - 1`，空指针数 = `(2 * n) - (n - 1) = n + 1`】
 * - 将空指针域按照指定的遍历顺序(前序、中序或后序)指向当前结点的前驱结点和后继结点，这样的二叉树称作线索化二叉树(Threaded BinaryTree，线索二叉树)。
 * - 根据不同的遍历顺序，可分为前序线索二叉树、中序线索二叉树和后序线索二叉树
 *
 * ！！注意：线索化二叉树后，不能用原来的遍历方式来遍历该二叉树，会造成死归，导致栈溢出！！！！！！！
 * 根据线索化二叉树的特点，可以通过线性方式遍历
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        StudentThreadedBinaryTree tree = new StudentThreadedBinaryTree();
        // 线索化二叉树
        threadedTree(tree);
        // 遍历线索化二叉树
        tree.traverseInOrderThreadedBinary();
    }

    // 中序线索化
    public static void threadedTree(StudentThreadedBinaryTree tree) {
        // 创建结点
        StudentThreadedNode root = new StudentThreadedNode(1, "刘备");
        StudentThreadedNode node1 = new StudentThreadedNode(3, "关羽");
        StudentThreadedNode node2 = new StudentThreadedNode(6, "张飞");
        StudentThreadedNode node3 = new StudentThreadedNode(8, "小乔");
        StudentThreadedNode node4 = new StudentThreadedNode(10, "貂蝉");
        StudentThreadedNode node5 = new StudentThreadedNode(15, "孙尚香");
        tree.root = root;
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        tree.threadedNode();  // 中序线索化
        System.out.println("10结点的前驱=" + node4.left.id + " 10结点的后继=" + node4.right.id);
    }
}
