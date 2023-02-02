import java.util.HashMap;

class Solution {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : participant) map.put(s, map.getOrDefault(s, 0) + 1);
        for (String s : completion) map.put(s, map.get(s) - 1);
        for (String key : map.keySet()) {
            if (map.get(key) != 0) return key;
        }
        return participant[participant.length - 1];
    }
}

class Test {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(Solution.solution(participant, completion));
    }
}
