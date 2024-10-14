package com.example.coding_test.programmers.level2;

import java.util.Stack;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/131704
 * 문제 : 택배상자
 */
public class ParcelBox {

    public static void main(String[] args) {
        int[] order = {5, 4, 3, 2, 1};
        int answer = solution(order);
        System.out.println("answer =====>  " + answer);
    }
    public static int solution(int[] order) {
        int answer = 0;

        Stack<Integer> beltStack = new Stack<>();

        int[] boxArray = new int[order.length];
        for (int i = 0; i < boxArray.length; ++i) {
            boxArray[i] = i + 1;
        }

        int idx = 0;

        for(int i = 0; i < boxArray.length; ++i) {
            beltStack.push(boxArray[i]);

            while(!beltStack.isEmpty()) {
                if(beltStack.peek() == order[idx]) {
                    beltStack.pop();
                    ++answer;
                    ++idx;
                } else
                    break;
            }
        }

        return answer;
    }
}
