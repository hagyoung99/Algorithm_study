package thursday.week4.hagyoung99;

/*
문제
    오늘도 서준이는 병합 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
    N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구해서 우리 서준이를 도와주자.
입력
    첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 500,000), 저장 횟수 K(1 ≤ K ≤ 108)가 주어진다.
    다음 줄에 서로 다른 배열 A의 원소 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 109)
출력
    배열 A에 K 번째 저장 되는 수를 출력한다. 저장 횟수가 K 보다 작으면 -1을 출력한다.
 */

import java.io.*;
import java.util.*;
public class Q24060{
    static int cnt = 0;
    static int M;
    static int result=-1;
    static int[] arr, tmp;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

        tmp = new int[N];
        
        mergeSort(0, N-1);   //시작 인덱스, 끝 인덱스
        System.out.println(result);
    }

    public static void mergeSort(int start, int end){
        if(start<end){
            int mid = (start+end)/2;    //배열을 가운데로 자른다.
            mergeSort(start, mid);   //앞부분 배열을 다시 나누고
            mergeSort(mid+1, end);   //뒷 부분도 배열을 다시 나눈다.
            //위의 과정이 끝나고 재귀가 종료되면 최소 단위로 잘린 상태 혹은 정렬되어 있는 상태이기 때문에 정렬함수를 호출한다.
            merge(start, mid, end);
        }
    }
    
    public static void merge(int start, int mid, int end){
        int lt = start;  //첫번째 배열의 시작 인덱스
        int rt = mid+1;  //두번째 배열의 시작 인덱스
        int index = 0;  //저장 배열 저장 인덱스
        while(lt<=mid && rt <= end){    //두 배열 중 하나의 인덱스가 끝까지 가면 종료한다.
            if(arr[lt] <= arr[rt]) tmp[index++] = arr[lt++]; //두 배열의 앞부터 비교해서 더 작은 값을 앞의 인덱스에 넣는다.
            else tmp[index++] = arr[rt++];
        }

        while (lt <= mid) tmp[index++] = arr[lt++];    //남은 배열의 값을 넣는다.
        while (rt <= end) tmp[index++] = arr[rt++];

        lt = start;
		index = 0;
		while (lt <= end) {
			arr[lt++] = tmp[index++];
			cnt++;
			if (cnt == M) {
				result = arr[lt-1];
				break;
			} 
		}
    }
}
