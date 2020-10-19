package datastructures.demo6.d_huffmantree.b_huffmanencoding;

/**
 * 测试哈夫曼编码与解码
 */
/*
例如：we we，中 w 出现的次数为2，w 权值则设置为 2
最终生成的哈夫曼树应该为
  temp
 0/ \1
w    temp
    0/  \1
    ^    e
哈夫曼编码表：

w 的编码应该为：0
^ 的编码应该为：10
e 的编码应该为：11

并且根据编码表对字符串进行编码和解码
 */
public class TestDemo {
     public static void main(String[] args) {
        HuffmanEncoding demo = new HuffmanEncoding();
        String s = "编码解码！";
        System.out.println("原字符串：" + s);
        // 哈夫曼编码
        String huffmanCode = demo.getHuffmanCode(s);
        System.out.println("编码值：" + huffmanCode);

        // 打印当前编码表
        System.out.println("当前编码表：" + demo.huffmanCodeTable);

        // 解码
        String decode = demo.decode(huffmanCode);
        System.out.println("解码后的字符串：" + decode);
    }
}
