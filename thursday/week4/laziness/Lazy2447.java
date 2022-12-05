import java.io.*;

public class Lazy2447 {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0 ; i < n ; i += 1) {
           for(int j = 0 ; j < n ; j += 1) printLine(i, j); // 줄 단위로 계산
           bufferedWriter.write("\n"); // 한 줄씩 출력
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
    public static void printLine(int y, int x) throws IOException {
        while(true) {
            if(y == 0) break;
            if(x % 3 == 1 && y % 3 == 1) {
                bufferedWriter.write(" ");
                return;
            }
            x /= 3; y /= 3;
        }
        bufferedWriter.write("*");
    }
}
