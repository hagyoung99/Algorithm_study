package thursday.week6.hagyoung99;

import java.util.*;
import java.io.*;
public class Q11478 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<str.length()+1;i++){
            for(int j=i;j<=str.length();j++) {
                if(!str.substring(i,j).equals("")) hs.add(str.substring(i,j));
            }
        }
        System.out.println(hs.size());
    }
}
