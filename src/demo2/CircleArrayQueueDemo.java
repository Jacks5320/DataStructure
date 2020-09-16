package demo2;

import java.util.Scanner;

/**
 * 数组模拟循环队列
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 创建循环队列
        CircleArrayQueue arrayQueue = new CircleArrayQueue(4);  // maxsize 最大值为 4 实际存储的有效数据个数为 3，有一个位置用于作约定。
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
class CircleArrayQueue {
    private int maxSize;  // 最大长度
    private int front;  // 队头
    private int rear;  // 队尾的后一个位置
    private int[] arr;   // 该数组用于存放数据，模拟队列

    // 创建队列的构造器
    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize + 1;  // 增加一个空间做约定
        arr = new int[this.maxSize];  // 保存数组
        front = 0;      // 指向队列头元素
        rear = 0;       // 指向队列尾元素的后一个位置。
    }

    // 判断队列是否满
    public boolean isFull() {
        // rear 指向不存任何元素的空间
        System.out.println(this.maxSize);
        System.out.println(arr.length);
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        //判断队列满
        if (isFull()) {
            System.out.println("队列满，不能添加数据");
            return;
        }
        arr[rear] = n;  // 直接赋值
        rear = (rear + 1) % maxSize;  // 环形结构后移一位取模
    }

    // 获取队列数据，出队列
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        int temp = arr[front];  // 取 front 指向位置的值
        front = (front + 1) % maxSize;  // front 后移一位，然后取模，取相对位置
        return temp;
    }

    // 显示所有数据
    public void showQueue() {
        // 遍历数组
        if (isEmpty()) {
            System.out.println("队列空，没有数据~");
            return;
        }
        // 从 front 开始遍历，遍历有效元素个数。
        for (int i = front; i <= front + (rear - 1 + maxSize - front) % maxSize; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
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
