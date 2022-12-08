package 브루?�포??bronze.no2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2231{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        
        int[] arr = new int[1000001];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int n = Integer.parseInt(br.readLine());
        String result = "";
        int check = 0;
        for (int i = 0; i < arr.length; i++) {
            result = "" + arr[i];
            check = arr[i];
            for (int j = 0; j < result.length(); j++) {
                check += result.charAt(j) - '0';
            }
            if (check == n) {
                list.add(arr[i]);
            }
        }

        Collections.sort(list);
        if (list.size() == 0) {
            System.out.println(0);
        } else if (list.size() != 0) {
            System.out.println(list.get(0));
        }
    }
}

