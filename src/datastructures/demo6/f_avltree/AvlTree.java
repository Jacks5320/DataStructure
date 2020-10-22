package datastructures.demo6.f_avltree;

/**
 *  平衡二叉树（AVL树）
 */
public class AvlTree {
    public TreeNode root;  // 根节点

    /**
     * 添加结点
     *
     * @param node 新结点
     */
    public void add(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 查找待删除结点
     *
     * @param value 待查找结点的值
     * @return 待删除结点
     */
    public TreeNode search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    /**
     * 查找父结点
     *
     * @param value
     * @return
     */
    public TreeNode searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 删除右子树的根结点
     * @param node 右子树根结点
     */
    public int delRightTreeMin(TreeNode node) {
        TreeNode target = node;
        // 找到最小的结点
        while (target.left != null) {
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }

    /**
     * 删除结点
     *
     * @param value 待删除结点的值
     */
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            TreeNode targetNode = search(value);
            if (targetNode == null) return;

            if (root.left == null && root.right == null) {  // 只有 root 一个结点，且为待删除的结点
                root = null;  // 置空即可
                return;
            }
            TreeNode parent = searchParent(value);
            // 1. 删除的是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) {  // 左子结点
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {  // 右子结点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {  // 2. 删除有两个子树的结点
                int min = delRightTreeMin(targetNode.right);
                targetNode.value = min;
            } else {  // 3. 删除只有一棵子树的结点
                if (targetNode.left != null) {  // 删除的是左子树
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {  // 删除的是右子树
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }

        }
    }

    /**
     * 中序遍历
     */
    public void inorder() {
        if (root == null) {
            System.out.println("树为空~");
        } else {
            root.inorder();
        }
    }
}
