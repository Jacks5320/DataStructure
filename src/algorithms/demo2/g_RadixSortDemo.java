package algorithms.demo2;

import java.util.Arrays;

/**
 * 基数排序
 * 桶排序的升级
 */
public class g_RadixSortDemo {
    public static void main(String[] args) {
        int[] arr = {1, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        System.out.println("排序前：" + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("基数排序：" + Arrays.toString(arr));

        /* 100w ==> 95 毫秒 */
        /* 1000w ==> 760 毫秒 */
        /* 1e ==> 内存溢出：100000000 * 11(数组数) * 4(一个int) / 1024 / 1024 / 1024 = 4 G   */
        /* java.lang.OutOfMemoryError: Java heap space */
        int[] arrTime = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            arrTime[i] = (int) (Math.random() * 10000000);
        }
        long former = System.currentTimeMillis();
        radixSort(arrTime);
        long later = System.currentTimeMillis();
        System.out.println("时间：" + (later - former) + " 毫秒");
    }

    public static void radixSort(int[] arr) {

        // 二维数组，存放 10 个桶和各桶中的元素
        int[][] bucket = new int[10][arr.length];
        // 一维数组，记录每个桶中元素的个数
        int[] elementCounts = new int[10];
        // 获取待排序数组中最大数
        int max = 0;
        for (int num : arr) {
            if (max < num) max = num;
        }
        // 获取最大数的位数 ==> 转成字符串求长度
        int digits = ("" + max).length();

        // 排序，K 为当前比较位数，个、十、百、千...
        for (int i = 0, k = 1; i < digits; i++, k *= 10) {
            // 将 arr 中的数据按规则放入桶中
            for (int num : arr) {
                int m = num / k % 10;  // 第 m 个桶
                int n = elementCounts[m];  // 第 m 个桶中的第 n 个位置
                bucket[m][n] = num;
                elementCounts[m]++;
            }

            // 将桶中的数据依次放回 arr 中，进行下一轮排序
            int index = 0;
            for (int j = 0; j < 10; j++) {  // 一共 10 个桶
                if (elementCounts[j] == 0) continue;  // 如果第 j 个桶中的元素为 0，换下一个桶
                for (int l = 0; l < elementCounts[j]; l++) {
                    arr[index] = bucket[j][l];
                    index++;
                }
                elementCounts[j] = 0;  // 元素个数清零
            }
        }
    }
}
