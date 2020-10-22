package datastructures.demo6.e_binarysorttree;

/**
 * 二叉排序树BST
 */
public class BinarySortTree {
    TreeNode root;  // 根结点

    /* 中序遍历 */
    public void inorder() {
        if (root == null) {
            System.out.println("树为空~");
        } else {
            root.inorder();
        }
    }

    /* 添加一个结点 */
    public void add(int value) {
        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /* 删除指定结点 */
    public void delNode(int value) {
        // 树为空，退出
        if (root == null) return;

        // 查找待删除结点是否存在
        TreeNode targetNode = root.search(new TreeNode(value));

        // 待删除结点不存在，退出
        if (targetNode == null) return;

        // 命中待删除结点的父结点
        TreeNode parent = root.searchParent(targetNode);

        // 情况1：删除的结点无子树，即叶子结点。
        if (targetNode.left == null && targetNode.right == null) {
            if (parent == null) {  // 待删除叶子结点是根结点
                root = null;
            } else if (parent.left == targetNode) {  // 待删除叶子结点是左孩子
                parent.left = null;
            } else {  // 待删除叶子结点是右孩子
                parent.right = null;
            }
        } else if (targetNode.left != null && targetNode.right == null) {  // 情况2：待删除的结点只有左子树
            if (parent == null) {  // 待删除结点是根结点，且它只有左子树，直接将 root 指向左子结点即可
                root = root.left;
            } else if (parent.left != null && parent.left.value == value) {  // 待删除结点是左子结点
                parent.left = targetNode.left;
            } else {  // 待删除的结点是右子节点
                parent.right = targetNode.left;
            }
        } else if (targetNode.left == null) {  // 情况3：待删除的结点只有右子树
            if (parent == null) {  // 待删除结点是根结点，且它只有右子树，直接将 root 指向右子结点即可
                root = root.right;
            } else if (parent.left != null && parent.left.value == value) {  // 待删除结点是左子结点
                parent.left = targetNode.right;
            } else {  // 待删除的结点是右子节点
                parent.right = targetNode.right;
            }
        } else {  // 情况4：待删除结点既有左子树，又有右子树
            // 处理方案1：命中左子树中的最大值（最右下的叶子结点），保留下最大结点的值，然后删除这个结点，最后将保留的值覆盖到待删除的目标节点
            TreeNode maxNode  = targetNode.left;  // 从目标结点左子树的根节点开始
            while (maxNode .right != null) {
                maxNode  = maxNode .right;
            }
            delNode(maxNode .value);
            targetNode.value = maxNode .value;
            // 处理方案2：命中右子树中的最小值（最左下结点），将它的值覆盖删除结点的值，然后将它删除
        }
    }
}
