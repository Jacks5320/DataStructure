package datastructures.demo6.d_huffmantree.b_huffmanencoding;

/**
 * 哈夫曼编码结点
 */
public class HuffmanEncodingNode implements Comparable<HuffmanEncodingNode> {
    public Character data;  // 存放具体的字符
    public int weight;  // 权值
    public HuffmanEncodingNode left;
    public HuffmanEncodingNode right;

    public HuffmanEncodingNode(Character data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HuffmanEncodingNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(HuffmanEncodingNode o) {
        return this.weight - o.weight;
        //return o.weight - this.weight;
    }
}
