package week28;
import java.util.*;
class Robot2{
	int x;
	int y;
	int d;
	int id;
	Robot2(int x, int y, int d, int id){
		this.x = x;
		this.y = y;
		this.d = d;
		this.id = id;
	}
	Robot2(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}
}
public class BOJ2174 {
	static int A, B, n, m;
	static int[][] arr;
	static boolean[][] visit;
	static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		B = scan.nextInt();
		A = scan.nextInt();
		arr = new int[A][B];
		visit = new boolean[A][B];
		List<Robot2> list = new ArrayList<>();
		n = scan.nextInt();
		m = scan.nextInt();
		for(int i = 0; i < n; i++) {
			int y = scan.nextInt() - 1;
			int x = A - scan.nextInt();
			char d = scan.next().charAt(0);
			if(d == 'E')
				list.add(new Robot2(x, y, 3, i + 1));
			else if(d == 'W')
				list.add(new Robot2(x, y, 1, i + 1));
			else if(d == 'N')
				list.add(new Robot2(x, y, 0, i + 1));
			else
				list.add(new Robot2(x, y, 2, i + 1));
		}
		List<Robot2> temp = new ArrayList<>();
		temp.add(null);
		for(int i = 0; i < list.size(); i++) {
			temp.add(new Robot2(list.get(i).x, list.get(i).y, list.get(i).d, list.get(i).id));
			visit[list.get(i).x][list.get(i).y] = true;
		}
		while(m--> 0) {
			int a = scan.nextInt();
			char d = scan.next().charAt(0);
			int b = scan.nextInt();
			Robot2 now = temp.get(a);
			int nx = now.x;
			int ny = now.y;
			int di = now.d;
			while(b --> 0) {
				if(d == 'F') {
					nx += dir[di][0];
					ny += dir[di][1];
					if(nx < 0 || ny < 0 || nx >= A || ny >= B) {
						System.out.println("Robot " + now.id + " crashes into the wall");
						System.exit(0);
					}
					if(visit[nx][ny]) {
						for(int i = 1; i < temp.size(); i++) {
							if(now.id == temp.get(i).id)
								continue;
							if(temp.get(i).x == nx&& temp.get(i).y == ny) {
								System.out.println("Robot " + now.id  + " crashes into robot " + temp.get(i).id);
								System.exit(0);
							}
						}
					}
				}else if(d == 'L')
					di = ((di + 1) + 4) % 4;
				else
					di = ((di - 1) + 4) % 4;
			}
			visit[now.x][now.y] = false;
			now.x = nx;
			now.y = ny;
			now.d = di;
			visit[nx][ny] = true; 
		}
		System.out.println("OK");
	}
}
