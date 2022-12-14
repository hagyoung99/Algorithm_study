import java.util.Scanner;

public class Lazy1436 {
    public static int[] answer = new int[100000];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fillAnswer();
        System.out.println(answer[n - 1]);
    }

    private static void fillAnswer() {
        int tmp = 0;
        for(int i = 666 ; i < 6660000 ; i++) {
            if(Integer.toString(i).contains("666")) answer[tmp++] = i;
        }
    }

}
