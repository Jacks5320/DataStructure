package datastructures.demo6.f_avltree;

/**
 * 树节点
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
        return "TreeNode{value=" + value + "}";
    }

    /* 先序遍历 */
    public void preorder() {
        System.out.println(this);
        if (this.left != null) this.left.preorder();
        if (this.right != null) this.right.preorder();
    }

    /* 中序遍历 */
    public void inorder() {
        if (this.left != null) this.left.inorder();
        System.out.println(this);
        if (this.right != null) this.right.inorder();
    }

    /* 查找目标结点 */
    public TreeNode search(TreeNode node) {
        if (this.value == node.value) {  // 找到直接返回
            return this;
        } else if (this.value > node.value && this.left != null) {  // 目标结点的值比当前结点的值小，且当前结点存在左子树，则继续向左子树查找
            return this.left.search(node);
        } else if (this.value < node.value && this.right != null) {  // 目标结点的值比当前结点的值大，且当前结点存在右子树，则继续向右子树查找
            return this.right.search(node);
        } else {  // 如果目标结点的值不等于当前结点，且当前结点没有对应的子树时，说明不存在。
            return null;
        }
    }

    /* 查找某个结点的父结点 */
    public TreeNode searchParent(TreeNode node) {
        if (this.left != null && this.left.value == node.value) {  // 目标结点是当前结点的左孩子
            return this;
        } else if (this.right != null && this.right.value == node.value) {  // 目标结点是当前结点的右孩子
            return this;
        } else {  // 目标结点不是当前结点的孩子
            if (this.value > node.value && this.left != null) {  // 目标结点可能在当前结点的左子树中，且当前结点的左子树存在
                return this.left.searchParent(node);
            } else if (this.value <= node.value && this.right != null) {  // 目标结点可能在当前结点的右子树中，且当前结点的右子树存在
                return this.right.searchParent(node);
            } else {  // 目标可能存在与当前结点的子树中，但是当前结点的子树不存在
                return null;
            }
        }
    }

    /* 获取指定结点为根结点的树的高度 */
    public int height() {
        int max;
        int maxL = 0;
        int maxR = 0;
        if (left != null) maxL = left.height();
        if (right != null) maxR = right.height();
        max = maxL > maxR ? maxL + 1 : maxR + 1;
        return max;
    }

    public int leftHeight() {
        if (left == null) return 0;
        return left.height();
    }

    public int rightHeight() {
        if (right == null) return 0;
        return right.height();
    }

    /* 左旋 */
    public void leftRotate() {
        // 命中不平衡二叉树的根结点，用当前根结点的值创建新的结点
        TreeNode node = new TreeNode(value);
        // 将新结点的左子树设置为当前结点的左子树
        node.left = left;
        // 将新结点的右子树设置当前结点右孩子的左子树
        node.right = right.left;
        // 用当前结点右孩子的值覆盖当前结点的值
        value = right.value;
        // 删除当前结点的右孩子
        right = right.right;
        // 将当前结点的左孩子设置为新结点
        left = node;
    }

    /* 右旋 */
    public void rightRotate() {
        // 命中不平衡二叉树的最小子树的根结点，将根结点的值取出创建新的结点
        TreeNode node = new TreeNode(value);
        // 新结点的右子树设置成当前结点的右子树
        node.right = right;
        // 新结点的左子树设置成当前结点左孩子的右子树
        node.left = left.right;
        // 用左孩子的值覆盖当前结点的值
        value = left.value;
        // 删除当前结点的左孩子
        left = left.left;
        // 将当前结点的右孩子设置成新结点
        right = node;
    }

    /* 添加新结点 */
    public void add(TreeNode node) {
        if (node == null) return;
        // 如果待插入结点小于当前结点，就往当前结点的左子树中寻找插入位置
        if (node.value < this.value) {
            if (this.left == null) {// 没有左孩子直接插入
                this.left = node;
            } else {  // 有左孩子，继续查找
                this.left.add(node);
            }
        } else {  // 如果待插入节点不小于当前结点，就往当前结点的右子树中寻找插入位置
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        // 添加完成后，判断是否需要旋转

        // RR 或 RL 型
        if (rightHeight() - leftHeight() > 1) {
            // 如果右子结点存在，且右子结点的左子树比右子结点的右子树的高，那么就是 RL 型
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();  // 右旋
            }
            leftRotate();  // RR，左旋
            return;
        }
        // LL 或 LR 型，
        if (leftHeight() - rightHeight() > 1) {
            // 如果左子结点存在，且左子结点的右子树比左子结点的左子树高，那么就是 RL 型
            if (left != null && left.rightHeight() > left.leftHeight() ) {  // LR 型，先左旋再右旋
                left.leftRotate();  // 左旋
            }
            rightRotate();  // LL型，右旋
        }
    }

}
