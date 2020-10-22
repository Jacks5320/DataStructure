package datastructures.demo6.f_avltree;

/**
 * 平衡二叉树（AVL树）结点
 */
public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    /* 左子树的高度 */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    /* 右子树的高度 */
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    /* 树的高度 */
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /* 左旋转 */
    public void leftRotate() {
        // 创建新结点的值，以当前根结点的值
        TreeNode newNode = new TreeNode(value);
        // 新结点的左子树设置成当前结点的左子树
        newNode.left = left;
        // 把新结点的右子树设置为当前结点右子树的左子树
        newNode.right = right.left;
        // 把当前结点的值替换成右子结点的值
        value = right.value;
        // 把当前结点的右子树设置成右子树的右子树
        right = right.right;
        // 把当前结点的左子树设置成新的结点
        left = newNode;
    }

    /* 右旋转 */
    public void rightRotate() {
        // 创建新的结点
        TreeNode newNode = new TreeNode(value);

        newNode.right = right;

        newNode.left = left.right;

        value = left.value;

        left = left.left;

        right = newNode;
    }

    /**
     * 添加结点
     *
     * @param node 新结点
     */
    public void add(TreeNode node) {
        if (node == null) {
            return;
        }
        // 传入结点的值比当前树的根节点小，就从左子树中寻找插入位置
        if (node.value < this.value) {
            // 当前结点没有左子结点，就添加
            if (this.left == null) {
                this.left = node;
            } else {  // 否则就向左子树递归
                this.left.add(node);
            }
        } else {  // 传入结点不小于当前树的根节点，就从右子树中寻找插入位置。
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        // 当添加完一个结点后，如果左右子树高度的绝对值大于1，需要旋转
        // 左低右高左旋转
        if (rightHeight() - leftHeight() > 1) {
            // 右子树的左子树的高度大于它的右子树的右子树的高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                // 先对右子结点进行右旋转
                right.rightRotate();
            }
            leftRotate();  // 左旋转
            return;
        }
        if (leftHeight() - rightHeight() > 1) {  // 右低左高，右旋转
            if (left != null && left.rightHeight() > left.leftHeight()) {
                // 先对当前结点的左子树左旋转
                left.leftRotate();
            }
            rightRotate();
        }
    }

    /**
     * 查找目标结点
     *
     * @param value 待查结点的值
     * @return 目标结点
     */
    public TreeNode search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {  // 向左子树找
            if (this.left != null) {
                return this.left.search(value);
            }
            return null;
        } else {
            if (this.right != null) {
                return this.right.search(value);
            }
            return null;
        }
    }

    /**
     * 查找删除结点父结点
     *
     * @param value 待删除结点的值
     * @return 父结点
     */
    public TreeNode searchParent(int value) {
        // 目标结点是当前结点的左子结点
        if (this.left != null && value == this.left.value) return this;
        // 待删除结点是当前结点的右子结点
        if (this.right != null && value == this.right.value) return this;
        // 目标结点的值小于当前结点，遍历左子树
        if (value < this.value && this.left != null) return this.left.searchParent(value);
        // 目标结点的值大于当前结点，遍历右子树
        if (value > this.value && this.right != null) return this.right.searchParent(value);
        // 都不满足，返回 null
        return null;
    }

    /**
     * 中序遍历
     */
    public void inorder() {
        if (this.left != null) {
            this.left.inorder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.inorder();
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
