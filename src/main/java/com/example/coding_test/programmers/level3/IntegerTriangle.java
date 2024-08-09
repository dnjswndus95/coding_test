package com.example.coding_test.programmers.level3;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/43105
 * 문제 : 정수삼각형
 */

public class IntegerTriangle {

    public static void main(String[] args) {
        int[][] arr = {{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};
        solution(arr);
    }

    public static int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for(int h = 1; h < triangle.length; ++h) {
            dp[h][0] = dp[h-1][0] + triangle[h][0];

            for(int idx = 1; idx < h; ++idx){
                dp[h][idx] = Math.max(dp[h-1][idx-1], dp[h-1][idx]) + triangle[h][idx];
            }

            dp[h][h] = dp[h-1][h-1] + triangle[h][h];
        }

        for(int i = 0; i < dp[triangle.length-1].length; ++i) {
            answer = Math.max(answer, dp[triangle.length-1][i]);
        }

        return answer;
    }
}
