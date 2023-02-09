package thursday.week13.hagyoung;

import java.io.*;
import java.util.*;
public class Q2606 {
    static boolean[] visit;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        visit = new boolean[N+1];
        
        for(int i = 0;i<N+1;i++){
            list.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for(int i=0;i<M;i++){   //간선별 노드 저장
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            list.get(to).add(from);
            list.get(from).add(to);
        }

        for(int i=1;i<list.size();i++){  //정렬
            Collections.sort(list.get(i));
        }

        count = 1;
        DFS(1, list);

        System.out.println(count-1);
    }

    static void DFS(int R, ArrayList<ArrayList<Integer>> list){
        visit[R] = true;
        for(int n : list.get(R)){
            if(!visit[n]){
                visit[n] = true;
                DFS(n, list);
                count++;
            }
        }
    }
}
