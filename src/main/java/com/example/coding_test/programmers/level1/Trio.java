package com.example.coding_test.programmers.level1;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/131705
 * 제목 : 삼총사
 *
 * 완전 탐색을 해도 13 * 12 * 11 몇천 단위밖에 되지 않는다
 */
public class Trio {

    public static void main(String[] args) {
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        int answer = solution(number);
        System.out.println(answer);
    }

    public static int solution(int[] number) {
        int answer = 0;

        for(int i = 0; i < number.length - 2; ++i) {
            for(int j = i + 1; j < number.length - 1; ++j) {
                for(int k = j + 1; k < number.length; ++k) {
                    if(number[i] + number[j] + number[k] == 0)
                        ++answer;
                }
            }
        }

        return answer;
    }
}
