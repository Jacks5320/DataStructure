package demo1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SparseArray2 {
    public static void main(String[] args) {

        // 1. 定义原始数组
        int[][] orgArr = new int[5][6];

        orgArr[1][2] = 1;
        orgArr[2][3] = 2;
        orgArr[2][1] = 3;
        // 输出原始二维数组
        System.out.println("原始二位数组");
        for (int[] row : orgArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();  // 制表换行
        }

        // 2. 将二位数组转化为稀疏数组
        int sum = 0;
        for (int[] value : orgArr) {
            for (int i : value) {
                if (i != 0) sum++;
            }
        }
        // 创建对应的稀疏数组，为第 0 行赋值，行为有效值数 + 1，列固定为 3
        int[][] sparseArr = new int[sum + 1][3];

        sparseArr[0][0] = orgArr.length;
        sparseArr[0][1] = orgArr[0].length;
        sparseArr[0][2] = sum;

        // 3. 遍历二位数组，将有效值存入稀疏数组
        int count = 1;
        for (int i = 0; i < orgArr.length; i++) {
            for (int j = 0; j < orgArr[i].length; j++) {
                if (orgArr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = orgArr[i][j];
                    count++;
                }
            }
        }

        // 输出稀疏数组
        System.out.println("获取的稀疏数组：");
        for (int[] ints : sparseArr) {
            for (int j : ints) {
                System.out.printf("%d\t", j);
            }
            System.out.println();
        }

        System.out.println();

        // 将稀疏数组保存到磁盘
        FileWriter writer;
        try {
            File file = new File("sparse.data");
            if(!file.exists()){
                System.out.println("创建成功：" + file.createNewFile());
            }
            writer = new FileWriter(file);

            for (int[] ints : sparseArr) {
                for (int j = 0; j < 2; j++) {
                    writer.write(ints[j] + ","); //以逗号分隔
                }
                writer.write(ints[2] + ""); // 第三列后面的数据不用加逗号
                writer.write("\n");
            }
            writer.flush();//刷新
        } catch (IOException e) {
            e.printStackTrace();
        }


        //  从磁盘中读取稀疏数组
        FileReader in;
        BufferedReader buf;
        int[][] sparseArr2 = {{0}};
        try {
            // 读文件
            in = new FileReader("sparse.data");
            buf = new BufferedReader(in);
            List<String> stringList = new ArrayList<>();
            String lineStr;
            while ((lineStr = buf.readLine()) != null){
                stringList.add(lineStr);
            }
            int lineNum = stringList.size();
            sparseArr2 = new int[lineNum + 1][3];
            //  稀疏数组赋值
            int row = 0;
            for (String str : stringList){
                String[] s = str.split(",");//以逗号拆分
                sparseArr2[row][0] = Integer.parseInt(s[0]);
                sparseArr2[row][1] = Integer.parseInt(s[1]);
                sparseArr2[row][2] = Integer.parseInt(s[2]);
                row++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 4. 将稀疏数组恢复为原始二位数组
        int[][] orgArr2 = new int[sparseArr2[0][0]][sparseArr2[0][1]];

        // 遍历稀疏数组，为恢复的二位数组赋值
        for (int i = 1; i < sparseArr2.length; i++) {
            orgArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }

        // 打印恢复后的二维数组
        System.out.println("恢复后的二维数组：");
        for (int[] ints : orgArr2) {
            for (int j : ints) {
                System.out.printf("%d\t", j);
            }
            System.out.println();
        }
    }
}
