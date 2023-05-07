package week25;
import java.util.*;
class TT{
	int x;
	int y;
	int sheep;
	int wolf;
	TT(int x, int y, int sheep, int wolf){
		this.x = x;
		this.y = y;
		this.sheep = sheep;
		this.wolf = wolf;
	}
}
public class BOJ3184 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int c = scan.nextInt();
		char[][] arr = new char[r][c];
		for(int i = 0; i < r; i++) {
			String str = scan.next();
			for(int j = 0; j < c; j++)
				arr[i][j] = str.charAt(j);
		}
		int answer1 = 0;
		int answer2 = 0;
		int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
		Queue<TT> queue = new LinkedList<>();
		boolean[][] visit = new boolean[r][c];
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(!visit[i][j]) {
					queue = new LinkedList<>();
					if(arr[i][j] == 'o') {
						int sheep = 1;
						int wolf = 0;
						queue.offer(new TT(i, j, 1, 0));
						visit[i][j] = true;
						while(!queue.isEmpty()) {
							TT now = queue.poll();
							for(int k = 0; k< 4; k++) {
								int nx = now.x + dir[k][0];
								int ny = now.y + dir[k][1];
								if(nx < 0 || ny < 0 || nx >= r || ny >= c)
									continue;
								if(visit[nx][ny])
									continue;
								if(arr[nx][ny] == '#')
									continue;
								visit[nx][ny] = true;
								if(arr[nx][ny] == '.')
									queue.offer(new TT(nx, ny, now.sheep, now.wolf));
								if(arr[nx][ny] == 'o') {
									queue.offer(new TT(nx, ny, now.sheep + 1, now.wolf));
									sheep++;
								}
								if(arr[nx][ny] == 'v') {
									queue.offer(new TT(nx, ny, now.sheep, now.wolf + 1));
									wolf++;
								}
							}
						}
						if(sheep > wolf)
							answer1 += sheep;
						else
							answer2 += wolf;
					}
					else if(arr[i][j] == 'v'){
						int sheep = 0;
						int wolf = 1;
						queue.offer(new TT(i, j, 0, 1));
						visit[i][j] = true;
						while(!queue.isEmpty()) {
							TT now = queue.poll();
							for(int k = 0; k< 4; k++) {
								int nx = now.x + dir[k][0];
								int ny = now.y + dir[k][1];
								if(nx < 0 || ny < 0 || nx >= r || ny >= c)
									continue;
								if(visit[nx][ny])
									continue;
								if(arr[nx][ny] == '#')
									continue;
								visit[nx][ny] = true;
								if(arr[nx][ny] == '.')
									queue.offer(new TT(nx, ny, now.sheep, now.wolf));
								if(arr[nx][ny] == 'o') {
									queue.offer(new TT(nx, ny, now.sheep + 1, now.wolf));
									sheep++;
								}
								if(arr[nx][ny] == 'v') {
									queue.offer(new TT(nx, ny, now.sheep, now.wolf + 1));
									wolf++;
								}
							}
						}
						if(sheep > wolf)
							answer1 += sheep;
						else
							answer2 += wolf;
					}
	
				}
			}
		}
		System.out.println(answer1 + " " + answer2);
	}

}
