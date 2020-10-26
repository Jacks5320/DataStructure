package datastructures.demo6.f_avltree;

public class AvlTreeDemo {
    public static void main(String[] args) {
        AvlTree tree = new AvlTree();
        //int[] arr = {5, 4, 3, 2, 1};// LL型，右旋测试
        //int[] arr = {1, 2, 3, 4, 5};  // RR型，左旋测试
        //int[] arr = {5, 2, 6, 1, 4, 3}; // LR型，先左旋再右旋测试
        int[] arr = {2, 1, 5, 3, 6, 4};  // RL 型，先右旋再左旋测试

        for (int i : arr) {
            tree.add(new TreeNode(i));
        }
        System.out.println("整棵树的高度：" + tree.root.height());
        System.out.println("根结点左子树的高度" + tree.root.leftHeight());
        System.out.println("根结点右子树的高度" + tree.root.rightHeight());
        System.out.println("先序遍历结果：");
        tree.preorder();
        System.out.println("中序遍历结果：");
        tree.inorder();
    }
}
