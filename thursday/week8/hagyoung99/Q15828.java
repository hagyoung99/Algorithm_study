package thursday.week8.hagyoung99;

import java.io.*;
import java.util.*;
public class Q15828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int inNum = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        while(inNum != -1){
            if(inNum!=0){
                if(q.size()<size) q.offer(inNum);
            } else {
                q.poll();
            }
            inNum = Integer.parseInt(br.readLine());
        }

        if(q.isEmpty()){
            System.out.println("empty");
        } else {
            for(int x:q){
                System.out.print(x+" ");
            }
        }
    }
}
