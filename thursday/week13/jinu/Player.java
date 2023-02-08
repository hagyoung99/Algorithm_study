package thursday.week13.jinu;

import java.util.*;

// 완주하지 못한 선수(https://school.programmers.co.kr/learn/courses/30/lessons/42576)
public class Player {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> hm = new HashMap<>();

        // 먼저 참여자를 Map에 하나씩 넣고 1씩 증가
        for (String p : participant) {
            hm.put(p, hm.getOrDefault(p, 0) + 1);
        }

        // 완주자 목록을 하나씩 읽으며 저장된 맵의 value를 1씩 감소
        for (String c : completion) {
            hm.put(c, hm.get(c) - 1);
        }

        // Map에 저장된 value 값이 0이 아닌 사람의 이름을 출력
        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }

}
