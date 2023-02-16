package thursday.week14.hagyoung;

import java.io.*;
import java.util.*;
public class Q1697 {
    static int[] visit = new int[100001];
    static int K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N==K) System.out.println(0);
        else BFS(N);
        
    }

    public static void BFS(int N){
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visit[N] = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0;i<3;i++){
                int next;
                if(i==0){
                    next = now + 1;
                } else if(i==1) {
                    next = now - 1;
                } else {
                    next = now * 2;
                }

                if(next == K) {
                    System.out.println(visit[now]);
                    return;
                }

                if(next >= 0 && next < visit.length && visit[next] == 0){
                    q.offer(next);
                    visit[next] = visit[now]+1;
                }
            }
        }
    }
}
