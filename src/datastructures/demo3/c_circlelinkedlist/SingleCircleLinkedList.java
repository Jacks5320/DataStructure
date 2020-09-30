package datastructures.demo3.c_circlelinkedlist;

import datastructures.demo3.Student;

/**
 * 单向环形列表
 */
public class SingleCircleLinkedList {
    // 创建 first 结点
    StudentNode3 first = new StudentNode3(null);
    public int length = 0;

    // 对象封装成结点
    private static StudentNode3 objToNode(Student student) {
        return new StudentNode3(student);
    }

    // 获取链表长度
    /*
    public int size() {
        if (first.student == null) {
            return 0;
        }
        StudentNode3 cur = first;
        int count = 1;
        while (cur.next != first) {
            count++;
            cur = cur.next;
        }
        return count;
    }
     */

    /**
     * 添加结点，构成环形链表
     *
     * @param student 待插入对象
     */
    public void add(Student student) {
        StudentNode3 node = objToNode(student);
        // 辅助结点，遍历链表
        StudentNode3 cur = first;

        // 第一次添加数据
        if (length == 0) {
            first = node;  // 指针指向第一个结点
            node.next = node;  // 将第一个结点指向自己，形成换
            length++;
            return;
        }
        /* 添加非头结点 */
        while (true) {
            // 将 cur 移动到最后一个位置
            if (cur.next != first) {
                cur = cur.next;
                continue;
            }
            cur.next = node;  // 将尾结点指向新节点
            node.next = first;  // 将新结点指向头节点，继续形成环
            length++;
            break;
        }
    }

    /**
     * 删除指定位置的结点
     *
     * @param nums 每次移动数目
     */
    public void delete(int nums) {
        StudentNode3 cur = first;

        if (length == 0) {
            System.out.println("链表为空");
            return;
        }

        /* 因为从当前位置开始计数，1 就指的是自己，所以不能取 1 */
        if (nums <= 1) {
            System.out.println("num取值大于 1，输入值为：" + nums);
            return;
        }

        while (length >= 1) {
            /* 圈中只有一个同学 */
            if (length == 1) {
                System.out.println("最后出圈的同学：" + cur.student);
                first = new StudentNode3(null);
                length--;
                return;
            }
            /* 将 cur 移动到删除结点的前一个位置 */
            for (int i = 0; i < (nums - 2) % length; i++) {
                cur = cur.next;
            }
            /* 打印出圈的同学，cur 指向的后继节点 */
            System.out.println("出圈同学：" + cur.next.student);

            /* 将 cur 指向下一个的下一个结点，相当于删除了下一个结点，等着被垃圾回收机制回收 */
            cur.next = cur.next.next;
            cur = cur.next;
            length--;
        }
    }

    /**
     * 遍历链表
     */
    public void list() {
        //int length = size();
        if (length == 0) {
            System.out.println("链表为空");
            return;
        }
        StudentNode3 cur = first;
        for (int i = 0; i < length; i++) {
            System.out.println(cur.student);
            cur = cur.next;
        }
    }
}

// 创建结点类
class StudentNode3 {
    public Student student;
    public StudentNode3 next;

    public StudentNode3(Student student) {
        this.student = student;
    }
}