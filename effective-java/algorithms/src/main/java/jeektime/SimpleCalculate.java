package jeektime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author luzj
 * @description: 简易计算器，只处理 + - * / 的整数四则运算，不处理括号
 * @date 2019/5/31
 */
public class SimpleCalculate {
    static char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static char[] opts = {'+', '-', '*', '/'};

    public static void main(String[] args) {
        double s = calculate("99/4*3+234");//308.25
        System.out.println(s);

        s = calculate("54+5*9-76");//23.0
        System.out.println(s);

        s = calculate("998-22*998+4567");//-16391.0
        System.out.println(s);
    }


    /**
     * 计算字符串表达式
     * @param s
     * @return
     */
    public static double calculate(String s) {
        List<String> expression = generatorExpression(s);//表达式链表
        Stack<String> numbers = new Stack<>();//操作数栈
        Stack<String> operators = new Stack<>();//操作符栈
        ListIterator<String> iterator = expression.listIterator();//迭代表达式

        double result = 0;
        while (iterator.hasNext()) {
            String ele = iterator.next();
            char c;
            if (ele.length() == 1 && isOperator(c = ele.toCharArray()[0])) {//判断是操作符
                while (operators.peek() != null &&
                        lessOrEqualPriority(c, operators.peek().charAt(0))) {
                    double a = Double.valueOf(numbers.pop());
                    double b = Double.valueOf(numbers.pop());
                    result = cal_0(a, b, operators.pop());
                    numbers.push(String.valueOf(result));
                }
                operators.push(ele);
            } else {
                numbers.push(ele);
            }
        }

        while (!operators.isEmpty()) {
            double a = Double.valueOf(numbers.pop());
            double b = Double.valueOf(numbers.pop());
            result = cal_0(a, b, operators.pop());
            numbers.push(String.valueOf(result));
        }

        return result;
    }

    /**
     * 计算数值
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    static double cal_0(double a, double b, String c) {
        switch (c) {
            case "+":
                return a + b;
            case "-":
                return b - a;
            case "*":
                return a * b;
            case "/":
                return (double) b / a;
            default:
                return Double.MIN_VALUE;
        }
    }

    /**
     * 操作符a b 优先级对比
     * '*' = '/' > '+' = '-'
     *
     * @param a
     * @param b
     * @return true:a优先级大于b ;false:a优先级小于等于b
     */
    private static boolean lessOrEqualPriority(char a, char b) {
        //a 大于 b
        if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
            return false;
        } else {
            // a 小于等于 b
            return true;
        }

    }

    /**
     * 将字符串转换成表达式链表
     *
     * @param s
     * @return
     */
    static List<String> generatorExpression(String s) {
        StringBuilder sb = new StringBuilder();
        char[] m = s.toCharArray();
        List<String> eles = new ArrayList<>();

        for (int i = 0; i < m.length; i++) {
            if (isNumber(m[i])) {
                sb.append(m[i]);
            } else if (isOperator(m[i])) {
                eles.add(sb.toString());
                eles.add(String.valueOf(m[i]));
                sb = new StringBuilder();
            } else {
                throw new IllegalArgumentException("表达式不符合规范");
            }
        }
        eles.add(sb.toString());
        return eles;
    }

    private static boolean isMember(char[] arr, char s) {
        for (int i = 0; i < arr.length; i++) {
            if (s == arr[i])
                return true;
        }
        return false;
    }

    /**
     * 是否是整数
     *
     * @param s
     * @return
     */
    private static boolean isNumber(char s) {
        return isMember(numbers, s);
    }

    /**
     * 是否属于操作符
     *
     * @param s
     * @return
     */
    private static boolean isOperator(char s) {
        return isMember(opts, s);
    }

    /**
     * 使用数组实现栈，动态扩容
     *
     * @param <T>
     */
    static class Stack<T> {
        private Object[] arr;
        private int count = 0;

        public Stack(int size) {
            if (size > 0)
                arr = new Object[size];
            else
                throw new IllegalArgumentException("size must greater than 0!");
        }

        public Stack() {
            this(16);
        }

        void push(T element) {
            if (count >= capcity()) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }

            arr[count++] = element;
        }

        T pop() {
            if (count == 0)
                return null;
            return (T) arr[--count];
        }

        T peek() {
            if (count == 0)
                return null;
            return (T) arr[count - 1];
        }

        int capcity() {
            return arr.length;
        }

        int size() {
            return count;
        }

        boolean isEmpty() {
            return count == 0;
        }
    }


}
