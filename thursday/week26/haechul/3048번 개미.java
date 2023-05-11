package BOJ.boj3048;

import java.util.Scanner;

public class Main {
    static Ant[] ants;

    static class Ant {
        char name;
        int dir;

        public Ant(char name, int dir) {
            this.name = name;
            this.dir = dir;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        sc.nextLine();
        String ant1 = sc.nextLine();
        String ant2 = sc.nextLine();
        int t = sc.nextInt();


        ants = new Ant[n1 + n2];

        for (int i = 0; i < n1; i++) {
            ants[n1 - 1 - i] = new Ant(ant1.charAt(i), 0);
        }
        for (int i = 0; i < n2; i++) {
            ants[n1 + i] = new Ant(ant2.charAt(i), 1);
        }

        for (int i = 0; i < t; i++) {
            int idx = 0;
            while (idx < ants.length - 1) {
                if (ants[idx].dir == 0 && ants[idx].dir != ants[idx + 1].dir) {
                    swap(idx, idx + 1);
                    idx += 2;
                    continue;
                }
                idx++;
            }
        }

        for (int i = 0; i < ants.length; i++) {
            System.out.print(ants[i].name);
        }

    }

    private static void swap(int x, int y) {
        Ant temp = ants[x];
        ants[x] = ants[y];
        ants[y] = temp;
    }

}
