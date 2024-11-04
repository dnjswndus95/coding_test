package com.example.coding_test.programmers.level1;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/136798?language=java
 * 문제 : 기사단원의 무기
 */


public class KnightWeapon {

    public static void main(String[] args) {
        solution(6, 1, 1);
    }


    // 더 좋은 방법으로 풀어보기
    public static int solution(int number, int limit, int power) {
        int answer = 0;

        int[] weaponArray = new int[number + 1];

        // 약수를 구하는 더 좋은 방식 (1~number까지의 약수를 모두 구할 때 더 좋음)
        // i가 2일땐 배열의 2, 4, 6, 8번 인덱스만 +1
        // i가 3일땐 배열의 3, 6, 9  3의 배수 인덱스만 +1
        for(int i = 1; i <= number; ++i) {
            for(int j = 1; j <= number / i; ++j) {
                weaponArray[i * j]++;
            }
        }

        for(int i = 1; i <= number; ++i) {

            if(weaponArray[i] > limit)
                answer += power;
            else
                answer += weaponArray[i];
        }


        return answer;
    }


    /**
     *
     * @param number 기사단원의 수 1 ~ num 까지
     * @param limit  공격력의 제한수치
     * @param power  제한수치를 넘었을 경우 사용해야 하는 무기
     * @return
    public int solution(int number, int limit, int power) {
        int answer = 0;

        // 단일 숫자에 대한 약수를 구할 때 더 좋은 방식
        for(int i = 1; i <= number; ++i) {
            // 약수를 구하는 함수
            int weaponAttack = getWeaponAttack(i);

            if(weaponAttack > limit)
                answer += power;
            else
                answer += weaponAttack;
        }

        return answer;
    }

    public static int getWeaponAttack(int num) {
        int count = 0;

        for(int i = 1; i * i <= num; ++i) {
            if(num % i == 0) {
                ++count;

                if(i != num/i)
                    ++count;
            }
        }

        return count;
    }*/
}
