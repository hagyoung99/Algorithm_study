package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon2750 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int number;
    static int arr[];

    public static void main(String[] args) throws IOException {
        number = Integer.parseInt(br.readLine());

        arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < number; i++) {
            System.out.println(arr[i]);
        }
    }
}
