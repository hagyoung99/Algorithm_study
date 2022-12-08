package thursday.week2.hagyoung;

import java.io.*;
import java.util.*;
public class Q1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0;i<n;i++) arr[i] = br.readLine();

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() != s2.length()) {
                    if(s1.length()==s2.length()) return 0;
                    else if(s1.length() < s2.length()) return -1;
                    else return 1;
                } else return s1.compareTo(s2);
            }
        });

        System.out.println(arr[0]);
        for(int i = 1; i < n; i++) if (!arr[i].equals(arr[i - 1])) System.out.println(arr[i]);
    }
}
