package thursday.week26.jinu;

import java.io.*;
import java.util.*;

public class BOJ20006 {

    public static class Player implements Comparable<Player> {
        int level;
        String name;
        boolean check;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player p1) {
            return name.compareTo(p1.name);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방 정원
        Player[] players = new Player[p];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            players[i] = new Player(level, name);
        }

        for (int i = 0; i < p; i++) {
            ArrayList<Player> room = new ArrayList<>();
            if (!players[i].check) {
                for (int j = i; j < p; j++) {
                    if (room.size() == m) {
                        break;
                    }
                    int level = players[j].level;
                    String name = players[j].name;
                    if (!players[j].check && players[i].level - 10 <= level && players[i].level + 10 >= level) {
                        players[j].check = true;
                        room.add(new Player(level, name));
                    }
                }

                Collections.sort(room);
                if (room.size() == m) {
                    sb.append("Started!").append("\n");
                } else {
                    sb.append("Waiting!").append("\n");
                }
                for (Player player : room) {
                    sb.append(player.level).append(" ").append(player.name).append("\n");
                }
            }

        }
        System.out.println(sb);
    }
}