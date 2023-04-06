package thursday.week21.jinu;

import java.io.*;
import java.util.*;

public class Question7490 {

    private static class KeroList {
        int[] data;
        int size = 0;

        KeroList() {
            data = new int[NUM + SIGN];
        }

        void add(int num) {
            data[size++] = num;
        }

        int pop() {
            return data[--size];
        }

        int calc() {
            int result = data[0];

            for (int i = 1; i < size; i += 2) {
                if (data[i] == PLUS) {
                    result += data[i + 1];
                } else if (data[i] == MINUS) {
                    result -= data[i + 1];
                }
            }
            return result;
        }

        void clear() {
            size = 0;
        }
    }

    static final int NUM = 9, SIGN = 8, EMPTY = -1, PLUS = -2, MINUS = -3;
    static int size, num;
    static int[] data = new int[SIGN + NUM];
    static KeroList keroList = new KeroList();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tnum = stoi(st.nextToken());

        for (int t = 1; t <= tnum; t++) {
            st = new StringTokenizer(br.readLine());
            size = ((num = stoi(st.nextToken())) << 1) - 1;
            for (int i = size - 1; i >= 0; i -= 2)
                data[i] = num--;
            findSign(1);
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void findSign(int depth) {
        if (depth >= size) {
            if (isPossible())
                print();
            return;
        }

        for (int sign = -1; sign >= -3; sign--) {
            data[depth] = sign;
            findSign(depth + 2);
        }
    }

    private static boolean isPossible() {
        keroList.clear();
        for (int i = 0; i < size; i++) { // EMPTY 연산
            keroList.add(data[i] != EMPTY ? data[i] : (keroList.pop() * 10 + data[++i]));
        }

        return keroList.calc() == 0;
    }

    private static void print() {
        for (int i = 0; i < size; i++) {
            switch (data[i]) {
                case EMPTY:
                    sb.append(" ");
                    break;
                case PLUS:
                    sb.append("+");
                    break;
                case MINUS:
                    sb.append("-");
                    break;
                default:
                    sb.append(data[i]);
                    break;
            }
        }
        sb.append("\n");
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }
}
