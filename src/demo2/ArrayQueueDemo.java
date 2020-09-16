package demo2;

import java.util.Scanner;

/**
 * 数组模拟普通队列，该队列只能使用一次。
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        // 接收用户输入
        char key = ' ';
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            key = sc.next().charAt(0); // 接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = sc.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据为：%d\n", res);
                    } catch (Exception e) {
                        //TODO:handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据：%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出。");
    }
}

// 使用数组模拟队列
class ArrayQueue {
    private int maxSize;  // 最大长度
    private int front;    // 头指针，始终指向头元素的前一个位置。
    private int rear;     // 尾指针，始终指向尾元素
    private int[] arr;    // 该数组用于存放数据，模拟队列

    // 创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;  // 尾元素存在最大索引元素中
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;  // 头指针与尾指针指向同一个索引位置。
    }

    // 添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能添加数据");
            return;
        }
        // 将尾指针移向后一个空位置
        rear++;
        // 存储元素，此时 rear 仍指向尾元素
        arr[rear] = n;
    }

    // 获取队列数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];
    }

    // 显示队列中所有数据
    public void showQueue() {
        // 遍历数组
        if (isEmpty()) {
            System.out.println("队列空，没有数据~");
            return;
        }
        // 从头元素取到尾元素。
        // front 始终指向头元素索引的前一个位置，所以要从 front + 1 ，也就是头元素索引位置开始取值
        // rear 始终指向尾元素的索引，所以取值的索引范围为[front + 1 , rear]
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的头数据，不是取出数据
    public int headQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front]; // 头指针后移
    }
}
