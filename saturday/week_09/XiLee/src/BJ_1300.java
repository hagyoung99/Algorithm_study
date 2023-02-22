import java.util.Scanner;

public class BJ_1300 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr2D = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr2D[i][j] = (i+1) * (j+1);
            }
        }

        int[] arr = new int[N*N];
        for (int i = 0; i < arr2D.length; i++) {
            for (int j = 0; j < arr2D[i].length; j++) {
                arr[i * arr2D[i].length + j] = arr2D[i][j];
            }
        }

        int k = sc.nextInt();
        System.out.println(arr[k]);
    }
}
