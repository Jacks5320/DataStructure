package datastructures.demo6.a_binarytree;

/**
 * 二叉树功能测试
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 创建二叉树
        StudentBinaryTree binaryTree = new StudentBinaryTree();
        // 添加结点
        add(binaryTree);
        // 遍历二叉树
        traverse(binaryTree);
        // 查找学号为 5 的信息
        search(binaryTree, 5);  // 先序4次，中序3次，后序2次，次数是比较次数
        // 删除学号为 5 的结点
        //delNode(binaryTree, 5);
    }

    /*二叉树结构
               1
             /   \
            2     3
          /   \
         4     5
         前序遍历：1,2,4,5,3
         中序遍历：4,2,5,1,3
         后序遍历：4,5,2,3,1
    */
    // 添加结点
    public static void add(StudentBinaryTree binaryTree) {
        // 创建结点
        StudentNode root = new StudentNode(1, "刘备");
        StudentNode node1 = new StudentNode(2, "关羽");
        StudentNode node2 = new StudentNode(3, "张飞");
        StudentNode node3 = new StudentNode(4, "小乔");
        StudentNode node4 = new StudentNode(5, "貂蝉");
        binaryTree.root = root;
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
    }

    /**
     * 先序、中序、后序遍历二叉树
     *
     * @param binaryTree 待遍历二叉树
     */
    public static void traverse(StudentBinaryTree binaryTree) {
        // 先序遍历
        binaryTree.preOrder();  // 1,2,4,5,3
        // 中序遍历
        //binaryTree.inOrder();  // 4,2,5,1,3
        // 后序遍历
        //binaryTree.postOrder();  // 4,5,2,3,1
    }

    /**
     * 用先序、中序、后序遍历查找二叉树
     *
     * @param binaryTree 待遍历的二叉树
     * @param id         待查找 id
     */
    public static void search(StudentBinaryTree binaryTree, int id) {
        // 先序
        StudentNode node = binaryTree.root.preOrderSearch(id);
        if (node != null) {
            System.out.printf("学号=%d<-->姓名=%s\n", node.id, node.name);
        } else {
            System.out.println("先序未找到~");
        }
        // 中序
        StudentNode node2 = binaryTree.root.inOrderSearch(id);
        if (node2 != null) {
            System.out.printf("学号=%d<-->姓名=%s\n", node2.id, node2.name);
        } else {
            System.out.println("中序未找到~");
        }
        // 后序
        StudentNode node3 = binaryTree.root.postOrderSearch(id);
        if (node3 != null) {
            System.out.printf("学号=%d<-->姓名=%s\n", node3.id, node3.name);
        } else {
            System.out.println("后序未找到~");
        }
    }

    /**
     * 删除指定结点
     *
     * @param binaryTree 待遍历的二叉树
     * @param id         待删除结点的 id
     */
    public static void delNode(StudentBinaryTree binaryTree, int id) {
        binaryTree.delNode(id);
        System.out.println("删除结点后剩下的结点：");
        traverse(binaryTree);
    }
}
