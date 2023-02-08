package thursday.week13.jinu;

import java.util.*;

// 포켓몬(https://school.programmers.co.kr/learn/courses/30/lessons/1845) 
class Pocketmon {
    public int solution(int[] nums) {
        int answer = 0;
        // 배열의 숫자들을 중복을 제거했을때 갯수가 원래 배열 nums/2 보다 크다면 최대 고를 수 있는 종류는 nums/2가 되고
        // nums/2 보다 작거나 같다면 최대 고를 수 있는 종류는 중복을 제거했을때의 갯수
        int n = nums.length / 2;

        // 중복이 허용되지 않는 자료구조인 HashSet을 사용
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        if (n < hashSet.size())
            answer = n;
        else
            answer = hashSet.size();
        return answer;
    }
}