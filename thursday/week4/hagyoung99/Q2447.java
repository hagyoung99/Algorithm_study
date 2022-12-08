package thursday.week4.hagyoung99;
/*
문제
    재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
    크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
    N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
입력
    첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.
출력
    첫째 줄부터 N번째 줄까지 별을 출력한다.
 */

import java.io.*;
import java.util.*;
public class Q2447 {
    static String[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new String[N][N];
        for(int i=0;i<N;i++) Arrays.fill(arr[i], "*");

        star(0, 0, N, false);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void star(int x, int y, int N, boolean blank){
        if(blank) {
            for(int i=x;i<x+N;i++) for(int j=y;j<y+N;j++) arr[i][j] = " ";  //빈칸인 경우 해당 칸의 사이즈만큼 비운다.
            return;
        }

        if(N == 1) return;   //1이 될 경우 더이상 쪼개지지 않기 때문에 return 한다.

        int size = N/3;
        int cnt = 0;
        for(int i=x;i<x+N;i+=size){
            for(int j=y;j<y+N;j+=size){ //
                cnt++;
                if(cnt==5) star(i, j, size, true);  //5번재 칸이 될때 빈 칸이 된다.
                else star(i, j, size, false);
            }
        }
    }
}
