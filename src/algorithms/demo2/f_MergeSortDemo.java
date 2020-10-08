package algorithms.demo2;

/**
 * 归并排序
 * <p>
 * 思路
 * 1. 将序列中待排序数字分为若干组，每个数字分为一组
 * 2. 将若干个组两两组合，组合后的序列是有序的
 * 3. 重复第二步，直至剩下最后一组，排序完成
 */
public class f_MergeSortDemo {
    public static void main(String[] args) {
        //int[] arr = {3, 5, 8, 1, 2, 9, 4, 7, 6};
        ////int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        //int[] temp = new int[arr.length];
        //System.out.println("排序前：" + Arrays.toString(arr));
        //mergeSort(arr, 0, arr.length - 1, temp);
        //System.out.println("归并排序：" + Arrays.toString(arr));

        /* 1亿数据 400 毫秒 */
        int[] arrTime = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            arrTime[i] = (int) (Math.random() * 100000000);
        }
        long former = System.currentTimeMillis();
        merge(arrTime, 0, arrTime.length / 2, arrTime.length - 1, new int[arrTime.length]);
        long later = System.currentTimeMillis();
        System.out.println("时间：" + (later - former) + " 毫秒");
    }

    /**
     * 归并排序算法
     *
     * @param arr        待排序数组，先拆分，后组合
     * @param startIndex 待拆分数组的起始索引
     * @param endIndex   待拆分数组的最后索引
     * @param temp       临时组合数组
     */
    public static void mergeSort(int[] arr, int startIndex, int endIndex, int[] temp) {
        // 不满足拆分条件，直接返回
        if (startIndex >= endIndex) return;
        int mid = (startIndex + endIndex) / 2;  // 对半拆分
        mergeSort(arr, startIndex, mid, temp);  // 左递归继续拆分
        mergeSort(arr, mid + 1, endIndex, temp);  // 右递归继续拆分
        merge(arr, startIndex, mid, endIndex, temp);  // 左右都递归拆分后，进行组合
    }

    /**
     * 合并方法：将两个数组中的元素排序后放入同一个数组中
     *
     * @param arr        待排序数组
     * @param startIndex 左边数组的起始索引
     * @param mid        分开左右数组的中间索引
     * @param endIndex   右边数组的最后索引
     * @param temp       临时组合数组
     */
    public static void merge(int[] arr, int startIndex, int mid, int endIndex, int[] temp) {
        int left = startIndex;  // 初始化左数组的指针，指向左数组的起点
        int right = mid + 1;  // 初始化右数组的指针，指向右数组的起点
        int t = 0;  // 指向临时存储数组，用于存放元素
        // 左右两边的数组有任意一边的数组遍历完就结束
        while (left <= mid && right <= endIndex) {
            if (arr[left] <= arr[right]) {  // 左数组的数小，存入临时数组
                temp[t] = arr[left];
                t++;
                left++;
            } else {
                temp[t] = arr[right];
                t++;
                right++;
            }
        }

        // 如果左数组有剩余，依次放入 temp
        while (left <= mid) {
            temp[t] = arr[left];
            t++;
            left++;
        }
        // 如果右数组有剩余，依次放入 temp
        while (right <= endIndex) {
            temp[t] = arr[right];
            t++;
            right++;
        }

        // 上面数组合并完成后，将 temp 中排好的数字依次存入 arr 对应的位置 ⇒ 从 startIndex 到 endIndex
        t = 0;  // 初始化 temp 的指针
        while (startIndex <= endIndex) {
            arr[startIndex] = temp[t];
            startIndex++;
            t++;
        }

        /*
        int i = left;  // 初始化 i，左边有序序列初始索引
        int j = mid + 1;  // 初始化 j，右边有序序列初始索引
        int t = 0;  // 指向 temp 的当前索引

        // （一）
        // 先把左右两边的数据按规则填充到 temp 数组
        // 直到有一边处理完毕即可
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {  // 当左序列的元素 小于 右序列元素时，填充左序列的元素到 temp
                temp[t] = arr[i];
                t += 1;  // temp 索引右移
                i += 1;  // 左序列右移
            } else {  // 反之填充右序列元素到 temp
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        // （二）
        // 将剩余数组中的元素依次填充到 temp
        while (i <= mid) {  // 左序列还有剩余
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {  // 右序列还有剩余
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        // （三）
        // 将 temp 数组的元素填充到 arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
         */
    }
}
