package algorithms.demo2;

import java.util.Arrays;

/**
 * 堆排序
 * 时间复杂度：O(nlog n)
 */
public class h_HeapSortDemo {
    public static void main(String[] args) {
        //int[] arr = {2, 5, 6, 4, 8, 9, 7};
        //int[] arr = {1, 2, 3, 4, 5, 6, 7, 7, 8, 9};
        int[] arr = {9,8,9,7,6,5,4,3,2,1};
        System.out.println("排序前的序列：" + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("堆排序的结果：" + Arrays.toString(arr));

        /* 100w ==> 180 毫秒 */
        /* 1000w ==> 2400 毫秒 */
        //int[] arrTime = new int[10000000];
        //for (int i = 0; i < 10000000; i++) {
        //    arrTime[i] = (int) (Math.random() * 10000000);
        //}
        //long former = System.currentTimeMillis();
        //heapSort(arrTime);
        //long later = System.currentTimeMillis();
        //System.out.println("时间：" + (later - former) + " 毫秒");
    }

    /**
     * 将一个完全二叉树重构为大顶堆
     *
     * @param tree 待调整的完全二叉树（数组实现）
     * @param p    当前调整父结点的坐标
     * @param size 堆的尺寸
     */
    public static void buildMaxHeap(int[] tree, int p, int size) {
        // 交换完成后，以被交换的子节点作为新节点继续调整
        // 只有发生交换时才会继续循环，以被交换的子结点作为父节点继续向下重构，i 初始定位定位左孩子
        for (int i = 2 * p + 1; i < size; i = 2 * i + 1) {
            // 右孩子存在比较两个孩子的值
            if (i + 1 < size && tree[i] < tree[i + 1]) {
                i += 1;  // 右孩子大，将 i 指向右孩子
            }
            // 孩子结点大于父结点，进行交换
            if (tree[i] > tree[p]) {
                int temp = tree[i];
                tree[i] = tree[p];
                tree[p] = temp;
                // 交换后，以被交换的节点作为父节点继续构造
                p = i;
            } else {  // 如果父结点比孩子节点大，直接退出即可，因为是从底层比到上层
                break;
            }
        }
    }

    /**
     * 堆排序
     *
     * @param tree 待排序数组
     */
    public static void heapSort(int[] tree) {
        // 第一步：将无序序列当作完全二叉树，并构建成大顶堆
        // p 指向父节点，从最后一个 非叶子节点 调整到根节点
        for (int p = tree.length / 2 - 1; p >= 0; p--) {
            buildMaxHeap(tree, p, tree.length);
        }
        //System.out.println(Arrays.toString(tree));

        // 第二步：交换根节点和尾节点，缩小堆的尺寸，重构大顶堆
        // 重复这个过程，直到尺寸减少为 1
        int size = tree.length;
        int temp = 0;
        while (size > 1) {
            // 交换根节点与尾节点
            temp = tree[0];
            tree[0] = tree[size - 1];
            tree[size - 1] = temp;
            // 缩小尺寸
            size--;
            // 从根节点开始重构大顶堆
            buildMaxHeap(tree, 0, size);
        }
    }
}
