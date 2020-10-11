package datastructures.demo6.c_threadedbinarytree;

/**
 * 实现了线索化功能的二叉树
 */
public class StudentThreadedBinaryTree {
    StudentThreadedNode root;  // 根结点
    // 指向当前结点的前驱结点的指针，方便线索化，初始值为 null
    // pre 始终指向当前待线索化结点的前驱结点
    StudentThreadedNode pre;

    public void threadedNode() {
        this.threadedNode(root);
    }

    /**
     * 中序线索化二叉树
     *
     * @param node 当前待线索化的结点
     */
    public void threadedNode(StudentThreadedNode node) {
        // node 为空时，不能线索化
        if (node == null) {
            return;
        }
        // 1. 线索化左子树
        threadedNode(node.left);

        // 2. 线索化父结点
        // 2.1 处理左指针
        if (node.left == null) {  // 如果当前结点没有左孩子，就让其指向前驱结点
            node.left = pre;
            node.leftType = 1;  // 标志左指针指向的是前驱结点
        }
        // 2.2 处理右指针
        if (pre != null && pre.right == null) {  // 当 pre != null，且 pre 没有右孩子，让其指向后继结点（当前结点）
            pre.right = node;
            pre.rightType = 1;  // 标志右指针指向后继结点
        }
        // 线索化完成后，将 pre 指向当前结点，成为下一个待线索化结点的前驱结点
        pre = node;
        // 3. 线索化右子树
        threadedNode(node.right);
    }

    /**
     * 遍历中序线索二叉树
     */
    public void traverseInOrderThreadedBinary() {
        // 从 root 位置开始遍历
        StudentThreadedNode node = root;
        // node == null 时，说明已经遍历完成
        while (node != null) {
            // 如果当前结点的 left 指向的是左子树(leftType==0)，就继续遍历左子树
            while (node.leftType == 0) {
                node = node.left; // 往左子树遍历
            }
            // 循环结束后，一定能找到 leftType = 1 的结点，输出这个结点
            System.out.printf("学号=%d，姓名=%s\t", node.id, node.name);
            // 如果当前结点的 right 指向的是后继结点（right == 1），就继续输出
            while (node.rightType == 1) {
                // 获取当前结点的后继结点
                node = node.right;
                // 输出这个结点
                System.out.printf("学号=%d，姓名=%s\t", node.id, node.name);
            }
            // 循环结束后，当前结点的 right 指向右子树，继续遍历右指树
            node = node.right;
        }
    }
}
