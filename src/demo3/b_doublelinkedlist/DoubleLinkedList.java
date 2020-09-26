package demo3.b_doublelinkedlist;

import demo3.Student;

/**
 * 双向链表，在单链表的基础上增加
 */
public class DoubleLinkedList {

    public StudentNode2 head = new StudentNode2(null);  // 头节点，不存放具体数据

    /**
     * 将对象封装成一个结点
     *
     * @return 封装了数据的结点
     */
    private static StudentNode2 objToNode(Student student) {
        return new StudentNode2(student);
    }

    /**
     * 添加新节点到链表尾部
     *
     * @param student 待添加数据
     */
    public void add(Student student) {
        StudentNode2 node = objToNode(student);
        StudentNode2 temp = head;
        while (true) {

            if (temp.next == null) {
                temp.next = node;  // 尾结点的 next 域指向新结点
                node.pre = temp;  // 新结点 pre 域指向 尾结点，此时 node 变成新的尾结点
                break;
            }
            temp = temp.next;
            // 判断新节点是否存在
            if (student.getId() == temp.student.getId()) {
                System.out.println(student.getName() + "结点已经存在，不能重复添加.");
                break;
            }
        }
    }

    /**
     * 按学号大小插入数据
     * 找到比插入结点学号大的结点
     *
     * @param student 待插入数据
     */
    public void addById(Student student) {
        StudentNode2 node = objToNode(student);
        StudentNode2 temp = head;
        while (true) {
            // 遍历到尾结点
            if (temp.next == null) {
                temp.next = node;
                node.pre = temp;
                break;
            }

            // 找到学号比当前结点大的结点
            if (student.getId() < temp.next.student.getId()) {
                // 将新结点的前驱后继分别指向 temp 与 temp.next
                node.next = temp.next;
                node.pre = temp;
                // 先将 temp 的后继结点的 pre 域指向 node
                // 后将 temp 的 next 域指向 node，顺序不能反
                temp.next.pre = node;
                temp.next = node;
                break;
            }

            // 数据唯一
            if (student.getId() == temp.next.student.getId()) {
                System.out.println(student.getName() + "结点已存在，不能重复添加。");
                break;
            }

            temp = temp.next;
        }
    }

    /**
     * 删除结点，可以自删除
     */
    public void delete(Student student) {
        StudentNode2 temp = head;
        /* 遍历链表 */
        while (true) {
            /* 尾结点 */
            if (temp.next == null){
                System.out.println(student.getName() + "不在链表中");
            }
            /* 指向下一节点 */
            temp = temp.next;
            /* 是否为目标节点 */
            if (student.getId() == temp.student.getId()) {
                /* 将目标节点的前驱节点的 next 域指向目标节点的后继节点 */
                temp.pre.next = temp.next;
                /* 判断目标节点是否还有后继节点 */
                if (temp.next != null) {
                    /* 还有后继结点就将后继结点的 pre 域指向目标节点的前驱节点 */
                    temp.next.pre = temp.pre;
                }
                break;
            }
        }
    }

    /**
     * 修改结点，与单链表一样
     */
    public void update(Student student) {
        StudentNode2 node = objToNode(student);
        StudentNode2 temp = head;

        while (true) {
            // 遍历到尾结点
            if (temp.next == null) {
                System.out.println("未找到该结点");
                break;
            }

            // 修改结点，相当于用新结点替换了旧结点
            if (student.getId() == temp.next.student.getId()) {
                node.next = temp.next.next;
                temp.next = node;
                break;
            }

            temp = temp.next;
        }
    }

    /**
     * 遍历双向链表，与单链表一样
     */
    public void list() {
        /* 链表空，头节点没有后继结点 */
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        StudentNode2 temp = head.next;
        /* 有后继结点，继续遍历 */
        while (temp != null) {
            System.out.println(temp.student);  // 因为有头节点，所以直接打印后继结点数据域即可
            temp = temp.next;
        }
    }

}

// 定义结点类，每个结点对象就是链表中的一个结点
class StudentNode2 {
    public Student student;   // 数据域，存放具体数据
    public StudentNode2 next;  // 指针域，指向后继结点
    public StudentNode2 pre;  // 指针域，指向前驱结点

    // 构造器
    public StudentNode2(Student student) {
        this.student = student;
    }
}
