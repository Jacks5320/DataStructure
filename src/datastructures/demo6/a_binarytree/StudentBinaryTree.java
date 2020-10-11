package datastructures.demo6.a_binarytree;

/**
 * 学生二叉树结构
 */
public class StudentBinaryTree {
    StudentNode root;  // 根结点

    // 先序遍历：先输出父结点，再遍历左子树和右子树
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空~");
        }
    }

    // 后序遍历
    public void inOrder() {
        if (root != null) {
            root.inOrder();
        } else {
            System.out.println("二叉树为空~");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空~");
        }
    }

    // 先序遍历查找
    public StudentNode preOrderSearch(int id) {
        if (root != null) {
            return root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    // 中序遍历查找
    public StudentNode inOrderSearch(int id) {
        if (root != null) {
            return root.inOrderSearch(id);
        } else {
            return null;
        }
    }

    // 后序遍历查找
    public StudentNode postOrderSearch(int id) {
        if (root != null) {
            return root.postOrderSearch(id);
        } else {
            return null;
        }
    }

    // 删除指定结点，当不是叶子结点时，直接删除子树
    public void delNode(int id) {
        if (root != null) {
            // 因为递归是站在父结点的角度判断左右子结点，所以需要在递归前判断根节点
            // 根节点未待删除结点，直接置空
            if (root.id == id) {
                root = null;
            } else {
                root.delNode(id);
            }
        } else {
            System.out.println("空树，无素可删");
        }
    }
}
