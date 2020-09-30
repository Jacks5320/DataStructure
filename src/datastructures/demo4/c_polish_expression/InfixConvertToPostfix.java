package datastructures.demo4.c_polish_expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式并计算结果
 * 思路：
 * 1 先将字符串转变为字符串数组 ArrayList，方便操作
 * 2 将得到的表达式符号数组转换为后缀表达式
 * 3 计算后缀表达式的结果
 *
 * 2 * ( ( 5 - 3 ) * 4 ) - 16 / 2
 * (3 + 4) * 5 - 6
 */
public class InfixConvertToPostfix {
    public static void main(String[] args) {
        String s = "2 * ( ( 5 - 3 ) * 4 ) - 16 / 2";
        // 表达式转换为 list
        List<String> ls = stringToArray(s);
        System.out.println("中缀表达式：" + ls);
        // 中缀表达式 list 转 后缀 list
        List<String> ls2 = infixConvertToPostfix(ls);
        System.out.println("中缀表达式：" + ls2);
        // 计算后缀表达式的值
        int res = compute(ls2);
        System.out.println("计算结果：" + res);
    }

    /* 将表达式拆解后保存到 ArrayList 中 */
    public static List<String> stringToArray(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0;  // 遍历 String
        String str;     // 拼接多位数
        char c;     // 每次遍历到的字符
        do {
            c = s.charAt(i);
            if (isOperator(c)) {  // 如果遍历到的是符号，直接添加到 list
                ls.add("" + c);
                i++;
            } else if (isNumber(c)) { //  如果遍历到的是一个数，需要判断是否为多位数，用 str 拼接
                str = "";  // 先将 str 清空
                while (i < s.length() && isNumber(c = s.charAt(i))) {
                    str += c;   // 拼接多位数
                    i++;
                }
                ls.add(str);
            } else {  // 如果遍历到其他符号，直接滤过，如空格
                i++;
            }
        } while (i < s.length());
        return ls;
    }

    /* 中缀表达式转后缀表达式 */
    public static List<String> infixConvertToPostfix(List<String> infix) {
        // 创建两个栈，s1 用于存储临时符号
        Stack<String> s1 = new Stack<>();
        // s2 由于没有 pop 操作，并且最终需要逆序输出，所以使用 ArrayList 代替之
        List<String> s2 = new ArrayList<>();

        // 遍历传入的中缀表达式集合
        for (String s : infix) {
            // 如果是一个数，直接添加到 s2 中
            if (s.matches("\\d+")) {  // 正则匹配，匹配到数字
                s2.add(s);
            } else if ("(".equals(s)) {     // 遍历到 (，压入 s1
                s1.push(s);
            } else if (")".equals(s)) {  // 遍历到 ) ，遍历弹出 s1 中的符号添加到 s2 中，直至遇到 (
                while (!"(".equals(s1.peek())) {
                    s2.add(s1.pop());
                }
                s1.pop();  // 当 ( 弹出，消除小括号
            } else {  // 遍历到 + - * /
                while (!s1.empty() && (getPriority(s) <= getPriority(s1.peek()))) {// s1 不为空，且当遍历到的符号，小于等于栈顶符号优先级
                    s2.add(s1.pop());  // 将 s1 栈顶符号弹出添加到 s2 中
                }
                s1.push(s);
            }
        }

        // 将 s1 中剩余符号添加到 s2 中
        while (!s1.empty()) {
            s2.add(s1.pop());
        }
        return s2;
    }

    /* 判断扫描到的符号是不是 + - * / ( ) 这几个符号*/
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    /*
        计算符号的优先级：乘除为 2、加减为 1
        注意，这里只考虑入栈弹栈， + - * / ，虽然括号的优先级在计算时是最高的，但是入栈时，+ - 遇到 ( 也应该入栈，所以将其优先级设置为最低
    */
    public static int getPriority(String s) {
        if ("*".equals(s) || "/".equals(s)) {
            return 2;
        }
        if ("+".equals(s) || "-".equals(s)) {
            return 1;
        }
        if ("(".equals(s)) {
            return 0;
        }
        throw new RuntimeException("扫描到未知符号！");
    }

    /* 判断扫描到的字符是不是数字 */
    public static boolean isNumber(char c) {
        return 48 <= c && c <= 57;      // ascll码中数字 0 ~ 9 对应 48 ~ 57
    }

    /* 计算后缀表达式 */
    public static int compute(List<String> postFix) {

        Stack<Integer> num = new Stack<>();
        int num1 = 0;  // 接收栈顶数
        int num2 = 0;  // 接收次顶数
        int res = 0;  // 每次计算结果
        for (String s : postFix) {
            if (s.matches("\\d+")) {    // 如果是数，就压栈
                num.push(Integer.parseInt(s));
            } else {
                num1 = num.pop();
                num2 = num.pop();
                switch (s) {
                    case "+":
                        res = num2 + num1;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num2 * num1;
                        break;
                    case "/":
                        res = num2 / num1;
                        break;
                    default:
                        throw new RuntimeException("扫描到未知符号！");
                }
                num.push(res);
            }
        }
        return num.pop();
    }

}
