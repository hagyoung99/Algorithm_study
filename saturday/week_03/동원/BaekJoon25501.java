package recursive_function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class BaekJoon25501 {

    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        String arr[] = new String[n];

        for (int i = 0; i < n; i++) {
            count = 0;
            arr[i] = br.readLine();
            sb.append(recursion(arr[i], 0, arr[i].length() - 1) + " " + count).append('\n');
        }
        System.out.println(sb);
    }

    public static int recursion(String arr, int start, int end) {
        count++;
        char[] str = arr.toCharArray();
        if (start >= end) return 1;
        else if (str[start] != str[end]) return 0;
        else return recursion(arr, start + 1, end - 1);
    }
}


