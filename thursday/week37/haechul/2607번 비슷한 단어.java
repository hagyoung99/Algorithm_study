package BOJ.boj2670;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[] alphabet = new int[26];

        char[] tmp = sc.nextLine().toCharArray();
        for (char x : tmp) {
            alphabet[x - 'A']++;
        }

        int total = 0;
        for (int i = 0; i < n - 1; i++) {
            int[] copy = Arrays.copyOf(alphabet, alphabet.length);
            char[] word = sc.nextLine().toCharArray();

            for (char x : word) {
                copy[x - 'A']--;
            }

            int a = 0;
            int b = 0;

            boolean flag = true;
            for (int x : copy) {
                if (x == -1) a++;
                else if (x == 1) b++;
                else if (x != 0) {
                    flag = false;
                    break;
                }
                if (a > 1 || b > 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) total++;
        }
        System.out.println(total);
    }
}
