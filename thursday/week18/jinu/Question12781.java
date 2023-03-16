package thursday.week18.jinu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Question12781 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        Pair one = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        Pair two = new Pair(Integer.parseInt(input[2]), Integer.parseInt(input[3]));
        Pair three = new Pair(Integer.parseInt(input[4]), Integer.parseInt(input[5]));
        Pair four = new Pair(Integer.parseInt(input[6]), Integer.parseInt(input[7]));

        int a = ccw(one, two, three) * ccw(one, two, four);
        int b = ccw(three, four, one) * ccw(three, four, two);

        if (a < 0 && b < 0)
            System.out.println(1);

        else
            System.out.println(0);
    }

    public static int ccw(Pair a, Pair b, Pair c) {
        int cal = a.x * b.y + b.x * c.y + c.x * a.y - (a.y * b.x + b.y * c.x + c.y * a.x);

        if (cal > 0)
            return 1; // 세 점이 반시계 방향

        else if (cal == 0)
            return 0; // 세 점이 평행할 때

        else
            return -1; // 세 점이 시계 방향
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}