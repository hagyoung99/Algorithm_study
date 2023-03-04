package Greddy;

import java.util.Scanner;

public class BaekJoon1789 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long S = sc.nextLong();
        long sum = 0;
        long i = 1;
        long count = 0;
        while (true) {
            sum += i++;
            if (sum > S) {
                System.out.println(count);
                return;
            }
            count++;
        }
    }
}
