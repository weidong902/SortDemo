package com.weidd.best.dataStructure.Stack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-02-24 20:27
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
        return true;
    }

    @Test
    public void test1(){
        HashMap<Character,Character> map =new HashMap<Character,Character>();
        Character character = map.get("");
        System.out.println(character);

    }
}
