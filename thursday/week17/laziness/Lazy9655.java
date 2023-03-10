import java.util.Scanner;

public class Lazy9655 {
    public static boolean[] winner;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        winner = new boolean[n + 1];
        boolean isSK = getWinner(n);
        System.out.println(isSK ? "SK" : "CY");
        scanner.close();
    }

    private static boolean getWinner(int n) {
       return n % 2 == 1;
    }
}
