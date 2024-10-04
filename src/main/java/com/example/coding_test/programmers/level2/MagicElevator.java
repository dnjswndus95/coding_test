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
            int digit = storey % 10;
            storey /= 10;

            if(digit == 5) {
                if(storey % 10 >= 5) {
                    answer += (10 - digit);
                    ++storey;
                } else {
                    answer += digit;
                }
            } else if(digit < 5) {
                // 나머지가 5보다 작으면 -1을 하는게 최선이다.
                answer += digit;
            } else if(digit >  5) {
                // 나머지가 5보다 크면 +1을 하는게 최선이다.
                answer += (10 - digit);
                // 올라가서 층수가 올라갔다.
                ++storey;
            }
        }


        return answer;
    }
}
