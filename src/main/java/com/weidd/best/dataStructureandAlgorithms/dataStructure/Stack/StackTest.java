package com.weidd.best.dataStructureandAlgorithms.dataStructure.Stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-24 20:27
 * 力扣 : 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 **/
public class StackTest {
    public boolean isValid(String s) {
        int n = s.length();
        if (n == 0 || n % 2 == 1)
            return false;
        //遍历字符串，左括号入栈；右括号，则比较栈顶括号是否能对应上，对应上弹出左，对应不上，return false。
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < n; i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch))
                    return false;
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        //特判
        int n = s.length();
        if (n == 0 || n % 2 == 1)
            return false;
        //遍历字符串，左括号入栈；右括号，则比较栈顶括号是否能对应上，对应上弹出左，对应不上，return false。
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < n; i++) {
            Character ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{')
                stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                Character topChar = stack.pop();
                if (ch == ')' && topChar != '(') return false;
                if (ch == ']' && topChar != '[') return false;
                if (ch == '}' && topChar != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test1() {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        String s = "()[]{}";
        System.out.println(isValid1(s));

    }
}
