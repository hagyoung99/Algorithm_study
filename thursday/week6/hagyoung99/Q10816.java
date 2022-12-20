import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        int nCnt = Integer.parseInt(in.readLine());
        StringTokenizer nStr = new StringTokenizer(in.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        while(i++<nCnt){
            int n = Integer.parseInt(nStr.nextToken());
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        StringBuffer answer = new StringBuffer();
        nCnt = Integer.parseInt(in.readLine());
        nStr = new StringTokenizer(in.readLine());
        i=0;
        while(i++<nCnt){
            answer.append(map.getOrDefault(Integer.parseInt(nStr.nextToken()), 0));
            answer.append(" ");
        }
        System.out.println(answer);
    }
}
