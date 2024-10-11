package com.example.coding_test.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {

    public static void main(String[] args) {
        solution("AAAE");
    }

    static String[] strArray = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();
    public static int solution(String word) {
        int answer = 0;

        dfs("", 0);
        int size = list.size();

        for(int i = 0; i < size; ++i) {
            if(word.equals(list.get(i)))
                return i;
        }

        return answer;
    }

    public static void dfs(String str, int length) {
        list.add(str);

        if(length == 5)
            return;
        for(int i = 0; i < strArray.length; ++i) {
            dfs(str + strArray[i], length + 1);
        }
    }

}
