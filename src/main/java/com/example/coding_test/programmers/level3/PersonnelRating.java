package com.example.coding_test.programmers.level3;

import java.util.Arrays;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/152995
 * 문제 : 인사고과
 */
public class PersonnelRating {

    public static void main(String[] args) {
        int[][] scores = {{2,2}, {1,4}, {3,2}, {3,2}, {2,1}};
        int solution = solution(scores);
        System.out.println(solution);
    }

    //근무 태도 점수, 동료 평가 점수 목록
    public static int solution(int[][] scores) {
        int[] me = scores[0];

        // 근무 태도 점수 내림차순
        // 동료 평가 점수 오름차순
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0])
                return o1[1] - o2[1];

            return o2[0] - o1[0];
        });

        int maxScore = scores[0][1];

        for(int i = 1; i < scores.length; ++i) {
            // 동료 평가 점수가 낮으면 인센티브 대상자가 아니다.
            // 근무태도는 내림차순, 동료 평가는 오름차순 했기 때문에 근무 태도 점수가 같다면 무조건 현재 사원이 maxScore보다 높은 동료 평가 점수를 가지고 있다.
            if(scores[i][1] < maxScore) {
                // 근데 이 사람이 완호이다? -1 리턴
                if(scores[i][0] == me[0] && scores[i][1] == me[1])
                    return -1;

                // 점수는 0점부터 있기 때문에 -1로 초기화
                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                // 3,2 다음에 3,3
                // 그럼 3으로 올려야겠지? 얘가 더 큰데
                maxScore = scores[i][1];
            }
        }

        // 1등부터 시작
        int answer = 1;

        Arrays.sort(scores, (o1, o2) -> {
            return (o2[0] + o2[1]) - (o1[0] + o1[1]);
        });

        for(int i = 0; i < scores.length; ++i) {
            if(scores[i][0] == me[0] && scores[i][1] == me[1])
                break;

            ++answer;
        }


        return answer;
    }
}
