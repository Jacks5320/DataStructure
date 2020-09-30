package algorithms.demo2;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {3, 9, 2, 7, 5, -2};
        System.out.println("排序前：" + Arrays.toString(arr));
        //冒泡排序
        //System.out.println("冒泡排序" + Arrays.toString(bubbleSort(arr)));
        // 选择排序
        //System.out.println("选择排序：" + Arrays.toString(selectSort(arr)));
        // 插入排序
        //System.out.println("插入排序：" + Arrays.toString(insertSort(arr)));
        // 希尔排序
        System.out.println("希尔排序" + Arrays.toString(shellSort(arr)));
    }
    /*  生成 80000 数据用于排序
        int[] arrTime = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arrTime[i] = (int) (Math.random() * 80000);
        }
        dateTime();
        //bubbleSort(arrTime);  // 13秒
        //selectSort(arrTime);    // 4 秒
        //insertSort(arrTime);  // 1 秒
        //shellSort(arrTime);  // 7 秒
        dateTime();
     */

    /* 测试时间 */
    public static void dateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:dd:ss.SSSS");
        Date date = new Date();
        System.out.println(sdf.format(date));
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
            //System.out.println("第 " + (i + 1) + " 趟排序结果：" + Arrays.toString(arr));
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
        int minIndex = 0;  // 记录最小值的坐标
        int temp;  // 交换两个数的中间变量

        boolean flag = false;  // 是否有交换

        /* 排序趟数：arr.length - 1 */
        for (int i = 0; i < arr.length - 1; i++) {
            // 每次比较从索引 i 处开始，一直比较到 arr.length - 1 处，比较次数为 arr.length - 1 - i
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;  // 记录最小值的索引值
                    flag = true;
                }
            }
            if (flag) {  // 最小值索引变化了
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            flag = false;  // 初始化
        }
        return arr;
    }

    /**
     * 插入排序：
     *
     * @param arr 待排序数组
     */
    public static int[] insertSort(int[] arr) {
        int insertVal;  // 待插入数
        int insertIndex;  // 插入位置的前一个位置

        // i = 1，从第二个位置开始
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            // insertIndex >= 0，保证给 insertVal 找插入位置不越界
            // insertVal < arr[insertIndex]，表示还没有找到插入位置
            // 需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 如果插入位置不是当前位置，才赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;  // 赋值
            }
        }
        return arr;
    }

    /**
     * 希尔排序
     *
     * @param arr 待排序数组
     */
    public static int[] shellSort(int[] arr) {
        // 增量 gap， 并逐步的减小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        // 移动
                        arr[j] = arr[j - gap];
                        j -= 1;
                    }
                    // while 退出就找到插入位置了
                    arr[j] = temp;
                }
            }
        }

    /*
        交换法
        int temp;  // 交换临时变量
        // 代码整理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
   */
        return arr;
    }

}
