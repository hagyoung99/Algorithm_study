package thursday.week8.hagyoung99;

import java.io.*;
import java.util.*;
public class Q1021 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> d = new LinkedList<>();
        int answer=0;

        for(int i=1;i<=N;i++) d.add(i);

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            int findNum = Integer.parseInt(st.nextToken());
            int minIdx;

            int idx = d.indexOf(findNum);
            if(d.size()%2==0) minIdx = d.size()/2-1;
            else minIdx = d.size()/2;

            if(idx <= minIdx){
                for(int j=0;j<idx;j++){
                    int temp = d.pollFirst();
                    d.offerLast(temp);
                    answer++;
                }
            } else {
                for(int j=0;j<d.size()-idx;j++){
                    int temp = d.pollLast();
                    d.offerFirst(temp);
                    answer++;
                }
            }
            d.pollFirst();
        }
        System.out.println(answer);
    }
}
