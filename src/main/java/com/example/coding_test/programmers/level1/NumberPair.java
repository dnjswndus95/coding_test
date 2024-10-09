package com.example.coding_test.programmers.level1;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/131128
 * 문제 : 숫자 짝꿍
 */
public class NumberPair {

    public static void main(String[] args) {
        String solution = solution("1001", "2001");
        System.out.println("answer ===> " + solution);
    }
    public static String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] xArray = new int[10];
        int[] yArray = new int[10];

        int[] commonArray = new int[10];

        for(int i = 0; i < X.length(); ++i) {
            String s = String.valueOf(X.charAt(i));
            int value = Integer.parseInt(s);

            xArray[value]++;
        }

        for(int i = 0; i < Y.length(); ++i) {
            String s = String.valueOf(Y.charAt(i));
            int value = Integer.parseInt(s);

            yArray[value]++;
        }

        for(int i = 0; i < xArray.length; ++i) {
            if(xArray[i] == 0 || yArray[i] == 0)
                continue;

            commonArray[i] = Math.min(xArray[i], yArray[i]);
        }

        for(int i = commonArray.length - 1; i >= 0; --i) {
            while(commonArray[i] != 0) {
                if(i == 0 && sb.length() == 0) {
                    sb.append(0);
                    break;
                }
                sb.append(i);
                commonArray[i]--;
            }
        }

        if(sb.length() == 0)
            return "-1";

        return sb.toString();
    }
}
