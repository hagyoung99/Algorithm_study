package stack;

import java.util.Scanner;

public class BaekJoon10773 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum[] = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {

            int num = sc.nextInt();
            if (num != 0) {
                sum[count] = num;
                count++;
            } else{
                count--;
                sum[count] = 0;
            }
        }

        int result = 0;
        for (int i : sum) {
            result += i;
        }
        System.out.println(result);
    }
}
