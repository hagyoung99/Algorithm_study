import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();
        int[] arr = new int[N]; 
        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr); // 정렬

        int M = in.nextInt();
        for(int i = 0; i < M; i++) {

            if(binarySearch(arr, in.nextInt()) >= 0) {
                sb.append(1 + "\n");
            }
            else {
                sb.append(0 + "\n");
            }
        }
       System.out.println(sb);
    }
    public static int binarySearch(int[] arr, int target) {
        int low = 0; // 탐색 범위의 첫번째 인덱스
        int high = arr.length - 1; // 탐색 범위의 마지막 인덱스

        while(low <= high) { 
            int mid = (low + high) / 2;

            if(target < arr[mid]) {
                high = mid - 1;
            }
           
            else if(target > arr[mid]) {
                low = mid + 1;
            }
  
            else {
                return mid;
            }
        }
     
        return -1;
    }
}
