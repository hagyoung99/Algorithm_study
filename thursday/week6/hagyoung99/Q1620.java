package thursday.week6.hagyoung99;

import java.io.*;
import java.util.*;
public class Q1620 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> stringMap = new HashMap<>();
        HashMap<Integer, String> numberMap = new HashMap<>();
        
        for(int i=1;i<=N;i++){
            String name = br.readLine();
            stringMap.put(name, i);
            numberMap.put(i, name);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            String find = br.readLine();
            if(find.matches("[-+]?\\d*\\.?\\d+")) sb.append(numberMap.get(Integer.parseInt(find))).append('\n');
            else sb.append(stringMap.get(find)).append('\n');
        }
        System.out.println(sb);
    }
}
