package thursday.week19.laziness;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lazy1303 {
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static boolean[][] visited;
    public static String[][] arr;
    public static int n, m, we = 0, enemy = 0; 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); m = scanner.nextInt(); scanner.nextLine();
        arr = new String[m][n];
        visited = new boolean[m][n];
        for(int i = 0 ; i < m ; i++) {
            arr[i] = scanner.nextLine().split("");
        }
        countPopulation();
        System.out.println(we + " " + enemy);
        scanner.close();
    }
    private static void countPopulation() {
        while (true) {
            boolean flag = true;
            int startRow = 0, startCol = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (!visited[i][j]) {
                        flag = false; startRow = i; startCol = j; break;
                    }
                }
            }
            if(flag) break;
            boolean isOurTeam = arr[startRow][startCol].equals("W");

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startRow, startCol});
            visited[startRow][startCol] = true;
            int cloud = getCloud(queue);
            
            if(isOurTeam) we += cloud * cloud;
            else enemy += cloud * cloud;
        }
    }
    private static int getCloud(Queue<int[]> queue) {
        int cloud = 1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] direction : directions) {
                int dy = cur[0] + direction[0], dx = cur[1] + direction[1];
                if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
                if(!visited[dy][dx] && arr[dy][dx].equals(arr[cur[0]][cur[1]])) {
                    queue.add(new int[]{dy, dx}); 
                    visited[dy][dx] = true;
                    cloud++;
                } 
            }
        }
        return cloud;
    }
}
