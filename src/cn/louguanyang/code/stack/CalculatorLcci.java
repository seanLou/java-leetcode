package cn.louguanyang.code.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 面试题 16.26. 计算器
 *
 * @author louguanyang
 * @createAt 2021/3/28 9:41 下午
 */
public class CalculatorLcci {

    public static void main(String[] args) {
        int answer = calculator("3+2*2");
        System.out.println(answer);
        answer = calculator(" 3+5 / 2 ");
        System.out.println(answer);
        answer = calculator("0*1");
        System.out.println(answer);
    }

    public static int calculator(String s) {
        char[] chars = s.trim().toCharArray();
        int i = 0;
        Stack<Integer> numStack = new Stack<>();
        while (i < chars.length) {
            char tmp = chars[i];
            if (tmp == ' ') {
                // 当前字符是空格 跳过
                i++;
                continue;
            }
            if (tmp == '+' || tmp == '-' || tmp == '*' || tmp == '/') {
                // 如果是 +-*/ 继续往下遍历
                i++;
                while (i < chars.length && chars[i] == ' ') {
                    i++;
                }
            }

            int num = 0;
            // 如果当前字符是数字，继续遍历 取出全部数字
            while (i < chars.length && Character.isDigit(chars[i])) {
                num = num * 10 + (chars[i] - '0');
                i++;
            }
            switch (tmp) {
                case '-':
                    num = -1 * num;
                    break;
                case '*':
                    num = numStack.pop() * num;
                    break;
                case '/':
                    num = numStack.pop() / num;
                    break;
                default:
                    break;
            }
            numStack.push(num);
        }
        int answer = 0;
        // 遍历数字栈
        while (!numStack.isEmpty()) {
            answer += numStack.pop();
        }
        return answer;
    }
}
