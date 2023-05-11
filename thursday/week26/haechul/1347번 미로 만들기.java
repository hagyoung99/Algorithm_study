package BOJ.boj1347;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String oper = sc.nextLine();

        int[][] miro = new int[2 * n + 2][2 * n + 2];
        int x = n;
        int y = n;
        int minX = x, maxX = x;
        int minY = y, maxY = y;
        int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

        int currentDir = 0; // 남 : 0 / 서 : 1 / 북 : 2 / 동 : 3
        miro[x][y] = 1;

        for (int i = 0; i < oper.length(); i++) {
            char target = oper.charAt(i);
            if (target == 'L') {
                currentDir = (currentDir + 3) % 4;
            } else if (target == 'R') {
                currentDir = (currentDir + 1) % 4;
            } else {
                x += dir[currentDir][0];
                y += dir[currentDir][1];
                miro[x][y] = 1;
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }

        for (int i = minX; i < maxX + 1; i++) {
            for (int j = minY; j < maxY + 1; j++) {
                if (miro[i][j] == 1) {
                    System.out.print(".");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }

    }
}
