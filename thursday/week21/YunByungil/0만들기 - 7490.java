package b전체문제.골드.zero만들기_7490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int t, n;
    public static String[] arr;
    public static String[] test;
    public static int nowLocation = 0;
    public static char[] calTemp;

    public static String temp;
    public static int check = 0;

    public static char[] cal = {' ', '+', '-'};
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {

            n = Integer.parseInt(br.readLine());
            int number = 1;
            arr = new String[n + n - 1];
            test = new String[n + n - 1];
            calTemp = new char[n - 1];

            for (int i = 0; i < n + n - 1; i++) {
                if (i % 2 == 0) {
                    arr[i] = String.valueOf(number++);
                }
            }

            dfs(0);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int depth) {
        if (depth == n - 1) {
            isZero();
//            for (int i = 0; i < calTemp.length; i++) {
//                System.out.print(calTemp[i] + " ");
//            }
//            System.out.println();
            return;
        }

        for (int i = 0; i < 3; i++) {
            calTemp[nowLocation++] = cal[i];
            dfs(depth + 1);
            nowLocation--;
        }
    }

    public static void isZero() {
        int location = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                arr[i] = calTemp[location] + "";
                location++;
            }
        }
//        for (String s : arr) {
//            System.out.println("arr = " + s);
//        }

        calculate(arr);
//        reset();
    }

    public static void calculate(String[] answer) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            test[i] = arr[i];
        }


        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ")) {
                if (i != 1) {
                    if (arr[i - 2].equals("-")) {
                        String str = "-" + arr[i - 1] + arr[i + 1];
                        test[i - 2] = "+";
                        test[i - 1] = str;
                        test[i] = "+";
                        test[i + 1] = "0";
                    } else if (arr[i - 2].equals("+")){
                        String str = arr[i - 1] + arr[i + 1];
                        test[i - 1] = str;
                        test[i] = "+";
                        test[i + 1] = "0";

                    }
                } else {
                    String str = arr[i - 1] + arr[i + 1];
                    test[i - 1] = "0";
                    test[i] = "+";
                    test[i + 1] = str;
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                if (i == 1) {
                    if (test[i].equals("+")) {
                        result += Integer.parseInt(test[i - 1]) + Integer.parseInt(test[i + 1]);
                    } else if (test[i].equals("-")) {
                        result += Integer.parseInt(test[i - 1]) - Integer.parseInt(test[i + 1]);
                    } else if (test[i].equals(" ")) {
                        result += Integer.parseInt("" + test[i - 1] + test[i + 1]);
                    }
                } else {
                    if (test[i].equals("+")) {
                        result += Integer.parseInt(test[i + 1]);
                    } else if (test[i].equals("-")) {
                        result -= Integer.parseInt(test[i + 1]);
                    } else if (test[i].equals(" ")) {
                        result = Integer.parseInt("" + result + test[i + 1]);
                    }
                }
            }
        }
        if (result == check) {
            for (String s : answer) {
                sb.append(s);
            }
            sb.append("\n");
        }
    }

}
