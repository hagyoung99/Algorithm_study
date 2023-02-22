package Brutforth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1018 {

        static int min = 64;
        static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        String bored[] = new String[row];
        for (int i = 0; i < row; i++) {
            bored[i] = br.readLine();
        }

        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= column - 8; j++) {
                transe(bored, i, j);
            }
        }
        System.out.println(min);
    }

    public static void transe(String bored[], int row, int column) {


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (((i % 2 == 0) && (j % 2 == 0)) || ((i % 2 == 1) && ( j % 2 == 1))) {
                    if (bored[i + row].charAt(j + column) == 'B') {
                    } else count++;
                } else {
                    if (bored[i + row].charAt(j + column) == 'W') {
                    } else count++;
                }
            }
        }
        if (count > 32) count = 64 - count;
        if (min > count) min = count;
       count = 0;
    }
}
