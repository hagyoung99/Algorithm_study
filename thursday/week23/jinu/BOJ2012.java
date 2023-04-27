package thursday.week23.jinu;

import java.util.*;
import java.io.*;

public class BOJ2012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            sum += Math.abs(arr[i] - (i + 1));
        }

        System.out.println(sum);

    }

}
