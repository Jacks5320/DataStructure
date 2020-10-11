package datastructures.demo6.b_arraybinarytree;

/**
 * 顺序存储结构的二叉树，只考虑完全二叉树
 * 特点：
 * - n 从 0 开始计数
 * - 第 n 个元素的左子结点为 `2 * n + 1`
 * - 第 n 个元素的右子结点为 `2 * n + 2`
 * - 第 n 个元素的父结点为 `(n - 1) / 2`
 */
/*完全二叉树结构
     1
   /   \`+/*-
  2     3
 / \   / \
4   5 6   7
先序：1,2,4,5,3,6,7
中序：4,2,5,1,6,3,7
后序：4,5,2,6,7,3,1
 */
public class ArrayTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        traverse(tree);
    }

    public static void traverse(ArrayBinaryTree tree) {
        // 先序遍历
        //tree.preOrder();
        // 中序遍历
        //tree.inOrder();
        // 后序遍历
        tree.postOrder();
    }
}
