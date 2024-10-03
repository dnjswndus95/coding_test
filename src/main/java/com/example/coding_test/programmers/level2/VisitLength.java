package com.example.coding_test.programmers.level2;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/49994
 * 문제 : 방문 길이
 *
 * -5 ~ 5 까지 10 x 10 크기
 * 좌표가 아닌 좌표사이의 직선의 방문 여부를 확인해야 한다..
 * 3차배열로해서 어디서 온건지를 계산하자...
 */
public class VisitLength {

    public static void main(String[] args) {
        solution("ULURRDLLU");
    }

    public static int solution(String dirs) {
        int answer = 0;
        int size = 5;
        char[] commandList = dirs.toCharArray();
        int[] commands = new int[commandList.length];

        boolean[][][] isVisited = new boolean[11][11][4];
        int cx = 5;
        int cy = 5;


        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int i = 0; i < commands.length; ++i) {
            if(commandList[i] == 'R')
                commands[i] = 0;
            else if(commandList[i] == 'L')
                commands[i] = 1;
            else if(commandList[i] == 'U')
                commands[i] = 2;
            else if(commandList[i] == 'D')
                commands[i] = 3;
        }


        for(int i = 0; i < commands.length; ++i) {
            int nx = cx + dx[commands[i]];
            int ny = cy + dy[commands[i]];

            if(nx >= 0 && ny >= 0 && nx < 11 && ny < 11) {
                int direction = -1;

                switch (commands[i]) {
                    case 0:
                        direction = 1;
                        break;
                    case 1:
                        direction = 0;
                        break;
                    case 2:
                        direction = 3;
                        break;
                    case 3:
                        direction = 2;
                        break;
                }

                if(!isVisited[nx][ny][direction]) {
                    isVisited[nx][ny][direction] = true;
                    isVisited[cx][cy][commands[i]] = true;

                    ++answer;
                }
                cx = nx;
                cy = ny;
            }
        }

        return answer;
    }
}
