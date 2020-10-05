package algorithms.demo2;

import java.util.Date;

public class SortDemo {
    public static void main(String[] args) {
        /* 9 个自定义数据测试排序结果 */
        //int[] arr = {2, 6, 9, 5, 4, 7, 8, 3, 1};
        //System.out.println("排序前：" + Arrays.toString(arr));
        ////System.out.println("冒泡排序" + Arrays.toString(bubbleSort(arr)));
        ////System.out.println("选择排序：" + Arrays.toString(selectSort(arr)));
        ////System.out.println("插入排序：" + Arrays.toString(insertSort(arr)));
        ////System.out.println("希尔排序：" + Arrays.toString(shellSort(arr)));
        //System.out.println("快速排序：" + Arrays.toString(quickSort(arr, 0, arr.length - 1)));


        /* 随机 10 个数据排序 */
        //int[] arrTime = new int[10];
        //for (int i = 0; i < 10; i++) {
        //    arrTime[i] = (int) (Math.random() * 100000);
        //}
        //System.out.println("排序前：" + Arrays.toString(arrTime));
        //System.out.println("排序后：" + Arrays.toString(quickSort(arrTime, 0, arrTime.length - 1)));

        /* 10 w 个数据，测试排序效率 */
        int[] arrTime = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arrTime[i] = (int) (Math.random() * 100000);
        }
        long former = dateTime();
        //bubbleSort(arrTime);  // 冒泡排序 => 21500 毫秒
        //selectSort(arrTime);    // 选择排序 => 7500 毫秒
        //insertSort(arrTime);  // 插入排序 => 1200 毫秒
        //shellSort(arrTime);  // 希尔排序 => 10w 数据，30 毫秒；100w 数据，250 毫秒 ~ 260 毫秒
        quickSort(arrTime, 0, arrTime.length - 1);  // 快速排序 => 10w 数据，30毫秒；100w 数据，180 毫秒 ~ 200 毫秒
        long later = dateTime();
        System.out.println("时间：" + (later - former) + " 毫秒");
    }

    /* 测试时间 */
    public static long dateTime() {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:dd:ss.SSSS");
        //Date date = new Date();
        //System.out.println(sdf.format(date));
        return new Date().getTime();
    }

    /**
     * 冒泡排序：时间复杂度为 O(n^2)
     *
     * @param arr 待排序的数组
     */
    public static int[] bubbleSort(int[] arr) {
        int temp;  // 交换两次数的中间值
        boolean flag = false;  // 优化第一步：设置一个 flag，如果某一趟排序中没有数互相交换，说明排序完成，需要结束循环
        // 排序趟数：arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            // 第 i 趟比较次数 arr.length - 1 - i
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，就交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;  // 优化第二步：如果某一趟有数互相交换，将其设置为 true
                }
            }
            if (!flag) {
                break;  // 优化第三步，如果没有进入交换判断，则交换完毕，直接退出即可
            } else {
                flag = false;  // 初始化标志
            }
        }
        return arr;
    }

    /**
     * 选择排序：时间复杂度为 O(n^2)
     *
     * @param arr 待排序数组
     */
    public static int[] selectSort(int[] arr) {
        int minIndex = 0;  // 最小值指针
        int temp = 0;  // 交换中间值
        boolean flag = false;  // 标志是否有交换

        for (int i = 0; i < arr.length - 1; i++) {  // i 为每轮排序的起始指针
            minIndex = i;
            for (int j = i; j < arr.length; j++) {  // j 为每次遍历比较的指针
                if (arr[minIndex] > arr[j]) {  // 如果当前最小值比遍历到的最小值大就交换
                    minIndex = j;
                    flag = true;
                }
            }
            if (flag) {  // 如果有交换，就把 minIndex 与 i 所在的索引交换
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                flag = false;  // 重置标志
            }
        }
        return arr;
    }

    /**
     * 插入排序：也称直接插入排序
     *
     * @param arr 待排序数组
     */
    public static int[] insertSort(int[] arr) {
        int insertValue = 0;  // 待插入的值
        int insertIndex = 0;  // 待插入位置
        for (int i = 1; i < arr.length; i++) {  // i 为待插入值的位置
            // 初始化待插入值与待插入位置
            insertValue = arr[i];
            insertIndex = i - 1;
            // insertIndex >= 0 先保证不越界
            // insertValue < arr[insertIndex]，待插入值比待插入位置的值小时，需要后移 待插入位置的值 和 前移待插入位置指针
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];  // 待插入位置的值后移 1 个位置
                insertIndex--;  // 待插入位置指针前移 1 个位置
            }
            arr[insertIndex + 1] = insertValue;
        }
        return arr;
    }

    /**
     * 希尔排序：也称递减增量排序算法，增强了直接插入排序，先分组，再进行直接插入排序
     *
     * @param arr 待排序数组
     */
    public static int[] shellSort(int[] arr) {
        int insertValue;  // 待插入值
        int insertIndex;  // 待插入索引
        // 分组，每组有 gap 个元素，gap 每次缩减 1 / 2
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第 gap 个元素开始，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                // 初始化待插入值与待插入位置
                insertValue = arr[i];
                insertIndex = i - gap;
                // insertIndex >= 0 保证不越界
                // insertValue < arr[insertIndex]，待插入值比待插入位置的值小时，需要后移 待插入位置的值 和 前移待插入位置指针
                while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                    arr[insertIndex + gap] = arr[insertIndex];  // 待插入位置的值后移 gap 个位置
                    insertIndex -= gap;  // 待插入位置指针前移 gap 个位置
                }
                // while 循环完后，insertIndex + gap 就是待插入位置
                arr[insertIndex + gap] = insertValue;
            }
        }
        return arr;
    }

    /**
     * 快速排序：对冒泡排序的一种改进
     *
     * @param arr   待排序数组
     * @param left  左指针
     * @param right 右指针
     * @return 排序完成的数组
     */
    public static int[] quickSort(int[] arr, int left, int right) {
        int l = left;  // 左指针
        int r = right;  // 右指针
        int pivot = arr[(left + right) / 2];  // 基准值，总是以 中间值 作为基准值
        int temp;
        while (l < r) {  // 当左指针小于右指针时，继续执行。
            while (arr[l] < pivot) {  // 从左往右找到比 pivot 大的值
                l++;
            }
            while (arr[r] > pivot) {  // 从右往左找到比 pivot 小的值
                r--;
            }
            if (l >= r) {  // 如果 l >= r ，说明左边的值总是小于 pivot ，右边的值总是大于 pivot
                break;
            } else {  // 否则交换两个值
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
            // 交换完后，发现 arr[l] == pivot ，r 前移
            if (arr[l] == pivot) {
                r--;
            }
            // 交换完后，发现 arr[r] == pivot ，l 后移
            if (arr[r] == pivot) {
                l++;
            }
        }
        // 如果 l = r，必须 l++，r--，否则栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 向右递归
        if (l < right) {
            quickSort(arr, l, right);
        }
        return arr;
    }
}
