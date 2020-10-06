package algorithms.demo2;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 思想：
 * 1 从索引 1 开始，依次向后遍历获取待插入值 insertValue
 * 2 从待插入值的位置开始，依次向前遍历，寻找待插入位置 insertIndex
 * 2.1 当 insertValue < array[insertIndex - 1] 时，insertIndex 向前移动，继续比较。
 * 2.2 当 insertValue >= array[insertIndex - 1] 时，此时将 insertValue 插入到 array[insertIndex] 即可
 */
public class c_InsertSortDemo {
    public static void main(String[] args) {
        /* 9 个自定义数据测试排序结果 */
        //int[] arr = {2, 6, 9, 5, 4, 7, 8, 3, 1};
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("排序前：" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("插入排序：" + Arrays.toString(arr));

        /* 10w 个数组测试花费时间 */
        //插入排序 => 10w 数据，1100 毫秒
        //int[] arrTime = new int[100000];
        //for (int i = 0; i < 100000; i++) {
        //    arrTime[i] = (int) (Math.random() * 100000);
        //}
        //long former = System.currentTimeMillis();
        //insertSort(arrTime);
        //long later = System.currentTimeMillis();
        //System.out.println("时间：" + (later - former) + " 毫秒");
    }

    /**
     * 插入排序：也称直接插入排序
     *
     * @param arr 待排序数组
     */
    public static void insertSort(int[] arr) {
        // 依次向后遍历待插入值
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];  // 初始化待插入值
            int insertIndex = i;  // 初始化待插入位置
            // 向前遍历，寻找插入位置
            while (insertIndex > 0 && insertValue < arr[insertIndex - 1]) {  // 未找到待插入位置
                arr[insertIndex] = arr[insertIndex - 1];  // 前一个值后移
                insertIndex -= 1;  // 待插入位置前移
            }
            // 将待插入值插入到待插入位置
            arr[insertIndex] = insertValue;
        }
    }

}
