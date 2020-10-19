package datastructures.demo6.d_huffmantree.a_createhuffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树节点
 * <p>
 * 让 Node 实现 Comparable 接口，方便排序
 */
class HuffmanTreeNode implements Comparable<HuffmanTreeNode> {
    public int weight;  // 结点权值
    public HuffmanTreeNode left;  // 左子树
    public HuffmanTreeNode right;  // 右子树

    public HuffmanTreeNode(int weight) {
        this.weight = weight;
    }

    /**
     * 创建哈夫曼树
     *
     * @param arr 数组
     * @return 哈夫曼树的根节点
     */
    public HuffmanTreeNode createHuffmanTree(int[] arr) {
        // 1. 创建存储所有结点的集合 nodes
        List<HuffmanTreeNode> nodes = new ArrayList<>();
        // 2. 将数组中的元素封装成结点后存入结点集合 nodes 中
        for (int val : arr) {
            nodes.add(new HuffmanTreeNode(val));
        }
        while (nodes.size() > 1) {
            // 3. 将集合按照权值，从小到大排序
            Collections.sort(nodes);
            // 4. 取出权值最小的两个值，作为左右孩子结点生成新的结点
            HuffmanTreeNode leftNode = nodes.get(0);
            HuffmanTreeNode rightNode = nodes.get(1);
            // 5. 构建新的二叉树
            HuffmanTreeNode parent = new HuffmanTreeNode(leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            // 6. 在 ArrayList 中删除这两个结点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 7. 将 parent 加入 ArrayList 中
            nodes.add(parent);
        }
        // 返回 root 结点
        return nodes.get(0);
    }

    //  先序遍历
    public void preOrder() {
        System.out.printf("%d\t", this.weight);  // 输出当前结点
        if (this.left != null) this.left.preOrder();  // 左递归
        if (this.right != null) this.right.preOrder();  // 右递归
    }

    @Override
    public String toString() {
        return "HuffmanTreeNode{" +
                "value=" + weight +
                '}';
    }

    /**
     * 对象集合排序排序比较，使用 Collection.sort() 进行排序
     * <p>
     * 如果 return 写的 this.xxx - o.xxx，按照升序排列
     * <p>
     * 如果 return 写的 o.xxx - this.xxx，按照降序排列
     * <p>
     * 口诀，我减她，升序，她减我，降序
     *
     * @param o 待比较对象
     * @return 负数、0、正数
     */
    @Override
    public int compareTo(HuffmanTreeNode o) {
        // 从小到大排序
        return this.weight - o.weight;
    }
}