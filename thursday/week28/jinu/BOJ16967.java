package thursday.week28.jinu;

import java.util.*;

public class BOJ16967 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A, B, X, Y;

        A = sc.nextInt();
        B = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();

        int[][] arrA = new int[A][B];
        int[][] arrB = new int[A + X][B + Y];

        for (int i = 0; i < A + X; i++) {
            for (int j = 0; j < B + Y; j++) {
                arrB[i][j] = sc.nextInt();
            }
        }

        // 겹치지않는 왼쪽 위 부분
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < B; j++) {
                arrA[i][j] = arrB[i][j];
            }
        }
        for (int i = X; i < A; i++) {
            for (int j = 0; j < Y; j++) {
                arrA[i][j] = arrB[i][j];
            }
        }

        // 겹치는 부분
        for (int i = X; i < A; i++) {
            for (int j = Y; j < B; j++) {
                arrA[i][j] = arrB[i][j] - arrA[i - X][j - Y];
            }
        }

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                System.out.print(arrA[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }

}
