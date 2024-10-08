package com.example.coding_test.programmers.level2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 주소 : https://school.programmers.co.kr/learn/courses/30/lessons/176962
 * 문제 : 과제
 *
 * [["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]]
 */
public class DoAssignment {
    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();

        LinkedList<Subject> subjectList = new LinkedList<>();
        Stack<Subject> stopSubject = new Stack<>();

        for (String[] plan : plans) {
            Subject subject = new Subject(plan);
            subjectList.add(subject);
        }

        subjectList.sort((o1, o2) -> o1.start - o2.start);

        Subject curSubject = subjectList.poll();
        int now = curSubject.start;

        while(!subjectList.isEmpty()) {
            now += curSubject.time;
            Subject nextSubject = subjectList.peek();

            if(now > nextSubject.start) {
                curSubject.time = now - nextSubject.start;
                stopSubject.push(curSubject);
            } else {
                answer.add(curSubject.name);
                if(!stopSubject.isEmpty()) {
                    curSubject = stopSubject.pop();
                    continue;
                }
            }
            curSubject = subjectList.poll();
            now = curSubject.start;
        }

        answer.add(curSubject.name);

        while(!stopSubject.isEmpty()) {
            answer.add(stopSubject.pop().name);
        }


        return answer.toArray(new String[0]);
    }

    public class Subject {
        private String name;
        private Integer start;
        private Integer time;

        public Subject(String[] strArr) {
            String[] timeArr = strArr[1].split(":");
            String hours = timeArr[0];
            String minute = timeArr[1];
            this.start = 60 * Integer.parseInt(hours) + Integer.parseInt(minute);
            this.name = strArr[0];
            this.time = Integer.parseInt(strArr[2]);
        }
    }
}
