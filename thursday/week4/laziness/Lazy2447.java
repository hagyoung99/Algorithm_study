import java.io.*;

public class Lazy2447 {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0 ; i < n ; i += 1) {
           for(int j = 0 ; j < n ; j += 1) printLine(i, j, n); // 줄 단위로 계산
           bufferedWriter.write("\n"); // 한 줄씩 출력
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
    public static void printLine(int row, int col, int n) throws IOException {
        if ((col / n) % 3 == 1 && (row / n) % 3 == 1) {
            bufferedWriter.write(" ");
        } else if(n / 3 == 0) {
            bufferedWriter.write("*");
        } else {
            printLine(row, col, n / 3);
        }
    }
}
