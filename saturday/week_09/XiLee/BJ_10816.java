import java.io.*;
import java.util.*;

// upper & lower_bound : 원하는 값을 이상의 첫번째 위치를 return <-> B.N : return -1

// Upper Bound: target 을 초과하는 값이 나타나는 첫번째 위치를 반환
// Lower Bound: target 이상의 값이 나타나는 첫번째 위치를 반환

public class BJ_10816 {
    static int[] A;
    static int[] B;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int M = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            int key = sc.nextInt();

            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');

            // 중복 원소에 대한 길이 = 상한 - 하한
        }
        System.out.println(sb);
    }


    private static int lowerBound(int[] arr, int key) {
        int left=0;
        int right=arr.length;

        while(left<right) {
            int mid=(left+right)/2;

            if(key<=arr[mid]) {
                right=mid;
            }
            else {
                left=mid+1;
            }
        }

        return left;
    }

    private static int upperBound(int[] arr, int key) {
        int left=0;
        int right=arr.length;

        while(left<right) {
            int mid=(left+right)/2;

            if(key<arr[mid]) {
                right=mid;
            }
            else {
                left=mid+1;
            }
        }

        return left;
    }
}