package BOJ.boj5582;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String string1 = sc.nextLine();
        String string2 = sc.nextLine();
        int max = 0;
        int[][] arr = new int[string1.length() + 1][string2.length() + 1];
        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                    max = Math.max(max, arr[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
