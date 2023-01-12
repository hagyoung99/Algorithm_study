package thursday.week9.laziness;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Lazy2470 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        int a = 0, b = 0;
        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(arr);
        int closestSum = Integer.MAX_VALUE;
        int left = 0; int right = arr.length - 1;
        while(left < right) {
            int sum = Math.abs(arr[left] + arr[right]);
            if(sum < closestSum) {
                closestSum = sum;
                a = arr[left]; b = arr[right];
            }

            if(arr[left] + arr[right] < 0) left++;
            else right--;
        }
        System.out.println(a + " " + b);

        scanner.close();
    }
}
