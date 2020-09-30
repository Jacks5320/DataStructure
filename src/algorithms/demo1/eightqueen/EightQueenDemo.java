package algorithms.demo1.eightqueen;

/**
 * 8 皇后问题
 */
public class EightQueenDemo {
    int max = 8;  // 表示 8 个皇后
    static int count = 0;  // 统计解法
    int[] arr = new int[max];  // 解法数组，例如 arr = {0, 4, 7, 5, 2, 6, 1, 3}

    public static void main(String[] args) {
        // 测试 8 皇后
        EightQueenDemo queen = new EightQueenDemo();
        queen.check(0);
        // 解法数
        System.out.println("解法数=" + count);
    }

    // 放置第 n 个皇后
    // check 每一次递归都会进入 for 循环，因此产生回溯
    private void check(int n) {
        if (n == max) { // 所有皇后都放好了
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后 n 放到该行第一列
            arr[n] = i;
            // 判断是否冲突
            if (judge(n)) {
                // 不冲突，接着放 n + 1 个皇后，即开始递归
                check(n + 1);
            }
            // 如果冲突，则放置在本行的后一个位置
        }
    }

    // 判断当前摆放的皇后与之前摆放的的皇后是否冲突
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // arr[i] == arr[n] 在同一列
            // Math.abs(n - i) == Math.abs(arr[n] - arr[i]) 在同一斜线，绝对值
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    // 输出皇后摆放位置
    private void print() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
