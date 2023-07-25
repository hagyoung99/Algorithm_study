package BOJ.boj2138;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char[] present;
    static char[] target;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        present = sc.nextLine().toCharArray();
        target = sc.nextLine().toCharArray();

        char[] arr1 = Arrays.copyOf(present, present.length);
        char[] arr2 = Arrays.copyOf(present, present.length);
        click(0, arr1);

        int result = Math.min(cal(arr1, true), cal(arr2, false));

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }
    public static int cal(char[] array, boolean isClicked) {
        int cnt = isClicked ? 1 : 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] != target[i - 1]) {
                click(i, array);
                cnt++;
            }
        }
        return Arrays.equals(array, target) ? cnt : Integer.MAX_VALUE;
    }

    private static void click(int i, char[] tmp) {
        if (i == 0) {
            tmp[i] = tmp[i] == '0' ? '1' : '0';
            tmp[i + 1] = tmp[i + 1] == '0' ? '1' : '0';
            return;
        }
        tmp[i - 1] = tmp[i - 1] == '0' ? '1' : '0';
        tmp[i] = tmp[i] == '0' ? '1' : '0';
        if (i == tmp.length - 1) return;
        tmp[i + 1] = tmp[i + 1] == '0' ? '1' : '0';
    }
}
