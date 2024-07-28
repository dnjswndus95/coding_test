package com.example.coding_test.level1;

/**
 *  주소 : https://school.programmers.co.kr/learn/courses/30/lessons/161989
 *  이름 : 덧칠하기
 *
 */
public class Painting {

    public static void main(String[] args) {
        int[] section = {2, 3, 6};
        int answer = Painting.solution(8, 4, section);
    }

    public static int solution(int n, int m, int[] section) {
        int paintCnt = 0;
        int idx = 0;
        if(m == 1)
            return section.length;

        if(m == n)
            return 1;

        for (int wall : section) {
            if(idx <= wall) {
                ++paintCnt;
                idx = wall + m;
            }

            if(idx > n)
                break;
        }
        return paintCnt;
    }
}
