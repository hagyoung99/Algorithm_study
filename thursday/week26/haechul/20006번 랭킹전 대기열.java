package BOJ.boj20006;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    static class Room {
        int standard;
        TreeMap<String, Integer> players;

        public Room(int standard, TreeMap<String, Integer> players) {
            this.standard = standard;
            this.players = players;
        }

        public boolean isContainedInRange(int level) {
            return level >= standard - 10 && level <= standard + 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt(); // 플레이어 수
        int m = sc.nextInt(); // 방의 정원
        sc.nextLine();

        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            String temp = sc.nextLine();
            String[] temps = temp.split(" ");
            int level = Integer.parseInt(temps[0]);
            String name = temps[1];
            boolean flag = true;
            for (Room room : rooms) {
                if (room.players.size() < m && room.isContainedInRange(level)) {
                    room.players.put(name, level);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                TreeMap<String, Integer> players = new TreeMap<>();
                players.put(name, level);
                rooms.add(new Room(level, players));
            }
        }

        for (Room room : rooms) {
            if (room.players.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }
            room.players.forEach((key, value) -> System.out.println(value + " " + key));
        }
    }
}
