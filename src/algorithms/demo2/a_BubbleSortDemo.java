package algorithms.demo2;

/**
 * 冒泡排序
 * <p>
 * 思想：
 * 从小到大排序 => 依次将最大值冒泡到数组最后
 * 从大到小排序 => 依次将最小值冒泡待数组最后
 * <p>
 * 优化：
 * 设置一个flag ，如果某一趟没有发生数字交换，则说明排序完成，提前结束循环
 */
public class a_BubbleSortDemo {
    public static void main(String[] args) {
        /* 9 个自定义数据测试排序结果 */
        //int[] arr = {9, 5, 6, 8, 2, 7, 3, 4, 1};
        //System.out.println("排序前：" + Arrays.toString(arr));
        //bubbleSort(arr);
        //System.out.println("冒泡排序：" + Arrays.toString(arr));

        /* 10w 个数组测试花费时间 */
        //冒泡排序 => 10w 数据，18000 毫秒
        int[] arrTime = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arrTime[i] = (int) (Math.random() * 100000);
        }
        long former = System.currentTimeMillis();
        bubbleSort(arrTime);
        long later = System.currentTimeMillis();
        System.out.println("时间：" + (later - former) + " 毫秒");
    }

    /**
     * 冒泡排序算法：这里是从小到大规则排序
     *
     * @param arr 待排序的数组
     */
    public static void bubbleSort(int[] arr) {
        // i 为排序趟数
        for (int i = 0; i < arr.length - 1; i++) {
            // 初始化交换标记，true 为不存在交换，false 为存在交换
            boolean flag = true;
            // 第 i 趟时，已有 i 个数在数组尾部排列好
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;  // 标记本趟排序存在交换
                }
            }
            if (flag) break;  // 本趟排序没有交换，说明排序完成，提前结束循环
        }
    }
}
