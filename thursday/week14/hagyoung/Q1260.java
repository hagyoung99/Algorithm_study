package thursday.week14.hagyoung;

import java.io.*;
import java.util.*;
public class Q1260 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] dVisit;
    static boolean[] bVisit;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        dVisit = new boolean[N+1];
        bVisit = new boolean[N+1];
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            list.get(to).add(from);
            list.get(from).add(to);
        }

        for(int i=1;i<list.size();i++){  //정렬
            Collections.sort(list.get(i));
        }

        DFS(V);
        sb.append("\n");
        BFS(V);

        System.out.println(sb);
    }

    public static void DFS(int V){
        dVisit[V] = true;
        sb.append(V+" ");
        
        for(int x:list.get(V)){
            if(!dVisit[x]){
                DFS(x);
            }
        }
    }

    public static void BFS(int V){
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        bVisit[V] = true;
        while(!q.isEmpty()){
            int next = q.poll();
            sb.append(next+" ");
            for(int x:list.get(next)){
                if(!bVisit[x]){
                    q.offer(x);
                    bVisit[x] = true;
                }
            }
        }
    }
}