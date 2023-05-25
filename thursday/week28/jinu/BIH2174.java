package thursday.week28.jinu;

import java.util.*;
import java.io.*;

public class BIH2174 {
    static int A, B, N, M;
    static int[][] map; // 로봇이 움직일 면적 배열
    static HashMap<Integer, Robot> hash = new HashMap<>(); // 로봇 번호 , 로봇 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken()); // 땅 가로 크기
        B = Integer.parseInt(st.nextToken()); // 땅 세로 크기
        map = new int[B + 1][A + 1]; // 입력받는 좌표가 1부터 시작하기 때문에 배열을 하나 더 크게 잡는다.

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 로봇 갯수
        M = Integer.parseInt(st.nextToken()); // 명령 갯수

        // 로봇 갯수만큼 입력받음
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0); // 문자로 받은 로봇의 방향

            // HashMap에 로봇의 번호를 Key 값으로하여 삽입한다.
            hash.put(i, new Robot(x, y, dir));

            // 로봇이 있는 위치는 로봇의 번호를 넣음
            map[x][y] = i;
        }

        // 명령 시작
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int robotNum = Integer.parseInt(st.nextToken()); // 로봇 번호
            char order = st.nextToken().charAt(0); // 명령

            int repNum = Integer.parseInt(st.nextToken()); // 명령 반복 횟수

            Robot rob = hash.get(robotNum);

            // 앞으로 전진할 때
            if (order == 'F') {
                int nX = rob.x;
                int nY = rob.y;
                for (int r = 0; r < repNum; r++) {
                    // 새롭게 구한 좌표를 arr 배열로 반환함
                    int[] arr = setNewPosition(rob.dir, nX, nY);
                    nX = arr[0]; // 새롭게 구한 로봇의 X좌표
                    nY = arr[1]; // 새롭게 구한 로봇의 Y좌표

                    // 벽에 충돌
                    if (nX <= 0 || nY <= 0 || nX > B || nY > A) {
                        System.out.println("Robot " + robotNum + " crashes into the wall");
                        return;
                    }

                    // 다른 로봇과 충돌
                    if (map[nX][nY] != 0) {
                        System.out.println("Robot " + robotNum + " crashes into robot " + map[nX][nY]);
                        return;
                    }

                }
                // 로봇 최종 위치 갱신
                // 원래 잇엇던 위치는 0으로 다시 바꿈
                map[rob.x][rob.y] = 0;
                hash.remove(robotNum); // 새롭게 넣을 값과 중복되지 않도록 삭제
                // 새롭게 HashMap에 넣고 새로운 위치에 로봇 번호 넣음
                hash.put(robotNum, new Robot(nX, nY, rob.dir));
                map[nX][nY] = robotNum;

            }
            // 방향만 바꿀 때
            else if (order == 'L' || order == 'R') {
                char newDir = rob.dir;
                for (int r = 0; r < repNum; r++) {
                    newDir = setTurnOrder(robotNum, newDir, order);
                }
                // HashMap에 새롭게 로봇 번호와 새로운 위치, 방향을 넣어줌
                hash.remove(robotNum);
                hash.put(robotNum, new Robot(rob.x, rob.y, newDir));
            }

        } // 명령 끝

        System.out.println("OK");

    }

    static int[] setNewPosition(char robotHead, int robX, int robY) {
        /*
         * robotHead: 로봇의 현재 방향
         * robX: 로봇의 현재 X좌표
         * robY: 로봇의 현재 Y좌표
         *
         * 문제에서 제시하는 좌표, 방향과 2차원 배열에서의 좌표, 방향이 다르기 때문에
         * N과 S에서 값을 잘 처리해줘야한다.
         */
        int newX = robX;
        int newY = robY;
        int[] arr = new int[2];
        switch (robotHead) {
            case 'E':
                newY += 1;
                break;

            case 'N':
                newX += 1;
                break;

            case 'W':
                newY -= 1;
                break;

            case 'S':
                newX -= 1;
                break;
            default:
                break;
        }
        arr[0] = newX;
        arr[1] = newY;

        return arr;
    }

    static char setTurnOrder(int robotNum, char robotHead, char order) {
        /*
         * robotNum: 로봇 번호
         * robotHead: 로봇이 바라보는 방향
         * order: 명령 종류
         */
        char newDir;
        switch (order) {
            case 'L':
                newDir = changeDir(robotHead, 'L');
                return newDir;

            case 'R':
                newDir = changeDir(robotHead, 'R');
                return newDir;

            default:
                break;
        }
        return 'a';
    }

    // 방향 바꾸는 메소드
    static char changeDir(char robotHead, char dir) {
        /*
         * robotHead: 현재 로봇이 바라보는 방향
         * dir: 명령 받은 방향
         */
        switch (robotHead) {
            case 'E':
                if (dir == 'L') {
                    return 'N';
                } else if (dir == 'R') {
                    return 'S';
                }
            case 'S':
                if (dir == 'L') {
                    return 'E';
                } else if (dir == 'R') {
                    return 'W';
                }
            case 'W':
                if (dir == 'L') {
                    return 'S';
                } else if (dir == 'R') {
                    return 'N';
                }
            case 'N':
                if (dir == 'L') {
                    return 'W';
                } else if (dir == 'R') {
                    return 'E';
                }
            default:
                break;
        }
        return 'a';
    }

    static class Robot {
        int x, y;
        char dir;

        Robot(int x, int y, char dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
