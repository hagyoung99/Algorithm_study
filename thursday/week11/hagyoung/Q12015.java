package thursday.week11.hagyoung;

import java.io.*;
import java.util.*;
public class Q12015 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; //입력값을 받을 배열
        int[] sub = new int[N];  //증가하는 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        sub[0] = arr[0];    //시작점은 0번째 인덱스로 입력한다.
        int lastIndex = 1;  //sub 배열에서 비교할 인덱스 값을 넣어준다.

        for(int i=1;i<N;i++){
            if(sub[lastIndex-1]<arr[i]){    //비교값(arr[i])이 sub 배열의 마지막 인덱스보다 크면 sub 배열에 추가한다.
                sub[lastIndex] = arr[i];
                lastIndex++;
            } else {    //작거나 같은 경우 이분탐색으로 비교값과 교체할 값을 찾는다.
                int min = 0;
                int max = lastIndex;
                while(min<max){
                    int mid = (min+max)/2;
                    if(sub[mid]<arr[i]) min = mid+1;
                    else max = mid;
                }
                sub[min] = arr[i];
            }
        }
        System.out.println(lastIndex);
    }
}
