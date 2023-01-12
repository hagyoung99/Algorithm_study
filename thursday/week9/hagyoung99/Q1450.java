package thursday.week9.hagyoung99;

import java.io.*;
import java.util.*;
public class Q1450 {
    static int N, C;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        dfs(0, N/2,0,left);
        dfs(N/2+1,N-1,0,right);

        Collections.sort(left);
        Collections.sort(right);
        int answer = 0;
        int e = right.size()-1;
        for(int i=0;i<left.size();i++){
            while(e>=0&&left.get(i)+left.get(e)>C){
                e--;
            }
            answer += e+1;
        }
        System.out.println(answer);
    }

    public static void dfs(int start, int end, int sum, List<Integer> list){
        if(sum>C) return;
        if(start > end){
            list.add(sum);
            return;
        }
        dfs(start+1, end, sum, list);
        dfs(start+1, end, sum+arr[start], list);
    }
}
  