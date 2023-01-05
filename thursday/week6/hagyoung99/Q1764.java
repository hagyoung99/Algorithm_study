package thursday.week6.hagyoung99;

import java.io.*;
import java.util.*;
public class Q1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> answer = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<N;i++) set.add(br.readLine());
        for(int i=0;i<M;i++){
            String name = br.readLine();
            if(set.contains(name)) answer.add(name);
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(String x: answer) System.out.println(x); 
    }
}
