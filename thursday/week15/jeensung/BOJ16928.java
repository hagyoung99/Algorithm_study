package jeensung;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Dice{
    int x;
    int cnt;
    Dice(int x, int cnt){
        this.x = x;
        this.cnt = cnt;
    }
}
class Main{
    static int n, m;
    static int[] hoop;
    static boolean[] visit;
    static Queue<Dice> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        visit = new boolean[101];
        hoop = new int[101];
        for (int i = 0; i < n + m; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            hoop[x] = y;
        }
        bfs();
    }
    static void bfs(){
        queue.offer(new Dice(1, 0));
        visit[1] = true;
        while(!queue.isEmpty()){
            Dice now = queue.poll();
            if(now.x == 100){
                System.out.println(now.cnt);
                System.exit(0);
            }
            for(int i = 1; i <= 6; i++){
                int nx = now.x + i;
                if(nx > 100)
                    continue;
                if(visit[nx])
                    continue;
                if(hoop[nx] > 0){
                    queue.offer(new Dice(hoop[nx], now.cnt + 1));
                    visit[hoop[nx]] = true;
                    continue;
                }
                queue.offer(new Dice(nx, now.cnt + 1));
                visit[nx] = true;
            }
        }
    }
}