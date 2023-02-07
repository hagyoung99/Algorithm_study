package thursday.week13.hagyoung;

import java.util.HashSet;

public class Pokemon {
    public static int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int x:nums){
            hs.add(x);
        }
        
        if(hs.size()<nums.length/2){
            return hs.size();
        }
        
        return nums.length/2;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,1,2,3}));      //2
        System.out.println(solution(new int[] {3,3,3,2,2,4}));  //3
        System.out.println(solution(new int[] {3,3,3,2,2,2}));  //2
    }
}
