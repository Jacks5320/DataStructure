package datastructures.demo5;
import java.util.Scanner;

/**
 * 哈希表：使用 数组 + 链表 结构
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(5);
        Scanner sc = new Scanner(System.in);
        String key;
        boolean loop = true;
        while (loop) {
            System.out.println("选择功能：");
            System.out.println("a：添加");
            System.out.println("f：查找");
            System.out.println("s：展示表中所有数据");
            System.out.println("e：退出");
            key = sc.next();
            switch (key) {
                case "a":
                    System.out.println("输出学号：");
                    int id = sc.nextInt();
                    System.out.println("输出姓名：");
                    String name = sc.next();
                    hashTable.add(id, name);
                    break;
                case "f":
                    System.out.println("输出待查找学生学号：");
                    id = sc.nextInt();
                    hashTable.findById(id);
                    break;
                case "s":
                    hashTable.show();
                    break;
                case "e":
                    sc.close();
                    loop = false;
                    System.out.println("程序退出");
                    break;
                default:
                    System.out.println("无效输出，从新选择：");
            }

        }
    }
}

class HashTable {
    StudentLinkedList[] studentLinkedListArray;  // 存放链表头节点的哈希表，存放学生头节点
    int size; // 哈希表的大小

    // 构造函数
    public HashTable(int size) {
        this.size = size;
        studentLinkedListArray = new StudentLinkedList[size];
        // 必须初始化，否则会有空指针
        for (int i = 0; i < size; i++) {
            studentLinkedListArray[i] = new StudentLinkedList();
        }
    }

    // 哈希函数，根据学生 id 计算
    public int hashFunc(int id) {
        return id % size;
    }

    // 存放数据
    public void add(int id, String name) {
        // 计算存储位置
        int index = hashFunc(id);
        // 封装结点
        StudentNode node = new StudentNode(id, name);
        // 保存结点
        studentLinkedListArray[index].add(node);
    }

    // 根据学号查找学生信息
    public void findById(int id) {
        // 计算存储位置
        int index = hashFunc(id);
        // 查找
        StudentNode node = studentLinkedListArray[index].find(id);
        if (node == null) {
            System.out.println("未找到相关信息");
        } else {
            System.out.printf("学号=%d，姓名=%s\n", node.id, node.name);
        }
    }

    // 遍历输出 hash 表
    public void show() {
        for (int i = 0; i < size; i++) {
            StudentNode temp = studentLinkedListArray[i].show(); // 获取每一条链表的头节点
            if (temp == null) {
                System.out.printf("第 %d 条链表为空~", i);
            } else {
                System.out.printf("第 %d 条链表中的数据：", i);
                while (temp != null) {
                    System.out.printf("学号=%d,姓名=%s\t", temp.id, temp.name);
                    temp = temp.next;
                }
            }
            System.out.println("");  // 换行
        }
    }
}

/**
 * 学生结点：为了方便演示，直接在结点中定义数据，不再新建一个类
 */
class StudentNode {
    public int id;  // 学号
    public String name;  // 姓名
    public StudentNode next;  // 尾指针

    // 构造函数
    public StudentNode(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

/**
 * 学生链表
 */
class StudentLinkedList {
    private StudentNode head;  // 头节点

    // 添加结点
    public void add(StudentNode node) {
        // 添加第一个结点时，头节点为 null，直接赋值即可
        if (head == null) {
            head = node;
            return;
        }
        StudentNode temp = head;
        // 找到尾结点
        while (temp.next != null) {
            temp = temp.next;
        }
        // 添加到尾部
        temp.next = node;
    }

    // 根据学号查找结点
    public StudentNode find(int id) {
        if (head == null) return null;
        StudentNode temp = head;
        while (temp != null) {
            // 找到了就返回
            if (id == temp.id) return temp;
            temp = temp.next;
        }
        // 循环结束前没有返回，说明没有找到相关信息
        return null;
    }

    // 返回链表头结点
    public StudentNode show() {
        if (head == null) return null;
        return head;
    }
}