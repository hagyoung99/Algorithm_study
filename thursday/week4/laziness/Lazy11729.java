import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Lazy11729 {
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println((int)Math.pow(2, n) - 1);
        hanoi(n, 1, 3, 2);
        writer.flush();
        writer.close();
    }

    private static void hanoi(int n, int from, int to, int via) throws IOException {
        if(n == 1) {
            writer.write(from + " " + to + "\n");
        } else {
            hanoi(n - 1, from, via, to);
            writer.write(from + " " + to + "\n");
            hanoi(n - 1, via, to, from);
        }
    }
}
