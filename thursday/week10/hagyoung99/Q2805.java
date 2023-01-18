package thursday.week10.hagyoung99;

import java.io.*;
import java.util.*;
public class Q2805 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        int answer = Integer.MIN_VALUE;
        int start = 0;
        int end = max;
        while(start < max){
            int mid = (start+end)/2;    // 10
            int cnt = treeCount(tree, mid);
            if(cnt==M){
                answer = Math.max(answer, mid);
                break;
            }
            if(cnt<M) end = mid;
            else {
                start = mid;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }

    public static int treeCount(int[] arr, int hight){
        int cnt = 0;
        for(int x: arr){
            if(hight < x){
                cnt += x-hight;
            }
        }
        System.out.println("cnt:"+cnt+"\thight:"+hight);
        return cnt;
    }
}
