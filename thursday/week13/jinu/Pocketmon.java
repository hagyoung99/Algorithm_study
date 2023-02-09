package thursday.week13.jinu;

import java.util.*;

// 포켓몬(https://school.programmers.co.kr/learn/courses/30/lessons/1845) 
class Pocketmon {
    public int solution(int[] nums) {
        int answer = 0;
        // 배열의 숫자들을 중복을 제거했을때 갯수가 원래 배열 nums/2 보다 크다면 최대 고를 수 있는 종류는 nums/2가 되고
        // nums/2 보다 작거나 같다면 최대 고를 수 있는 종류는 중복을 제거했을때의 갯수
        // n/2 < 중복 x
        // result n / 2
        // n/2 > 중복 x
        // result 중복 x
        int n = nums.length / 2;

        // 중복이 허용되지 않는 자료구조인 HashSet을 사용
        HashSet<Integer> hashset = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            hashset.add(nums[i]);
        }
        if (n < hashset.size()) {
            answer = n;
        } else {
            answer = hashset.size();
        }
        return answer;
    }
}

// import java.util.Arrays;
// import java.util.stream.Collectors;
// // stream : 컬렉션에 저장되어 있는 엘리먼트들을 하나씩 순회하면서 처리할 수 있는 코드 패턴
// class Solution {
// public int solution(int[] nums) {
// return Arrays.stream(nums)
// .boxed()
// // Collectors : "Stream을 일반적인 List, Set등으로 변경시키는 Stream 메서드"
// // collectingAndThen Collecting을 진행한 후 그 결과로 메서드를 하나 더 호출
// .collect(Collectors.collectingAndThen(Collectors.toSet(),
// phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
// }
// }