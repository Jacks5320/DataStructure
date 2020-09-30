package datastructures.demo3.a_singlelinkedlist;

import datastructures.demo3.Student;

/**
 * 单链表功能测试
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedListDemo demo = new SingleLinkedListDemo();
        // 添加数据到尾部
        //demo.add();
        // 按学号大小添加数据
        //demo.addById();
        // 删除结点
        demo.delete();
        // 根据学号修改信息
        //demo.update();
        // 反转链表
        //demo.reverse();
    }

    public void add() {
        // 创建链表
        SingleLinkedList list = new SingleLinkedList();
        // 创建结点数据
        Student s1 = new Student(1111, "阿珍", 16);
        Student s2 = new Student(2222, "阿强", 17);
        Student s3 = new Student(3333, "小明", 18);
        Student s4 = new Student(4444, "小美", 17);
        // 添加数据到链表尾部
        list.add(s4);
        list.add(s2);
        list.add(s3);
        list.add(s1);
        list.add(s1);
        // 打印链表
        list.list();
    }

    public void addById() {
        // 创建链表
        SingleLinkedList list = new SingleLinkedList();
        // 创建结点数据
        Student s1 = new Student(1111, "阿珍", 16);
        Student s2 = new Student(2222, "阿强", 17);
        Student s3 = new Student(3333, "小明", 18);
        Student s4 = new Student(4444, "小美", 17);
        // 添加数据到链表尾部
        list.addById(s4);
        list.addById(s2);
        list.addById(s3);
        list.addById(s1);
        list.addById(s1);
        // 打印链表
        list.list();
    }

    public void delete() {
        // 创建链表
        SingleLinkedList list = new SingleLinkedList();
        // 创建结点数据
        Student s1 = new Student(1111, "阿珍", 16);
        Student s2 = new Student(2222, "阿强", 17);
        Student s3 = new Student(3333, "小明", 18);
        Student delS3 = new Student(3333, "小明", 18);
        Student upS1 = new Student(2222, "小黑", 16);
        // 添加数据到链表尾部
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s3);  // 重复添加
        // 更新和删除前
        list.list();
        System.out.println("---------------分隔符--------------");
        // 更新和删除后
        list.update(upS1);
        list.delete(delS3);
        list.list();
    }

    public void update() {
        // 创建链表
        SingleLinkedList list = new SingleLinkedList();
        // 创建结点数据
        Student s1 = new Student(1111, "阿珍", 16);
        Student s2 = new Student(2222, "阿强", 17);
        Student s3 = new Student(3333, "小明", 18);
        Student s4 = new Student(4444, "小美", 17);
        // 添加数据到链表尾部
        list.add(s4);
        list.add(s2);
        list.add(s3);
        list.add(s1);
        // 修改前
        list.list();
        // 修改后的新节点
        Student s5 = new Student(1111, "小美", 20);
        Student s6 = new Student(2222, "小美", 20);
        Student s7 = new Student(3333, "小美", 20);
        Student s8 = new Student(4444, "小美", 20);
        list.update(s5);
        list.update(s6);
        list.update(s7);
        list.update(s8);
        // 修改后的链表
        System.out.println("--------分隔符--------");
        list.list();
    }

    public void reverse() {
        // 创建链表
        SingleLinkedList list = new SingleLinkedList();
        // 创建结点数据
        Student s1 = new Student(1111, "阿珍", 16);
        Student s2 = new Student(2222, "阿强", 17);
        Student s3 = new Student(3333, "小明", 18);
        Student s4 = new Student(4444, "小美", 17);
        // 插入数据
        list.add(s1);
        list.add(s3);
        list.add(s2);
        list.add(s4);
        // 反转前
        list.list();
        // 反转后
        System.out.println("--------分隔符--------");
        list.reverse();
        list.list();
    }
}
/**
 * 单链表面试题
 * <p>
 * 题目一：获取链表有效结点个数
 * 思路：
 * 直接设置计数器，遍历链表即可。
 * <p>
 * 题目二：获取单链表的倒数第 K 个结点。
 * 思路 1：
 * 暴力法，首先遍历链表获取长度 size，第二次移动 size - k个位置即可
 * 思路 2：
 * 快慢指针，设置两个辅助结点(front,rear)，且它们的距离 K 个结点，当 rear 到达尾部时，front 就是倒数第 K 个结点。
 * <p>
 * 题目三：反转单链表
 * 思路 1：
 * 头插法，新建临时头节点，用于拼接临时链，
 * 新建反转辅助节点，用于将旧节点中的数据封装成单独节点，
 * 使用辅助节点遍历旧链。
 * 最后将旧链指向临时链，成为反转后的新链
 * 思路 2：
 * 使用栈先进后出的特点
 * 将单链表 a 中的数据依次压入栈中
 * 将栈中数据依次弹出，并插入到新链 b 中
 * <p>
 * 题目四：从尾到头打印单链表
 * 思路 1：先反转，再遍历打印。
 * 思路 2：栈的先进后出特点【push入栈，pop出栈】
 *
 * 题目五：按照顺序合并两条单链表。
 * 思路：将一个链表中的数据按照顺序插入到另一个链表中
 *
 */