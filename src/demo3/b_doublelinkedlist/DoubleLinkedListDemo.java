package demo3.b_doublelinkedlist;

import demo3.Student;

/**
 * 测试双向链表功能
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedListDemo demo = new DoubleLinkedListDemo();
        // 添加到链尾
        //demo.add();
        // 添加到指定位置
        //demo.addById();
        // 删除结点
        demo.delete();
        // 修改结点
        //demo.update();
    }

    public void add() {
        // 创建链表
        DoubleLinkedList list = new DoubleLinkedList();
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
        DoubleLinkedList list = new DoubleLinkedList();
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
        /* 创建链表 */
        DoubleLinkedList list = new DoubleLinkedList();
        /* 创建结点数据 */
        Student s1 = new Student(1111, "阿珍", 16);
        Student s2 = new Student(2222, "阿强", 17);
        Student s3 = new Student(3333, "小明", 18);
        Student upS2 = new Student(2222, "小黑", 16);
        Student delS3 = new Student(3333, "小明", 18);
        /* 添加节点 */
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s3);   // 重复添加
        list.list();    // 操作前打印
        System.out.println("---------------分隔符--------------");
        list.delete(delS3);     // 删除阿强
        list.update(upS2);
        list.list();
    }

    public void update() {
        // 创建链表
        DoubleLinkedList list = new DoubleLinkedList();
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
}
