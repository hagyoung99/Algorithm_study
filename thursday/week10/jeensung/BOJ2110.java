package samsung01.jeensung;
import java.util.*;
class BOJ2110{
    static int[] arr;
    static int c, n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        c = scan.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        Arrays.sort(arr);
        int left = 1;
        int right = arr[n - 1];
        int answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            if(check(mid)){
                answer = Math.max(answer, mid);
                left = mid + 1;
            }else
                right = mid - 1;
        }
        System.out.println(answer);
    }
    static boolean check(int mid){
        int count = 1;
        int p = 0;
        for(int i = 0; i < n - 1; i++){
            if(arr[p] + mid <= arr[i + 1]){
                count++;
                p = i + 1;
            }
        }
        if(count >= c) return true;
        return false;
    }
}