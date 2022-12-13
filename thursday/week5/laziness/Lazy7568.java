import java.util.Scanner;

public class Lazy7568 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        int[] scales = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        for(int i = 0 ; i < n ; i++) {
            int target = 1;
            for(int j = 0 ; j < n ; j++) {
                if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
                    target += 1;
                }
            }
            scales[i] = target;
        }
        for(int i : scales) System.out.printf("%d ", i);
    }
}
