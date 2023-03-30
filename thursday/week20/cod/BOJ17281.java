import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaseBall {
	/**
	 * 백준 17281 야구 (https://www.acmicpc.net/problem/17281)
	 */
	private static int n;
	private static int[][] map;
	private static boolean[] visit;
	
	private static int[] player;
	
	private static int result = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(reader.readLine());
		
		map = new int[n+1][10];
		
		StringTokenizer st;
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j=1; j<=9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[10];
		player = new int[10];
		
		visit[4] = true;
		player[4] = 1;
		
		dfs(2);
		
		System.out.println(result);
		
	}

	private static void dfs(int count) {

		if (count == 10) {
			
			//순서 조합 끝
			
			//경기 시작
			play();
			
		} else {
			
			for (int i=1; i<=9; i++) {
				if (!visit[i]) {
					visit[i] = true;
					player[i] = count;
					dfs(count+1);
					visit[i] = false;
				}
			}
		}
		
	}//dfs

	private static void play() {
		
		int score = 0;
		int startPlayer = 1;
		boolean[] base;
		
		for (int i=1; i<=n; i++) {
			int outCnt = 0;
			base = new boolean[4];
			
			finish : while(true) {
				for (int j=startPlayer; j<=9; j++) {
					int hitter = map[i][player[j]];
					
					switch (hitter) {
					case 0: //아웃
						outCnt++;
						break;
					case 1: //1루타
						for (int k=3; k>=1; k--) {
							if (base[k]) {
								if (k==3) {
									score++;
									base[k] = false;
									continue;
								}

								base[k] = false;
								base[k+1] = true;
							}
							
						}
						base[1] = true;
						break;
					case 2: //2루타
						for (int k=3; k>=1; k--) {
							if (base[k]) {
								if (k==3 || k==2) {
									score++;
									base[k] = false;
									continue;
								}
								base[k] = false;
								base[k+2] = true;
							}
						}
						base[2] = true;
						break;
					case 3: //3루타
						for (int k=1; k<=3; k++) {
							if (base[k]) {
								score++;
								base[k] = false;
							}
						}
						base[3] = true;
						break;
					case 4: //홈런
						for (int k=1; k<=3; k++) {
							if (base[k]) {
								score++;
								base[k] = false;
							}
						}
						score++;
						break;
					}

					if (outCnt == 3) {
						startPlayer = j + 1;
						if (startPlayer == 10) {
							startPlayer = 1;
						}
						break finish;
					}
				}
				//이닝이 다 끝나서 1번부터 시작
				startPlayer = 1;
			}
		}
		
		result = Math.max(result, score);
		
	}//play
}

