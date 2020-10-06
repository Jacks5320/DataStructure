package algorithms.demo2;

/**
 * 快速排序算法：
 * 是冒泡排序的一种改进
 * <p>
 * 步骤：
 * - 1、选取一个基准值 pivot，可以选择起始索引处的值、中间位置的值、最大索引位置的值或随机位置的值，图示中取的是最大索引处的值作为 pivot。
 * - 2、定义两个辅助指针，一个从起始索引开始依次向后遍历（left），另一个从最大索引位置依次向前遍历（right）。
 * - 3、先移动左指针 left，找到比 pivot 大的数后停止，接着移动右指针 right ，找到比 pivot 小的数后停下。
 * - 4、两个指针都停下时，交换 `arr[left]` 与 `arr[right]` 的值
 * - 5、当 `left == right` 时，两个指针相遇，说明本轮排序结束，将基准值与指针相遇位置的值做交换。
 * - 6、分别对 `pivot` 两边的序列再次进行如上排序，递归。
 * - 7、程序结束后，数组就排好序了。
 */
public class e_QuickSortDemo {
    public static void main(String[] args) {
        /* 9 个自定义数据测试排序结果 */
        //int[] arr = {3, 5, 8, 1, 2, 9, 4, 7, 6};
        ////int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //System.out.println("排序前：" + Arrays.toString(arr));
        //quickSort(arr, 0, arr.length - 1);
        //System.out.println("快速排序：" + Arrays.toString(arr));

        int[] arrTime = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            arrTime[i] = (int) (Math.random() * 1000000);
        }
        long former = System.currentTimeMillis();
        quickSort(arrTime, 0, arrTime.length - 1);  // 快速排序 => 10w 数据，20 ~ 50毫秒；100w 数据，140 毫秒 ~ 160 毫秒
        long later = System.currentTimeMillis();
        System.out.println("时间：" + (later - former) + " 毫秒");
    }

    /**
     * 快速排序：对冒泡排序的一种改进
     *
     * @param arr        待排序数组
     * @param startIndex 待排序序列的起点
     * @param endIndex   待排序序列的终点
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) return;  // 不满足排序的序列直接返回

        int left = startIndex;  // 初始化，左指针指向起始位置
        int right = endIndex;  // 初始化，右指针指向最大索引位置
        int pivot = arr[endIndex];  // 初始化，基准值选取最大索引位置的值

        // 左右指针相遇时结束
        while (left != right) {
            // 在不越界的前提下，移动左指针，找到大于 pivot 的数
            while (left < right && arr[left] <= pivot) {
                left++;  // 没找到，将左指针后移，继续找
            }
            // 在不越界的前提下，移动右指针，找到小于 pivot 的数
            while (left < right && arr[right] >= pivot) {
                right--;  // 没找到，将右指针前移，继续找
            }
            // 两个 while 循环都停止时，交换 left 与 right 位置的值
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        // 当左右指针相遇时，一轮排序结束，需要先交换 pivot 与 相遇位置的值，保证 pivot 左边都比自己小，右边都比自己大
        arr[endIndex] = arr[left];  // pivot 的位置为原来的 endIndex 处
        arr[left] = pivot;
        // 对 pivot 左右两边的数据再次进行上面的处理，递归
        quickSort(arr, startIndex, left - 1);
        quickSort(arr, right + 1, endIndex);
    }
}
