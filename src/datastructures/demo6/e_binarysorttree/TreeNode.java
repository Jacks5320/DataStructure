package datastructures.demo6.e_binarysorttree;

/**
 * 二叉排序树BST结点
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }

    /* 中序遍历 */
    public void inorder() {
        if (this.left != null) this.left.inorder();

        System.out.println(this);

        if (this.right != null) this.right.inorder();
    }

    /**
     * 添加节点
     *
     * @param node 待添加结点
     */
    public void add(TreeNode node) {
        if (node == null) return;
        // 待插入结点小于当前结点的值，在左子树中寻找插入位置
        if (node.value < this.value) {
            // 没有左孩子，直接插入左孩子位置
            if (this.left == null) {
                this.left = node;
            } else {  // 有左孩子，继续比较
                this.left.add(node);
            }
        } else {  // 待插入节点大于等于当前结点，在右子树中寻找插入位置
            // 没有右子树，直接插入右孩子的位置
            if (this.right == null) {
                this.right = node;
            } else {  // 有右孩子就继续比较
                this.right.add(node);
            }
        }
    }

    /**
     * 查找目标结点
     *
     * @param node 待查找结点
     * @return 存在返回 true，不存在返回false
     */
    public TreeNode search(TreeNode node) {
        if (this.value == node.value) {  // 目标结点找到
            return this;
        } else if (this.left != null && this.value > node.value) {  // 如果目标结点小于当前结点，往左子树找
            return this.left.search(node);
        } else if (this.right != null && this.value < node.value) {  // 目标结点比当前结点大，往右子树找
            return this.right.search(node);
        } else {  // 都不满足，说明不存在
            return null;
        }
    }

    /**
     * 查找某个结点的父结点
     *
     * @param node 待删除结点
     */
    public TreeNode searchParent(TreeNode node) {
        // 如果目标结点比当前结点小，往当前结点的左子树找
        if (node.value < this.value) {
            if (this.left != null) {
                if (this.left.value == node.value) {
                    return this;
                } else {
                    return this.left.searchParent(node);
                }
            }
        } else if (node.value > this.value) {  // 目标结点大于当前结点时，往当前结点的右子树找
            if (this.right != null) {
                if (this.right.value == node.value) {
                    return this;
                } else {
                    return this.right.searchParent(node);
                }
            }
        }
        return null;
    }
}
