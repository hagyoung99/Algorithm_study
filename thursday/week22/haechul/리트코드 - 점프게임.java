package LeetCode.Max_Area_Of_Island;

class Solution {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;

    }

    private static int dfs(int[][] grid, int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] == 0) {
            return 0;
        }

        grid[nx][ny] = 0;

        int area = 1;
        area += dfs(grid, nx - 1, ny) +
                dfs(grid, nx + 1, ny) +
                dfs(grid, nx, ny - 1) +
                dfs(grid, nx, ny + 1);
        return area;
    }
}
