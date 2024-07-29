package com.example.coding_test.level1;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/176963
 * 이름 : 추억 점수
 */

public class MemoryScore {

    public static void main(String args[]) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photos = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        solution(name, yearning, photos);
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photos) {
        int[] answer = new int[photos.length];
        int idx = 0;
        for (String[] photo : photos) {
            int score = 0;
            for (int i = 0; i < photo.length; ++i) {
                for(int j = 0; j < name.length; ++j) {
                    if(name[j].equals(photo[i])) {
                        score += yearning[j];
                        break;
                    }
                }
            }
            answer[idx] = score;
            ++idx;
        }

        return answer;
    }
}
