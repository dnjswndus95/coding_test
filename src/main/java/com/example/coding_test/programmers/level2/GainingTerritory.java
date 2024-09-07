package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/12913
 * 문제 : 땅따먹기
 *
 * 아이디어
 * 1. 탐욕법...? 그때그때 큰거 찾으면 괜찮나...?
 * 2. DP : DP는 주어진 배열을 복사해서 더한값을 채우거나 주어진 배열에다가 더한 값을 계속해서 채워나가는 식으로...
 */
public class GainingTerritory {

    public static void main(String[] args) {
        int[][] board = {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};
        solution(board);
    }

    static int solution(int[][] land) {
        int answer = 0;

        for(int i = 1; i < land.length; ++i) {
            land[i][0] += getMaxNumber(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
            land[i][1] += getMaxNumber(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
            land[i][2] += getMaxNumber(land[i - 1][0], land[i - 1][1], land[i - 1][3]);
            land[i][3] += getMaxNumber(land[i - 1][0], land[i - 1][1], land[i - 1][2]);
        }

        for(int i = 0; i < 4; ++i) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }


        return answer;
    }

    public static int getMaxNumber(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
