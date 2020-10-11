package datastructures.demo6.a_binarytree;

/**
 * 树结构中的结点
 */
public class StudentNode {
    public int id;
    public String name;
    public StudentNode left;  // 左结点
    public StudentNode right;  // 右结点

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

    // 先序遍历查找
    public StudentNode preOrderSearch(int id) {
        System.out.println("进入先序遍历~");
        // 当前结点为待查找结点
        if (this.id == id) {
            return this;
        }
        // 当前结点不是待查找结点时，需要向左遍历
        StudentNode node = null;
        if (this.left != null) {
            node = this.left.preOrderSearch(id);
        }
        if (node != null) return node;
        // 左子树没有找到，需要向右遍历
        if (this.right != null) {
            node = this.right.preOrderSearch(id);
        }
        return node;
    }

    // 中序遍历查找
    public StudentNode inOrderSearch(int id) {
        StudentNode node = null;
        // 先向左子树遍历
        if (this.left != null) {
            node = this.left.inOrderSearch(id);
        }
        if (node != null) {
            return node;
        }
        System.out.println("进入中序遍历~");
        // 判断是否找到
        if (this.id == id) {
            return this;
        }

        // 没找到向右遍历
        if (this.right != null) {
            node = this.right.inOrderSearch(id);
        }
        return node;
    }

    // 后序遍历查找
    public StudentNode postOrderSearch(int id) {
        // 先遍历左子树
        StudentNode node = null;
        if (this.left != null) {
            node = this.left.postOrderSearch(id);
        }
        if (node != null) {
            return node;
        }
        // 再遍历右子树
        if (this.right != null) {
            node = this.right.postOrderSearch(id);
        }
        if (node != null) {
            return node;
        }
        System.out.println("进入后序遍历~");
        // 最后判断父结点(当前结点)
        return this.id == id ? this : null;
    }

    // 递归删除结点
    public void delNode(int id) {
        // 在父结点的视角判断子结点
        if (this.left != null && this.left.id == id) {
            this.left = null;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
        }
        // 没找到，开始向左向右递归
        if (this.left != null) {
            this.left.delNode(id);
        }
        if (this.right != null) {
            this.right.delNode(id);
        }
    }
}
