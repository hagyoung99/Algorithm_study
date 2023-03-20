package thursday.week19.laziness;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lazy5212 {
    public static int r, c;
    public static String[][] field;
    public static int[][] directions = {{-1, 0}, {1, 0} ,{0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        r = Integer.parseInt(st.nextToken()); c = Integer.parseInt(st.nextToken());
        field = new String[r][c];
        for(int i = 0 ; i < r ; i++) field[i] = reader.readLine().split("");
        getLater();
        for(String[] row : field) {
            for(String dot : row) System.out.print(dot);
            System.out.println();
        }
    }

    private static void getLater() {
        String[][] clone = new String[r][c];
        for(int i = 0 ; i < r ; i++) clone[i] = field[i].clone();
        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                if(field[i][j].equals("X")) {
                    int cnt = 0;
                    for(int[] direction : directions) {
                        int dy = i + direction[1], dx = j + direction[0];
                        if(dx < 0 || dy < 0 || dx >= c || dy >= r || clone[dy][dx].equals(".")) cnt++;
                    }
                    if(cnt >= 3) field[i][j] = ".";
                }
            }
        }
        concatField();
    }

    private static void concatField() {
        int startX = 0, startY = 0, endX = c - 1, endY = r - 1;
        while(true) {
            boolean flagStartX = true;
            for(int i = 0 ; i < r ; i++) {
                if(field[i][startX].equals("X")) {
                    flagStartX = false; break;
                }
            }
            if(flagStartX) startX++;

            boolean flagStartY = true;
            for(int i = 0 ; i < c ; i++) {
                if(field[startY][i].equals("X")) {
                    flagStartY = false; break;
                }
            }
            if(flagStartY) startY++;
            
            boolean flagEndX = true;
            for(int i = 0 ; i < r ; i++) {
                if(field[i][endX].equals("X")) {
                    flagEndX = false; break;
                }
            }
            if(flagEndX) endX--;

            
            boolean flagEndY = true;
            for(int i = 0 ; i < c ; i++) {
                if(field[endY][i].equals("X")) {
                    flagEndY = false; break;
                }
            }
            if(flagEndY) endY--;

            if(!flagStartX && !flagStartY && !flagEndX && !flagEndY) break;
        }
        String[][] newField = new String[endY - startY + 1][endX - startX + 1];
        int idxRow = startY, idxCol = startX;
        for(int i = 0 ; i < newField.length ; i++) {
            for(int j = 0 ; j < newField[0].length ; j++) {
                newField[i][j] = field[idxRow][idxCol++];
            }
            idxRow++; idxCol = startX;
        }
        field = newField;
    }
}
