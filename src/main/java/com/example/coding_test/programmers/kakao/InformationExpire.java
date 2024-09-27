package com.example.coding_test.programmers.kakao;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/150370
 * 문제 : 개인정보 수집 유효기간
 */
public class InformationExpire {

    public static void main(String[] args) {
        String[] terms = new String[]{"A 6", "B 12", "C 3"};
        String[] privacies = new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        solution("2022.05.19", terms, privacies);
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answerArray = new ArrayList<>();

        Map<String, Integer> termsMap = new HashMap<>();

        for (String s : terms) {
            String[] sList = s.split(" ");
            termsMap.put(sList[0], Integer.parseInt(sList[1]));
        }

        for(int i = 0; i < privacies.length; ++i) {
            String[] sList = privacies[i].split(" ");
            String date = sList[0];
            String term = sList[1];

            int iTerm = termsMap.get(term);

            if(!isExpire(today, date, iTerm))
                answerArray.add(i + 1);

        }

        int[] answer = new int[answerArray.size()];

        for (int i = 0; i < answerArray.size(); ++i) {
            answer[i] = answerArray.get(i);
        }

        return answer;
    }

    public static boolean isExpire(String today, String date, int iTerm) {
        String[] dates = date.split("\\.");
        String[] todayDates = today.split("\\.");

        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);

        int todayYear = Integer.parseInt(todayDates[0]);
        int todayMonth = Integer.parseInt(todayDates[1]);
        int todayDay = Integer.parseInt(todayDates[2]);

        month += iTerm;

        while(month > 12) {
            year += 1;
            month -= 12;
        }

        if(todayYear > year)
            return false;

        if(todayYear == year && todayMonth == month)
            return false;

        if(todayYear == year && todayMonth == month && todayDay >= day)
            return false;

        return true;

    }
}
