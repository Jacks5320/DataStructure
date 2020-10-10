package datastructures.demo6;

/**
 * 树结构中的结点
 */
public class StudentNode {
    public int id;
    public String name;
    public datastructures.demo6.StudentNode left;  // 左结点
    public datastructures.demo6.StudentNode right;  // 右结点

    public StudentNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 先序遍历：先输出父结点，再遍历左子树和右子树
    public void preOrder() {
        // 先输出父结点
        System.out.printf("学号=%d，姓名=%s\n", this.id, this.name);
        // 遍历左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        // 遍历右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历：先遍历左子树，再输出父结点，最后遍历右子树
    public void inOrder() {
        // 先遍历左子树
        if (this.left != null) {
            this.left.inOrder();
        }
        // 再输出父结点
        System.out.printf("学号=%d，姓名=%s\n", this.id, this.name);
        // 最后再遍历右子树
        if (this.right != null) {
            this.right.inOrder();
        }
    }

    // 后序遍历：先遍历左子树和右子树，最后输出父结点
    public void postOrder() {
        // 先遍历左子树
        if (this.left != null) {
            this.left.postOrder();
        }
        // 再遍历右子树
        if (this.right != null) {
            this.right.postOrder();
        }
        // 最后输出父结点
        System.out.printf("学号=%d，姓名=%s\n", this.id, this.name);
    }
}
