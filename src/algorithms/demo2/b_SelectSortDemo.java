package algorithms.demo2;

/**
 * 选择排序
 * <p>
 * 思想：
 * 1 每次遍历找到最小值，将最小值与起始值交换，直至排序结束。
 * 2 起始位置需要不断向后移动，直至移动到倒数第二个位置结束，因为只剩下一个值时，默认有序。
 */
public class b_SelectSortDemo {
    public static void main(String[] args) {
        /* 9 个自定义数据测试排序结果 */
        //int[] arr = {2, 6, 9, 5, 4, 7, 8, 3, 1};
        ////int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //System.out.println("排序前：" + Arrays.toString(arr));
        //selectSort(arr);
        //System.out.println("选择排序：" + Arrays.toString(arr));
        /* 10w 个数组测试花费时间 */
        //选择排序 => 10w 数据，6600 毫秒
        int[] arrTime = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arrTime[i] = (int) (Math.random() * 100000);
        }
        long former = System.currentTimeMillis();
        selectSort(arrTime);
        long later = System.currentTimeMillis();
        System.out.println("时间：" + (later - former) + " 毫秒");
    }

    /**
     * 选择排序算法
     *
     * @param arr 待排序数组
     */
    public static void selectSort(int[] arr) {
        // i 为每次遍历起始位置
        for (int i = 0; i < arr.length - 1; i++) {
            // 初始化 flag ，如果为 true，表示存在交换，需要交换起始位置与最小值位置的值
            boolean flag = false;
            // 假设起始位置 i 为最小值的索引
            int minIndex = i;

            // 依次遍历起始位置到最大索引位置的值，找到本趟排序的最小值
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                    flag = true;
                }
            }
            if (flag) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

}
