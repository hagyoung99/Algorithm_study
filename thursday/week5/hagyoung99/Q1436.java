import java.io.*;
public class Q1436 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        
        for(int i=666; true; i++){
            String str = Integer.toString(i);
            if(str.contains("666")) count ++ ;
            
            if(count == N) {
                    N = i;
                    break;
            }
        }
        System.out.println(N);
    }
}
