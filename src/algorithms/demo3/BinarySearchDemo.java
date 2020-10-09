package algorithms.demo3;

import java.util.ArrayList;

/**
 * 二分查找
 * 使用前提为待查找序列是有序的
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        // 基本实现
        int[] arr = {1, 4, 9, 20, 22, 30, 50, 66, 88, 99};
        int index = binarySearch(arr, 0, arr.length - 1, 50);
        System.out.println("index = " + index);
        // 查找重复值
        //int[] arr = {1, 4, 9, 9, 9, 20, 30, 50, 66, 88, 99};
        //ArrayList<Integer> resultList = binarySearch2(arr, 0, arr.length - 1, 9);
        //System.out.println(resultList);
    }

    /**
     * 二分查找算法基本实现
     *
     * @param arr     待查找数组
     * @param start   起始索引
     * @param end     结束索引
     * @param findVal 待查找值
     * @return 找到返回索引值，没找到返回 -1
     */
    public static int binarySearch(int[] arr, int start, int end, int findVal) {
        if (start > end) return -1;  // 没有找到
        int mid = (start + end) / 2;

        if (findVal > arr[mid]) {  // 待查找数比中间数大，向右递归
            return binarySearch(arr, mid + 1, end, findVal);
        } else if (findVal < arr[mid]) {  // 待查找数比中间数小，向左递归
            return binarySearch(arr, start, mid - 1, findVal);
        } else {  // 找到待查找数的位置，findVal = arr[mid]
            return mid;
        }
    }

    /**
     * 二分查找算法：数组中有重复数，将所有数的位置找出
     *
     * @param arr     待查找数组
     * @param start   起始索引
     * @param end     结束索引
     * @param findVal 待查找值
     * @return 找到返回索引值，没找到返回 -1
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int start, int end, int findVal) {
        if (start > end) return new ArrayList<Integer>();  // 没有找到，返回空
        int mid = (start + end) / 2;

        if (findVal > arr[mid]) {  // 待查找数比中间数大，向右递归
            return binarySearch2(arr, mid + 1, end, findVal);
        } else if (findVal < arr[mid]) {  // 待查找数比中间数小，向左递归
            return binarySearch2(arr, start, mid - 1, findVal);
        } else {  // 找到待查找数的位置，findVal = arr[mid]
            //  将找到的值放入 arrayList 中
            ArrayList<Integer> list = new ArrayList<>();
            list.add(mid);  // 将当前位置添加
            // 向左扫描
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == findVal) {
                list.add(temp);
                temp -= 1;
            }
            // 向右扫描
            temp = mid + 1;
            while (temp < arr.length && arr[temp] == findVal) {
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
