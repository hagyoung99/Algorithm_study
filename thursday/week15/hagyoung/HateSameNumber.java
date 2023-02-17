package thursday.week15.hagyoung;

import java.util.*;
public class HateSameNumber {
    public static void main(String[] args) {
        for(int x: solution(new int[] {1,1,3,3,0,1,1})){
            System.out.print(x + " ");
        };
        System.out.println();
        for(int x: solution(new int[] {4,4,4,3,3})){
            System.out.print(x + " ");};
    }

    public static int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();
        for(int x:arr){
            if(s.empty()){
                s.push(x);
            } else{
                if(s.peek() != x){
                    s.push(x);
                }
            }
        }

        int[] answer = new int[s.size()];
        for(int i=answer.length-1;i>=0;i--){
            answer[i] = s.pop();
        }
        
        return answer;
    }
}
