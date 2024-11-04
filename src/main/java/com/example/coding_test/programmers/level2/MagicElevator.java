package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/148653
 * 문제 : 마법의 엘리베이터
 *
 * 10^c 층씩만 이동 가능
 * 0층이 가장 아래층 (0층 이하로 내려갈 수 없다)
 * 합친값이 0보다 더 아래면 안움직임...
 *
 * 최소한의 마법의 돌로 0층을 가기 위한 정수
 */
public class MagicElevator {

    public static void main(String[] args) {
        int answer = solution(2554);
        System.out.println(answer);
    }

    public static int solution(int storey) {
        int answer = 0;

        while(storey != 0) {
            int digits = storey % 10;
            storey /= 10;

            if(digits == 5) {
                if(storey % 10 >= 5) {
                    answer += (10 - digits);
                    storey += 1;
                } else {
                    answer += digits;
                }
            }
            else if(digits > 5) {
                answer += (10 - digits);
                storey += 1;
            } else {
                answer += digits;
            }
        }


        return answer;
    }
}
