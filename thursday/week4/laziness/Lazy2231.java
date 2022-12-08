import java.util.Scanner;

public class Lazy2231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;
        for(int i = 0 ; i < n ; i += 1) {
            int tmp = i;
            char[] tmpArr = (i + "").toCharArray();
            for(char c : tmpArr) tmp += c - '0';
            if(tmp == n) {
                answer = i; break;
            }
        }
        System.out.println(answer);
    }
}
