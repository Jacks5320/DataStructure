package algorithms.demo1.b_simplemaze;

public class SimpleMaze {
    public static void main(String[] args) {
        /* 创建一个二维数组 */
        int[][] map = new int[8][7];
        /* 上下墙 */
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        /* 左右墙 */
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        /* 设置挡板， 1 表示 */
        map[3][1] = 1;
        map[3][2] = 1;
        /* 封死路，测试回溯 */
        //map[1][2] = 1;
        map[2][2] = 1;
        /* 输出地图 */
        System.out.println("原始地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        /* 使用递归回溯找路 */
        setWay(map, 1, 1);

        /* 输出走过并标识的路径 */
        System.out.println("标识过后的地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小求找路， 出发点为 (1,1)，终点为 (6,5)
     * 约定：当 map[i][j] 为 0 时，该点没有走过，为 1 时，表示墙，为 2 时表示通路可以走，为 3 时表示走过，但走不通。
     * 走迷宫策略：下 -> 右 -> 上 -> 左，如果该点走不通就回溯。
     *
     * @param map 迷宫地图
     * @param i   起始坐标
     * @param j   起始坐标
     * @return 找到通路返回 true ，否则返回 false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {  // 找到通路
            return true;
        } else {
            if (map[i][j] == 0) {  // 没有走过
                // 按策略走，下 -> 右 -> 上 -> 左
                map[i][j] = 2;  // 假定能走
                if (setWay(map, i + 1, j)) {  // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {  // 向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {  // 向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {  // 向左走
                    return true;
                } else {  // 都走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {  // 不等于 0，1 表示墙、2 表示走过、3 表示死路
                return false;
            }
        }
    }
}
