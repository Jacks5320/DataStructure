package datastructures.demo6.c_threadedbinarytree;

/**
 * 线索化二叉树的结点
 */
public class StudentThreadedNode {
    public int id;
    public String name;
    public StudentThreadedNode left;  // 左结点
    public StudentThreadedNode right;  // 右结点


    public int leftType;  // leftType=0 表示指向左子树，leftType=1 表示指向前驱结点
    public int rightType;  // rightType=0 表示指向右子树，rightType=1 表示指向后继结点


    public StudentThreadedNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
