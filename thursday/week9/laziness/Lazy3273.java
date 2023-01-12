package thursday.week9.laziness;

import java.util.Arrays;
import java.util.Scanner;

public class Lazy3273 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = scanner.nextInt(); int cnt = 0;
        Arrays.sort(arr);
        int frontIdx = 0, backIdx = arr.length - 1;
        while(frontIdx < backIdx) {
            if(arr[frontIdx] + arr[backIdx] > x) backIdx--;
            else if(arr[frontIdx] + arr[backIdx] < x) frontIdx++;
            else if(arr[frontIdx] + arr[backIdx] == x) {
                cnt += 1; frontIdx += 1;
            }
        }
        System.out.println(cnt);
        scanner.close();
    }
}
