/*
    카운팅 정렬
    수의 범위에 맞는 배열을 선언하고, 입력되는 원소값을 배열의 인덱스로 인식해 카운팅한다.
    원소 입력이 종료되면 카운팅된 배열을 조회하며 0보다 큰 값을 해당 배열의 값 만큼 반복해 출력한다.
 */

import java.io.*;
public class Q10989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i=0;i<N;i++) arr[Integer.parseInt(br.readLine())]++;
        System.out.println();
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<10001;i++) {
            while(arr[i]>0){
                answer.append(i).append('\n');
                arr[i]--;
            }
        }

        System.out.println(answer);
    }
}
