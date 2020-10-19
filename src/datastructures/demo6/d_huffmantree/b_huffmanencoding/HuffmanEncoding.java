package datastructures.demo6.d_huffmantree.b_huffmanencoding;

import java.util.*;

/**
 * 哈夫曼编码
 */
public class HuffmanEncoding {

    public Map<Character, String> huffmanCodeTable = new HashMap<>();  // 哈夫曼编码表
    public StringBuilder huffmanCode = new StringBuilder();  // 拼接每个叶子结点的编码

    /**
     * 获取哈夫曼编码结果
     *
     * @param s 待编码的字符串
     * @return 编码字符串
     */
    public String getHuffmanCode(String s) {
        // 1. 封装结点，以字符出现的次数作为权值，字符串作为数据
        List<HuffmanEncodingNode> nodes = getNodes(s.toCharArray());
        // 2. 将结点集合生成哈夫曼树并获取根结点
        HuffmanEncodingNode root = createHuffmanTree(nodes);
        // 3. 遍历哈夫曼树，生成哈夫曼编码表
        createHuffmanCodeTable(root, "", huffmanCode);
        // 4. 根据哈夫曼编码表，对原字符串进行编码，并返回结果。
        return huffmanCoding(s.toCharArray());
    }

    /**
     * 根据哈夫曼编码进行解码
     *
     * @param code 哈夫曼编码
     * @return 解码后的字符串
     */
    public String decode(String code) {
        // 生成一个解码表，将哈夫曼编码表 huffmanCodeTable 的 key 与 value 置换
        Map<String, Character> huffmanDecodeTable = new HashMap<>();
        for (Map.Entry<Character, String> entry : huffmanCodeTable.entrySet()) {
            huffmanDecodeTable.put(entry.getValue(), entry.getKey());
        }
        // 根据哈夫曼解码表，对哈夫曼编码进行解码
        int l = 0;
        int r = 0;
        StringBuilder res = new StringBuilder();
        while (r < code.length()) {
            // substring，左闭右开，取 (l, r + 1)
            Character c = huffmanDecodeTable.get(code.substring(l, r + 1));
            if (c == null) {
                r += 1;
            } else {
                res.append(c);
                r += 1;
                l = r;
            }
        }
        return res.toString();
    }

    /**
     * 统计字符串中出现的字符及该字符出现的次数
     * <p>
     * 将每个字符及其出现次数封装为树结点，data 存储字符，weight 存储出现次数。
     *
     * @param bytes 字符串转化的字节数组
     * @return 封装为结点后的集合
     */
    public List<HuffmanEncodingNode> getNodes(char[] bytes) {
        // 1. 创建 ArrayList 存储哈夫曼树的结点
        List<HuffmanEncodingNode> nodes = new ArrayList<>();
        // 2. 创建存储字符及其出现的 Map 集合
        Map<Character, Integer> counts = new HashMap<>();
        // 3. 开始统计字符出现次数
        for (Character b : bytes) {
            counts.merge(b, 1, Integer::sum);
        }
        // 4. 将 Map 集合中的数据封装成结点，存入 List 中
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            nodes.add(new HuffmanEncodingNode(entry.getKey(), entry.getValue()));
        }
        // 5. 返回封装结果
        return nodes;
    }

    /**
     * 生成哈夫曼树
     *
     * @param nodes 待生成哈夫曼树的结点集合
     * @return 哈夫曼树的根节点
     */
    public HuffmanEncodingNode createHuffmanTree(List<HuffmanEncodingNode> nodes) {
        while (nodes.size() > 1) {
            // 1. 先根据权值升序排序集合
            Collections.sort(nodes);
            // 2. 取出权值最小的两个结点，作为左右孩子结点，组成新的二叉树结构
            HuffmanEncodingNode left = nodes.get(0);
            HuffmanEncodingNode right = nodes.get(1);
            // 3. 组成新的结点，新节点不存数据。
            HuffmanEncodingNode temp = new HuffmanEncodingNode(null, left.weight + right.weight);
            temp.left = left;
            temp.right = right;
            // 4. 将新结点添加到结点数组中，并删除已用的两个结点。
            nodes.add(temp);
            nodes.remove(left);
            nodes.remove(right);
        }
        // 5. 循环结束后，就生成了哈夫曼树，此时结点集合 nodes 中只剩下一个结点是根节点，返回即可。
        return nodes.get(0);
    }

    /**
     * 递归生成哈夫曼编码表
     *
     * @param node        当前待编码结点
     * @param code        上个结点到当前结点的编码值，左孩子编码 0，右孩子编码 1
     * @param huffmanCode 从根结点到当前结点的编码值
     */
    private void createHuffmanCodeTable(HuffmanEncodingNode node, String code, StringBuilder huffmanCode) {
        // 先存储上个结点到当前结点的编码值
        StringBuilder temp = new StringBuilder(huffmanCode);
        temp.append(code);
        // 如果当前结点不为为 null 时，处理当前结点
        if (node != null) {
            // 非叶子结点，data == null，继续向后递归
            if (node.data == null) {
                // 左递归时，编码 0，并传入已编码好的路径
                createHuffmanCodeTable(node.left, "0", temp);
                // 右递归时，编码 1，并传入已编码好的路径
                createHuffmanCodeTable(node.right, "1", temp);
            } else {// 如果遇到叶子结点，就将当前结点的 data 与编码存入哈夫曼编码表 huffmanCodeTable
                huffmanCodeTable.put(node.data, temp.toString());
            }
        }
    }

    /**
     * 根据哈夫曼编码表对原字符串进行编码
     *
     * @param s 待编码字符串的字符数组
     * @return 哈夫曼编码
     */
    private String huffmanCoding(char[] s) {
        StringBuilder code = new StringBuilder();
        for (Character b : s) {
            code.append(huffmanCodeTable.get(b));
        }
        return code.toString();
    }
}
