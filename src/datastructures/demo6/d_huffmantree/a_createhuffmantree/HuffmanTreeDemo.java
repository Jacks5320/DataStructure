package datastructures.demo6.d_huffmantree.a_createhuffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 这里演示生成哈夫曼树的生成
 * <p>
 * 直接使用数组中的值作为权值
 */
public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int[] arr = {15, 4, 13, 7, 5, 2};
        //HuffmanTreeNode root = createHuffmanTree(arr);
        //root.preOrder();
        // 1. 创建存储树结点的集合 nodes
        List<HuffmanTreeNode> nodes = new ArrayList<>();
        // 2. 将数组中的元素封装为树结点，并存入 nodes 集合
        for (int num : arr) {
            nodes.add(new HuffmanTreeNode(num));
        }
        // 3. 将 nodes 中的结点生成哈夫曼树
        while (nodes.size() > 1) {
            // 3.1 根据权值，从小到达进行排序
            Collections.sort(nodes);
            // 3.2 取出权值最小的结点作为左右孩子进行组装
            HuffmanTreeNode left = nodes.get(0);
            HuffmanTreeNode right = nodes.get(1);
            HuffmanTreeNode temp = new HuffmanTreeNode(left.weight + right.weight);
            temp.left = left;
            temp.right = right;
            // 3.3 将新组装的结点加入原集合中，删除已用的两个最小的结点
            nodes.add(temp);
            nodes.remove(left);
            nodes.remove(right);
        }
        // 4. 当循环结束后，就生成了哈夫曼树，此时 nodes 中只剩下一个结点，即根结点
        HuffmanTreeNode root = nodes.get(0);
        // 5. 先序遍历验证结果
        root.preOrder();
    }
}