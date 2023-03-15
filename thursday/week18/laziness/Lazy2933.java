package thursday.week18.laziness;

import java.io.*;
import java.util.*;

public class Lazy2933 {
    public static int r, c, n;
    public static int[] height;
    public static boolean[][] outVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        String[][] arr = new String[r][c];
        for(int i = 0 ; i < r ; i++) arr[i] = reader.readLine().split("");
        n = Integer.parseInt(reader.readLine());
        height = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = getShape(arr);
        for(String[] ar : arr) {
            for(String s : ar) System.out.print(s + "\t");
            System.out.println();
        }
        System.out.println();
    }
    public static String[][] getShape(String[][] arr) {
        boolean isLeft = true;
        for(int i = 0 ; i < n ; i++) {
            if(isLeft) {
                for(int j = 0 ; j < c ; j++) {
                    if(arr[r - height[i]][j].equals("x")) {
                        arr[r - height[i]][j] = ".";
                        break;
                    }
                }
                isLeft = false;
            } else {
                for(int j = c - 1 ; j > -1 ; j--) {
                    if(arr[r - height[i]][j].equals("x")) {
                        arr[r - height[i]][j] = ".";
                        break;
                    }
                }
                isLeft = true;
            }
            arr = breakDown(arr);
            for(String[] ar : arr) {
                for(String s : ar) System.out.print(s + "\t");
                System.out.println();
            }
            System.out.println();
        }
        return arr;
    }
    public static String[][] breakDown(String[][] arr) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        outLoop:
        for(int i = 0 ; i < c ; i++) {
            for(int j = r - 2 ; j > 0 ; j--) {
                if(arr[j][i].equals("x") && arr[j + 1][i].equals(".")) {
                    boolean clustered = false;

                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[r][c];
                    queue.offer(new int[]{i, j});
                    visited[j][i] = true;

                    while(!queue.isEmpty()) {
                        int[] mineral = queue.poll();
                        if(mineral[1] == r - 1) {
                            clustered = true;
                            break;
                        }
                        for(int[] direction : directions) {
                            int dx = mineral[0] + direction[0], dy = mineral[1] + direction[1];
                            if(dx >= c || dy >= r || dx < 0 || dy < 0)
                                continue;
                            if(arr[dy][dx].equals("x") && !visited[dy][dx]) {
                                queue.offer(new int[]{dx, dy});
                                visited[dy][dx] = true;
                            }
                        }
                    }
                    if(!clustered) {
                        arr = dropCluster(arr, i, j);
                        for(String[] ar : arr) {
                            for(String s : ar) System.out.print(s + "\t");
                            System.out.println();
                        }
                        System.out.println();
                        break outLoop;
                    }
                }
            }
        }
        return arr;
    }

    private static String[][] dropCluster(String[][] arr, int x, int y) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        queue.offer(new int[]{x, y});
        visited[y][x] = true;

        String[][] clone = new String[r][c];
        for(int i = 0 ; i < r; i++) {
            for(int j = 0 ; j < c; j++) {
                clone[i][j] = arr[i][j];
            }
        }
        
        clone = drop(clone, x, y);
            
        while(!queue.isEmpty()) {
            int[] mineral = queue.poll();
            for(int[] direction : directions) {
                int dx = mineral[0] + direction[0], dy = mineral[1] + direction[1];
                if(dx >= c || dy >= r || dx < 0 || dy < 0)
                    continue;
                if(arr[dy][dx].equals("x") && !visited[dy][dx]) {
                    queue.offer(new int[]{dx, dy});
                    visited[dy][dx] = true;
                    clone = drop(clone, dx, dy);
                }
            }
        }
        return clone;
    }
    private static String[][] drop(String[][] arr, int x, int y) {
        for(int i = r - 1; i >= 0 ; i--) {
            if(arr[i][x].equals(".")) {
                arr[i][x] = "x";
                arr[y][x] = ".";
                return arr;
            }
        }
        return arr;
    }
}