package 리트코드.UniquePaths_62;

public class ReMain {
    public static int m, n;
    public static int goal;
    public static int count;
    public static int[][] arr;
    public static int[] row = {0, 1};
    public static int[] col = {1, 0};

    public static void main(String[] args) {
        m = 3;
        n = 7;

        arr = new int[m][n];
        arr[0][0] = 1;
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        dfs(0, 0);

        System.out.println("arr[m - 1][n - 1] = " + arr[m - 1][n - 1]);
    }

    public static void dfs(int x, int y) {
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                System.out.println("i = " + i);
                System.out.println("j = " + j);
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
    }


}

