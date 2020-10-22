package datastructures.demo6.e_binarysorttree;

/**
 * 测试二叉排序树
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        int[] arr = {5, 3, 7, 1, 4, 6, 9, 2, 8};
        // 添加结点
        for (int value : arr) {
            tree.add(value);
        }
        System.out.println("根结点：" + tree.root);
        System.out.println("删除前：");
        tree.inorder();
        //tree.delNode(4);  // 叶子结点
        tree.delNode(5);  // 根结点
        //tree.delNode(1);  // 只有右子树的结点
        //tree.delNode(9);  // 只有左子树的结点
        System.out.println("删除后：");
        tree.inorder();
    }
}
