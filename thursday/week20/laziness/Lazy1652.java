package thursday.week20.laziness;

import java.util.Scanner;

public class Lazy1652 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); scanner.nextLine();
        String[][] arr = new String[n][n];
        for(int i = 0 ; i < n ; i++) arr[i] = scanner.nextLine().split("");
        int verti = 0; int hori = 0;
        for(int i = 0 ; i < n ; i++) {
            int vertiFlag = 0, horiFlag = 0;
            for(int j = 0 ; j < n ; j++) {
                if(arr[i][j].equals(".")) horiFlag++;
                else if(horiFlag >= 2) {
                    hori++; horiFlag = 0;
                } else {
                    horiFlag = 0;
                }
                if(arr[j][i].equals(".")) vertiFlag++;
                else if(vertiFlag >= 2) {
                    verti++; vertiFlag = 0;
                } else {
                    vertiFlag = 0;
                }
            }
            if(horiFlag >= 2) hori++;
            if(vertiFlag >= 2) verti++;
        }
        System.out.println(hori + " " + verti);
        scanner.close();
    }
}
