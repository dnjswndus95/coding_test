package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12939
 * 문제 : 최댓값과 최솟값
 */
public class GetMaxAndMin {

    public static void main(String[] args) {
        String solution = solution("1 2 3 4");
        System.out.println("solution ===> " + solution);
    }

    public static String solution(String s) {
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;

        String[] numbers = s.split(" ");

        for(int i = 0; i < numbers.length; ++i) {
            Integer value = Integer.valueOf(numbers[i]);
            max = Math.max(max, value);
            min = Math.min(min, value);
        }


        String answer = min + " " + max;

        return answer;
    }
}
