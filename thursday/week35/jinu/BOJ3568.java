package thursday.week35.jinu;

import java.io.*;

public class BOJ3568 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine().replace(",", "").replace(";", "");
        String[] str = origin.split(" ");

        for (int i = 1; i < str.length; i++) {
            String[] variable = reverseType(str[i]).split("#");
            System.out.println(str[0] + variable[0] + " " + variable[1] + ";");
        }
    }

    public static String reverseType(String str) {

        char[] origin = str.toCharArray();
        String result = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            if (origin[i] != ']') {
                if (origin[i] == '*' || origin[i] == '&') {
                    result += origin[i];
                } else {
                    result += "#";
                    for (int j = 0; j <= i; j++) {
                        result += origin[j];
                    }
                    break;
                }
            } else {
                result += "[]";
                i--;
            }
        }

        return result;
    }

}
