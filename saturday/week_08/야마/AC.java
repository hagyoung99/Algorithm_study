import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class BJ5430_AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		test : for(int t = 1; t <= T; t++) {
			// 명령 입력받기.
			String orders = br.readLine();
			int size = Integer.parseInt(br.readLine());
			
		\
			String str = br.readLine();
			str = str.substring(1, str.length()-1);
			int[] map;
			try {
				map = Stream.of(str.split(",")).mapToInt(Integer::parseInt).toArray();				
			} catch(Exception e) {
				map = new int[0];
			}
			
			int[] pointer = new int[] {0, size-1};
			int mod = 0;
			int idx = 0;
			while(idx < orders.length()) {
				char order = orders.charAt(idx++);
				switch (order) {
				case 'D' :
					// mod가 0이면 1을 더하고,
					// mod가 1이면 1을 뺌.
					pointer[mod] += (mod*2-1)*(-1);
					if(--size < 0) {
						sb.append("error\n");
						continue test;
					}
					
					break;
				case 'R' :
					mod = 1-mod;
					break;
				}
			}
			
			// 모드가 0
			sb.append("[");
			StringBuilder ssb = new StringBuilder();
			if(mod == 0) {
				for(int i = pointer[0]; i <= pointer[1]; i++) {
					ssb.append(map[i]+",");//앞
				}			
			} else {
				for(int i = pointer[1]; i >= pointer[0]; i--){
					ssb.append(map[i]+",");//
				}
			}
			if(ssb.length() > 0) sb.append(ssb.substring(0, ssb.length()-1));
			sb.append("]\n");

		}
		System.out.println(sb);
	}
}
