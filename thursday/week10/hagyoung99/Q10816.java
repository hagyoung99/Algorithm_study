package thursday.week10.hagyoung99;

import java.io.*;
import java.util.*;
public class Q10816 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrN = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arrN[i] = Integer.parseInt(st.nextToken());



        int M = Integer.parseInt(br.readLine());
        int[] arrM = new int[M];
        st = new StringTokenizer(br.readLine());

        Arrays.sort(arrN);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(right(arrN, x) - left(arrN, x)).append(" ");
            arrM[i] = x;
        }
        System.out.println("answer--------------");
        System.out.println(sb);
        

        solution1(arrN, arrM);
        solution2(arrN, arrM);
    }
    
    public static int left(int[] arr, int key){
        int start = 0;
        int end = arr.length;

        while(start < end){
            int mid = (start+end)/2;
            if(arr[mid] >= key) end = mid;
            else start = mid+1;
        }

        return start;
    }
    
    public static int right(int[] arr, int key){
        int start = 0;
        int end = arr.length;

        while(start < end){
            int mid = (start+end)/2;
            if(key < arr[mid]) end = mid;
            else start = mid+1;
        }

        return start;
    }

    public static void solution1(int[] N, int[] M){
        Map<Integer, Integer> m = new HashMap<>();
        for(int x:N) m.put(x, m.getOrDefault(x, 0)+1);

        StringBuilder sb = new StringBuilder();
        for(int x:M) sb.append(m.getOrDefault(x, 0)).append(" ");

        System.out.println("solution1--------------");
        System.out.println(sb);
    }

    public static void solution2(int[] N, int[] M){
        StringBuilder sb = new StringBuilder();
        
        for(int x:M){
            int start = 0;
            int end = N.length -1;
            int cnt = 0;
            while(start<=end){
                int mid = (start+end)/2;

                if(N[mid] == x){
                    cnt++;
                    int lt=mid-1;
                    int rt = mid+1;
                    while(lt>=0 && N[lt--]==x) cnt++;
                    while(rt<N.length && N[rt++]==x) cnt++;
                    break;
                }
                if(N[mid] > x) end = mid-1;
                else start = mid+1;
            }
            sb.append(cnt).append(" ");
        }
        System.out.println("solution2--------------");
        System.out.println(sb);
    }
}
