import java.util.Scanner;

public class Lazy2798 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i += 1) arr[i] = scanner.nextInt();
        int answer = 0;
        loop1:
        for(int i = 0 ; i < n ; i += 1) {
            for(int j = i + 1 ; j < n ; j += 1) {
                for(int k = j + 1; k < n ; k += 1) {
                    int tmp = arr[i] + arr[j] + arr[k];
                    if(tmp > m) continue;
                    if(m - tmp < m - answer) answer = tmp;
                    if(answer == m) break loop1;
                }
            }
        }
        System.out.println(answer);
    }
}
