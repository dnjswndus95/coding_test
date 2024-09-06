package com.example.coding_test.programmers.PCCE;

import java.util.Arrays;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/340198
 * 문제 : 공원
 *
 * 아이디어
 * 1. 최대 mat크기를 구하기 때문에 mat 원소중 큰 순서부터 검증
 * 2. park를 포문을 돌면서 mat크기 만큼 비어 있다면 그 안에서 이중 포문으로 세로열 검사
 */

public class Park {

    static int n = 0;
    static int m = 0;

    public static void main(String[] args) {
        int[] mats = {5,3,2};
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
        };
        int solution = solution(mats, park);
        System.out.println("answer ==> " + solution);
    }
    public static int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);

        n = park.length;
        m = park[0].length;

        System.out.println("n ====> " + n);
        System.out.println("m ====> " + m);

        for(int i = mats.length - 1; i >= 0; --i) {
            boolean flag = false;

            for(int x = 0; x < n; ++x) {
                for(int y = 0; y < m; ++y) {
                    if(checkSquare(park, mats[i], x, y))
                        return mats[i];
                }
            }
        }


        return -1;
    }

    public static boolean checkSquare(String[][] park, int size, int x, int y) {
        if(x + size > n || y + size > m)
            return false;

        for(int i = x; i < x + size; ++i) {
            for(int j = y; j < y + size; ++j) {
                if(!park[i][j].equals("-1"))
                    return false;
            }
        }

        return true;
    }
}
