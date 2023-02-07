package thursday.week13.hagyoung;

import java.util.HashMap;

public class Marathon {
    public static void main(String[] args) {
        System.out.println(
            solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    static String solution(String[] participant, String[] completion){
        HashMap<String, Integer> member = new HashMap<>();
        for(String name : participant){
            member.put(name, member.getOrDefault(name, 0)+1);
        }
        for(String name:completion){
            member.put(name, member.get(name)-1);
        }

        String answer = "";
        for(String name : member.keySet()){
            if(member.getOrDefault(name, 0)!=0) return name;
        }

        return answer;
    }
}
