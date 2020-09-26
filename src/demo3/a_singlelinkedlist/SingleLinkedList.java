package demo3.a_singlelinkedlist;

import demo3.Student;

/**
 * 单链表
 */
public class SingleLinkedList {

    public StudentNode head = new StudentNode(null);  // 头节点，不存放具体数据

    /**
     * 将对象封装成一个结点
     *
     * @return 封装了数据的结点
     */
    private static StudentNode objToNode(Student student) {
        return new StudentNode(student);
    }

    /**
     * 添加新节点到链表尾部
     * 找到尾结点，将尾结点的 next 域指向新结点
     *
     * @param student 结点数据域对象
     */
    public void add(Student student) {
        // 将对象封装成结点
        StudentNode node = objToNode(student);
        // 将辅助结点指第一个数据结点
        StudentNode temp = head;
        while (true) {
            /*
                保证结点唯一的写法
             */
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            // 移向下一个结点
            temp = temp.next;
            // 判断新节点是否存在
            if (student.getId() == temp.student.getId()) {
                System.out.println(student.getName() + "结点已经存在，不能重复添加.");
                break;
            }
            /*
                不保证数据唯一的写法
             */
            //if (temp.next == null){
            //    temp.next = node;
            //    break;
            //}
            //temp = temp.next;
        }
    }

    /**
     * 按学号大小插入数据
     * 找到比插入结点学号大的结点
     *
     * @param student 待插入数据
     */
    public void addById(Student student) {
        StudentNode node = objToNode(student);
        StudentNode temp = head;
        while (true) {
            // 遍历到尾结点
            if (temp.next == null) {
                temp.next = node;
                break;
            }

            // 找到学号比当前结点大的结点
            if (student.getId() < temp.next.student.getId()) {
                node.next = temp.next;
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
     * 删除结点
     */
    public void delete(Student student) {
        StudentNode temp = head;
        while (true) {

            if (temp.next == null) {
                System.out.println(student.getName() + "不在链表中。");
                break;
            }

            if (student.getId() == temp.next.student.getId()) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 修改结点
     * 根据学生学号，修改学生年龄
     *
     * @param student 待修改的结点
     */
    public void update(Student student) {
        StudentNode node = objToNode(student);
        StudentNode temp = head;

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
     * 遍历打印链表
     */
    public void list() {
        StudentNode temp = head;
        // 链表空，头节点没有后继结点
        if (temp.next == null) {
            System.out.println("链表为空~");
            return;
        }
        while (temp.next != null) {
            System.out.println(temp.next.student);  // 因为有头节点，所以直接打印后继结点数据域即可
            temp = temp.next;
        }
    }

    /**
     * 反转链表：头插法
    */
    public void reverse() {
        StudentNode nHead = new StudentNode(null);  // 临时链表
        StudentNode temp;  // 辅助反转结点
        StudentNode cur = head;  // 辅助遍历旧链表结点

        while (cur.next != null) {
            // 取到结点，封装到 temp ，成为新的结点
            temp = objToNode(cur.next.student);
            // 新节点添加到头部
            temp.next = nHead.next;
            // 临时头节点指向新结点
            nHead.next = temp;
            cur = cur.next;
        }
        head = nHead;
    }
}

// 定义结点类，每个结点对象就是链表中的一个结点
class StudentNode {
    public Student student;   // 数据域，存放具体数据
    public StudentNode next;  // 指针域，指向下一个结点

    // 构造器
    public StudentNode(Student student) {
        this.student = student;
    }

}
