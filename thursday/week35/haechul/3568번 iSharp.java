package BOJ.boj3568;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] var = sc.nextLine().split(" ");
        String og = var[0];

        for (int i = 1; i < var.length; i++) {
            String tmp = var[i];
            String front = og;
            StringBuilder back = new StringBuilder();
            for (int j = tmp.length() - 1; j >= 0; j--) {
                char x = tmp.charAt(j);
                if (x == ';' || x == ',') {
                    continue;
                } else if (Character.isLetter(x)) {
                    back.append(x);
                } else {
                    if (x == ']') {
                        front += '[';
                    } else if (x == '[') {
                        front += ']';
                    } else {
                        front += x;
                    }
                }
            }
            back.reverse();
            back.append(";");
            System.out.println(front + " " + back);
        }

    }
}
