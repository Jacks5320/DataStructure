package datastructures.demo6.f_avltree;

/**
 * 测试平衡二叉树模块
 */
public class AvlTreeDemo {
    public static void main(String[] args) {
        AvlTreeDemo demo = new AvlTreeDemo();
        AvlTree tree = new AvlTree();
        demo.add(tree);
        // 旋转
        System.out.println("树的高度：" + tree.root.height());
        System.out.println("根结点左子树的高度：" + tree.root.leftHeight());
        System.out.println("根结点右子树的高度：" + tree.root.rightHeight());
        System.out.println("当前根结点：" + tree.root);
    }

    public void add(AvlTree tree) {
        //int[] arr = {4, 3, 6, 5, 7, 8};// 左旋测试
        //int[] arr = {10, 12, 8, 9, 7, 6};// 右旋测试
        int[] arr = {10, 11, 7, 6, 8, 9};// 双旋测试
        for (int value : arr) {
            tree.add(new TreeNode(value));
        }
        tree.inorder();
    }
}
