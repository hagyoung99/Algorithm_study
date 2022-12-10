import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> sh = new HashSet<>();
        for(int i=0;i<N;i++) sh.add(br.readLine());
        int answer = 0;
        for(int i=0;i<M;i++) if(sh.contains(br.readLine())) answer++;
        System.out.println(answer);
    }
}
