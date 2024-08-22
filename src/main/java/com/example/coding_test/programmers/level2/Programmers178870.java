package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/178870
 * 문제 : 연속된 부분 수열의 합
 *
 * 설명 : 포인트 두개를 사용하여 푸는 문제
 *
 * 회고 : 처음에 while문 하나로 left, right를 증가시키며
 * 자질구레한 조건들을 이것저것 넣으니 코드의 가독성도 낮아지고
 * 내가 작성한 코드임에도 실수가 많아지고 헷갈렸다.
 * 좀 더 간단하게 조건을 정리하여 풀이
 */

public class Programmers178870 {

    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        solution(sequence, k);
    }

    public static int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;

        int minLength = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;


        for(; right < sequence.length; ++right) {
            sum += sequence[right];

            while(sum > k && left <= right) {
                sum -= sequence[left];
                ++left;
            }

            if(sum == k) {
                if(minLength > right - left) {
                    minLength = right - left;
                    answer1 = left;
                    answer2 = right;
                } else if(minLength == right - left) {
                    answer1 = Math.min(answer1, left);
                    answer2 = Math.min(answer2, right);
                }
            }
        }

        return new int[]{answer1, answer2};
    }
}


/**
 * int[] answer = new int[2];
 *         int left = 0;
 *         int right = 0;
 *
 *         int sum = 0;
 *         int minLength = Integer.MAX_VALUE;
 *
 *
 *         while(right < sequence.length && left <= right) {
 *
 *             if(left == right)
 *                 sum = sequence[left];
 *
 *
 *             if(sum == k) {
 *                 // 길이 갱신
 *                 if(right - left + 1 < minLength) {
 *                     minLength = right - left + 1;
 *                     answer[0] = left;
 *                     answer[1] = right;
 *                 }
 *
 *                 if(right - left + 1 == minLength) {
 *                     answer[0] = Math.min(answer[0], left);
 *                     answer[1] = Math.min(answer[1], right);
 *                 }
 *
 *                 // 양 포인터 +1
 *                 ++left;
 *                 ++right;
 *                 if(right + 1 < sequence.length) {
 *                     sum += sequence[right + 1];
 *                 }
 *                 sum -= sequence[left];
 *
 *             } else if(sum > k) {
 *                 sum -= sequence[left];
 *                 ++left;
 *             } else if(sum < k) {
 *                 if(right + 1 < sequence.length) {
 *                     sum += sequence[right + 1];
 *                 }
 *                 ++right;
 *             }
 *         }
 *
 *
 *         return answer;
 */
