package com.example.coding_test.programmers.level2;

import java.util.Stack;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * 문제 : 올바른 괄호
 *
 * 스택을 사용하여 문제를 해결했지만
 * 간단하게 Integer 변수를 하나두고
 * '('일땐 ++ ')'일땐 -- 하여
 * count가 음수가 되는 순간 false를 리턴하는 방법도 있었다....
 */
public class RightBracket {

    public static void main(String[] args) {
        System.out.println(solution("(()("));
    }

    public static boolean solution(String s) {
        Stack<Integer> openStack = new Stack<>();

        char[] charArr = s.toCharArray();

        if(charArr[0] == ')')
            return false;

        for (char c : charArr) {
            if(c == '(') {
                openStack.add(0);
            } else {
                if(openStack.isEmpty())
                    return false;
                else
                    openStack.pop();
            }
        }

        if(openStack.isEmpty())
            return true;
        else
            return false;
    }
}
