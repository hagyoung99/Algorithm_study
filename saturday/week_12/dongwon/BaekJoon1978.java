package math;

import java.util.Scanner;

public class BaekJoon1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num >= 2) {
                for (int j = 2; j <= num; j++) {
                    if (num == j) count++;
                    else if (num % j == 0) break;
                }
            }
        }
        System.out.println(count);
    }
}
