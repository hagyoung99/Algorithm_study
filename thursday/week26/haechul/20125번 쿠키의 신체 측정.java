package BOJ.boj20125;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int heartX = 0;
        int heartY = 0;
        int leftArm = 0;
        int rightArm = 0;
        int waist = 0;
        int startLegIdx = 0;
        int leftLeg = 0;
        int rightLeg = 0;

        sc.nextLine();
        char[][] cookie = new char[n][n];
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < n; j++) {
                cookie[i][j] = temp.charAt(j);
                if (flag && cookie[i][j] == '*') {
                    heartX = i + 1;
                    heartY = j;
                    flag = false;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            char target = cookie[heartX][i];
            if (target == '*' && i < heartY) {
                leftArm++;
            } else if (target == '*' && i > heartY) {
                rightArm++;
            }
        }

        for (int i = heartX + 1; i < n; i++) {
            if (cookie[i][heartY] == '*') {
                waist++;
                startLegIdx = i;
            }
        }

        for (int i = startLegIdx + 1; i < n; i++) {
            if (cookie[i][heartY - 1] == '*') {
                leftLeg++;
            }
            if (cookie[i][heartY + 1] == '*') {
                rightLeg++;
            }
        }

        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);

    }
}
