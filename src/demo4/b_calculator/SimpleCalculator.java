package demo4.b_calculator;

import demo4.a_stack.ArrayStack;

/**
 * 简单计算器：中缀表达式， 2 * 2 + 1 * 2 = 6
 */
public class SimpleCalculator {
    /*
        思路：
            1. 创建两个栈，一个数字栈，一个符号栈
            2. 当运算符优先级 <= 栈中的优先级时，弹出入栈的两个数和栈中运算符，将运算结果和优先级低的运算符入栈
            3. 当运算符优先级 > 符号栈中的运算符优先级时，符号入栈
            4. 最终结果会保存到栈顶，此时栈中只有一个元素

        存在问题：
            不支持多位数参与运算。     --> 解决
            不支持带括号的运算       --> 未解决
            没有考虑负数问题，运算结果为负数、以负数存在于表达式中。  --> 未解决
        测试：
        7 + 2 * 6 - 4   ==> 15，正常
        100 + 2 * 6 - 40  ==> 72，正常
        7 - 2 * 6 + 4   ==> -9，bug
        -1 + 2 * 3 -7   ==> 异常，第一个读取到的是操作符，栈中没有元素可以出栈。
        2 * ( 3 + 4 )   ==> 异常，( 不能转化为数字，因为程序中没有处理小括号。

        存在 bug：
        ==> 第一个字符为负号、运行结果为负号时，不能得出正确结果。
        ==> 存在小括号等其他非运算符时，出现异常

        解决 ==> 将中缀表达式转换为后缀表达式（或前缀表达式）

     */
    public static void main(String[] args) {
        /* 创建数栈与符号栈 */
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack opeStack = new ArrayStack(10);
        /* 表达式 */
        String expression = "7 + 2 * 6 - 4";
        expression = expression.replaceAll(" ", "");    // 清除空格
        /* 扫描字符串的索引 */
        int index = 0;
        char ch = ' ';  // 每次扫描到的字符
        String keepNum = "";  // 拼接多位数
        /* 数栈中弹出的两个数与符号中中弹出的操作符号 */
        int num1 = 0;
        int num2 = 0;
        int ope = 0;  // 字符与数字可以互换，ASCLL 码
        /* 运算结果 */
        int res = 0;
        /* 开始循环扫描表达式 */
        while (true) {
            /* 依次获取 expression 的每一个符号 */
            ch = expression.substring(index, index + 1).charAt(0);  // 每次只取一个
            /* 如果是操作符 + - * / */
            if (isOperator(ch)) {
                /* 如果符号栈不为空，需比较当前操作符 ch 与栈顶操作符 ope 的优先级 */
                if (!opeStack.isEmpty()) {
                    /* 获取字符优先级 */
                    int chPri = getPriority(ch);    // 当前
                    int opePri = getPriority((char) opeStack.getTopVal());  // 栈顶

                    if (chPri <= opePri) {
                        num1 = numStack.pop();  // 栈顶数
                        num2 = numStack.pop();  // 次顶数
                        ope = opeStack.pop();   // 栈顶操作符
                        /* 获取运算结果后入数栈，并将外面等着的运算符入符号栈 */
                        res = compute(num1, num2, ope);     // num2 (+-*/) num1
                        numStack.push(res);     // 结果入栈
                    }
                }
                /* 当符号栈为空或将计算结果入栈后，需要将扫描到的 ch 入栈 */
                opeStack.push(ch);
            } else {
                /* 如果扫描到的结果是数，需要处理多位数问题 */
                //numStack.push(ch - 48);  // 1 的 ascll 码为 49
                /* 拼接字符后，像后看一位 */
                keepNum += ch;

                /* 如果 ch 是最后一个字符，则直接入栈 */
                if (expression.length() - 1 == index) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    /* 如果是操作符，就将 keepNum 转换成整型入栈，并清空 keepNum */
                    if (isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";   // 清空
                    }
                }
            }
            index++;  // 索引后移
            /* 如果 index == length 遍历完成 */
            if (index >= expression.length()) break;
        }

        /* 当表达式扫描完成 */
        while (true) {
            /* 当符号栈为空时，数栈中只有一个数，这个数就是结果 */
            if (opeStack.isEmpty()) break;
            num1 = numStack.pop();  // 栈顶数
            num2 = numStack.pop();  // 次顶数
            ope = opeStack.pop();   // 栈顶操作符
            res = compute(num1, num2, ope);     // num2 (+-*/) num1
            numStack.push(res);     // 结果入栈
        }
        System.out.println("表达式：" + expression + "=" + numStack.pop());
    }

    /* 判断符号是数还是操作符 */
    public static boolean isOperator(char ope) {
        /* 操作符 */
        return '+' == ope || '-' == ope || '*' == ope || '/' == ope;
    }

    /* 获取符号的优先级 */
    public static int getPriority(char ch) {
        if ('+' == ch || '-' == ch) return 1;

        if ('*' == ch || '/' == ch) return 2;

        return 0;
    }

    /* 计算弹出两个数的结果 */
    public static int compute(int n1, int n2, int ope) {
        switch (ope) {  // 先入栈的操作后入栈
            case '+':
                return n2 + n1;
            case '-':
                return n2 - n1;
            case '*':
                return n2 * n1;
            case '/':
                return n2 / n1;
            default:
                throw new RuntimeException("计算出错！");
        }
    }
}