package BOJ.boj2480;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a == b && b == c) {
            System.out.println(10000 + a * 1000);
        } else if (b == c || a == b || a == c) {
            System.out.println(a == b ? 1000 + a * 100 : 1000 + c * 100);
        } else {
            System.out.println(Math.max(Math.max(a, b), c) * 100);
        }
    }
}
