package algorithms.demo2;

/**
 * 希尔排序：
 * 也称递减增量排序算法，增强了直接插入排序，先分组，再进行直接插入排序
 * <p>
 * 思想
 */
public class d_ShellSortDemo {
    public static void main(String[] args) {
        /* 9 个自定义数据测试排序结果 */
        //int[] arr = {2, 6, 9, 5, 4, 7, 8, 3, 1};
        ////int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //System.out.println("排序前：" + Arrays.toString(arr));
        //shellSort(arr);
        //System.out.println("希尔排序：" + Arrays.toString(arr));

        /* 10w 个数组测试花费时间 */
        //选择排序 => 10w 数据，6600 毫秒
        int[] arrTime = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arrTime[i] = (int) (Math.random() * 1000000);
        }
        long former = System.currentTimeMillis();
        shellSort(arrTime);
        long later = System.currentTimeMillis();
        System.out.println("时间：" + (later - former) + " 毫秒");
    }

    /**
     * 希尔排序算法
     *
     * @param arr 待排序数组
     */
    public static void shellSort(int[] arr) {
        // gap 为间隔分组，gap 每一轮递减 2 倍
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第 gap 个元素开始向后遍历获取待插入值
            for (int i = gap; i < arr.length; i++) {
                int insertValue = arr[i];  // 初始化待插入值
                int insertIndex = i;  // 初始化待插入位置
                // 在不越界的前提下，寻找待插入位置
                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
                    arr[insertIndex] = arr[insertIndex - gap];  // 将前 gap 个位置的值后移 gap
                    insertIndex -= gap;  // 将 insertIndex 前移 gap 个位置
                }
                // while 结束后，就找到了待插入位置 insertIndex
                arr[insertIndex] = insertValue;  // 将待插入值插入待插入位置
            }
        }
    }
}
