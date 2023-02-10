package thursday.week14.jinu;

import java.util.*;

// 전화번호 목록(https://school.programmers.co.kr/learn/courses/30/lessons/42577)
public class PhoneList {

    public boolean solution(String[] phone_book) {

        // 전화번호 문자열 갯수를 비교해야 함으로 Key-Value Pair 관리하는 HashMap 클래스 생성
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
