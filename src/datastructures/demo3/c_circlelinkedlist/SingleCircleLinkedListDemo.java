package datastructures.demo3.c_circlelinkedlist;

import datastructures.demo3.Student;

/**
 * 测试环形列表功能
 */
public class SingleCircleLinkedListDemo {
    public static void main(String[] args) {
        SingleCircleLinkedListDemo demo = new SingleCircleLinkedListDemo();
        //demo.add();
        demo.delete();
    }

    public void add() {
        // 创建数据对象
        Student s1 = new Student(1111, "阿珍", 16);
        Student s2 = new Student(2222, "阿强", 17);
        Student s3 = new Student(3333, "小明", 18);
        Student s4 = new Student(4444, "小美", 17);
        // 创建环形链表
        SingleCircleLinkedList list = new SingleCircleLinkedList();
        // 插入链表
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        // 打印链表
        list.list();
    }

    private void delete() {
        // 创建数据对象
        Student s1 = new Student(1111, "阿珍", 16);
        Student s2 = new Student(2222, "阿强", 17);
        Student s3 = new Student(3333, "小明", 18);
        Student s4 = new Student(4444, "小美", 17);
        Student s5 = new Student(5555, "小光", 17);
        // 创建环形链表
        SingleCircleLinkedList list = new SingleCircleLinkedList();
        // 插入链表
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        // 出圈前
        list.list();
        // 每次第2个出圈
        list.delete(2);
    }
}
