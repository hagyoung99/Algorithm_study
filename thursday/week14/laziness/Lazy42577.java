package thursday.week14.laziness;

import java.util.HashSet;

public class Lazy42577 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            HashSet<String> set = new HashSet<>();
            for (String str : phone_book) set.add(str);
            for (String str : phone_book) {
                for (int i = 0; i < str.length(); i++) {
                    String temp = str.substring(0, i);
                    if (set.contains(temp)) return false;
                }
            }
            return answer;
        }
    }
}
