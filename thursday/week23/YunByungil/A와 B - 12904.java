package b전체문제.골드.A와B_12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String s; // 주어진 문자열
    public static String t; // 만들어야 되는 문자열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        while (s.length() < t.length()) {
            if (t.endsWith("A")) {
                t = t.substring(0, t.length() - 1);
            } else if (t.endsWith("B")) {
                t = t.substring(0, t.length() - 1);
                t = change();
            }
        }

        if (t.equals(s)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static String change() {
        String newStr = "";
        for (int i = t.length() - 1; i >= 0; i--) {
            newStr += t.charAt(i);
        }

        return newStr;
    }
}
