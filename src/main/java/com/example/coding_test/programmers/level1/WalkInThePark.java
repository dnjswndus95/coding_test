package com.example.coding_test.programmers.level1;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/172928
 * 문제 : 공원 산책
 */
public class WalkInThePark {
    public static int[] solution(String[] park, String[] routes) {
        int startX = 0;
        int startY = 0;

        char[][] parkArray = new char[park.length][park[0].length()];

        for(int i = 0; i < park.length; ++i) {
            for(int j = 0; j < park[i].length(); ++j) {
                parkArray[i] = park[i].toCharArray();

                if(park[i].contains("S")){
                    startX = park[i].indexOf("S");
                    startY = i;
                }
            }
        }



        for (String route : routes) {
            String direction = route.split(" ")[0];
            Integer value = Integer.parseInt(route.split(" ")[1]);

            int tempX = startX;
            int tempY = startY;

            for(int i = 0; i < value; ++i) {
                if(direction.equals("E")) {
                    ++tempX;
                } else if(direction.equals("W")){
                    --tempX;
                } else if(direction.equals("N")) {
                    --tempY;
                } else if(direction.equals("S")) {
                    ++tempY;
                }

                if(tempX < parkArray[0].length
                && tempX >= 0
                && tempY >= 0
                && tempY < parkArray.length) {
                    if (parkArray[tempY][tempX] == 'X') {
                        break;
                    }

                    if (i == value - 1) {
                        startX = tempX;
                        startY = tempY;
                    }
                }
            }
        }

        int[] answer = {startY, startX};
        return answer;
    }
}
