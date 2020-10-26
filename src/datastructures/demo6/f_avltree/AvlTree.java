package datastructures.demo6.f_avltree;

/**
 * AVL 树，自平衡二叉查找树
 */
public class AvlTree {
    TreeNode root;

    /* 中序遍历 */
    public void inorder() {
        if (root == null) {
            System.out.println("树为空~");
        } else {
            root.inorder();
        }
    }

    /* 先序遍历 */
    public void preorder() {
        if (root == null) {
            System.out.println("数为空~");
        } else {
            root.preorder();
        }
    }

    /* 添加新结点 */
    public void add(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /* 查找目标结点 */
    public TreeNode search(int value) {
        if (root == null) return null;
        return root.search(new TreeNode(value));
    }
}
