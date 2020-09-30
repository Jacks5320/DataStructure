package datastructures.demo1;

/**
 * 稀疏数组：
 * 当一个数组中大部分元素是 0，或者为 同一个值 的数组时，可以使用稀疏数组来保存该数组。
 * <p>
 * 稀疏数组的特点：
 * - 第一行保存原始数组的大小及有效元素个数（少数值）
 * - 后面行保存原始数组中有效元素的索引以及具体值。
 * 第二个程序 SparseArray2 实现了读写文件 。
 */
public class SparseArray {
    public static void main(String[] args) {
        // 定义原始数组
        int[][] orgArr = new int[5][6];
        orgArr[1][2] = 1;
        orgArr[2][3] = 2;
        orgArr[2][1] = 3;
        //  输出原始二维数组
        System.out.println("原始二位数组");
        for (int[] row : orgArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();  // 制表换行
        }
        // 将二位数组转化为稀疏数组
        // 1. 遍历原始二位数组，获取非 0 值个数
        int sum = 0;
        for (int i = 0; i < orgArr.length; i++) {
            for (int j = 0; j < orgArr[i].length; j++) {
                if (orgArr[i][j] != 0) sum++;
            }
        }
        System.out.println("原始数组有效值个数：" + sum);

        // 2. 创建对应的稀疏数组
        // sum + 1 就为稀疏数组的行数
        // 列数固定为 3
        // 首行存储原始数组的行数、列数、有效值个数
        // 其他行存储有效值在原始数组中的索引位置及具体值
        int[][] sparseArr = new int[sum + 1][3];
        // 3. 给稀疏数组第 0 行 赋值
        sparseArr[0][0] = orgArr.length;    //  原始二维数组行数
        sparseArr[0][1] = orgArr[0].length;     // 原始二位数组列数
        sparseArr[0][2] = sum;
        // 4. 遍历二位数组，将有效值存入稀疏数组
        int count = 1; // 计数器，递增稀疏数组的行数
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

        // 5. 输出稀疏数组
        System.out.println("获取的稀疏数组：");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }

        // 6. 将稀疏数组恢复为原始二位数组
        // 6.1 创建恢复的二维数组
        // 目标二维数组的大小为稀疏数组的[0][0]和[0][1]，分别表示行数与列数。
        System.out.println(sparseArr[0][0]);
        System.out.println(sparseArr[0][1]);
        int[][] orgArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 6.2 遍历稀疏数组，为恢复的二位数组赋值
        // 稀疏数组的 [i][0] 为原始数组的行数,[i][1]为原始数组的列数,[i][2]为原始数组中的有效值。
        for (int i = 1; i < sparseArr.length; i++) {
            orgArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        // 7. 打印恢复后的二维数组
        System.out.println("恢复后的二维数组：");
        for (int i = 0; i < sparseArr[0][0]; i++) {
            for (int j = 0; j < sparseArr[0][1]; j++) {
                System.out.printf("%d\t", orgArr2[i][j]);
            }
            System.out.println();
        }
    }
}
