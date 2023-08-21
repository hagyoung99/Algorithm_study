import java.io.*;

// 비슷한 단어

public class BOJ2607 {
	
	//	1. 기준이 되는 문자열보다 길이가 한 글자 작은 경우
	//	2. 기준이 되는 문자열보다 길이가 한	 글자 큰 경우
	//	3. 기준이 되는 문자열과 길이가 같은 경우

	public static void main(String[] args) throws IOException {
		
		// 입력 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// br.readline은 String 형태로 받으니까 String 형태를 int 형태로 바꾸기 여기서 기준점을 빼줌
		int n = Integer.parseInt(br.readLine()) - 1;
		
		// 기준점을 받아오기
		String standard = br.readLine();
		
		// 기준점에 길이
		int len = standard.length();
		
		// 알파벳의 숫자
		int [] alphabet = new int [26];
		
		// 대문자 알파벳 숫자 저장
		for (int i = 0; i < len; i++) {
			alphabet[standard.charAt(i) - 'A']++;
		}
		
		// 정답을 받을 변수
		int ans = 0;
		
		// n이 0 이 될떄까찌
		while(n --> 0) {
			// alphabet 배열을 복제
			int [] temp = alphabet.clone();
			// bufferedReader에 String 입력
			String comp = br.readLine();
			
			int cnt = 0;
			for (int i = 0; i < comp.length(); i++) {
				if(temp[comp.charAt(i)- 'A'] > 0) {
					cnt++;
					temp[comp.charAt(i)-'A']--;
				}
			}
		
			//	1. 기준이 되는 문자열보다 길이가 한 글자 작은 경우
			if(len - 1 == comp.length() && cnt == comp.length()) {
				ans++;
			}else if(len == comp.length()) { 	//	2. 기준이 되는 문자열보다 길이가 같을 경우
				if(cnt == len || cnt == len - 1) {
					ans++;
				}
			}else if(len + 1 == comp.length()) {	//  3. 기준이 되는 문자열보다 길이가 한 글자 큰 경우
				if(cnt == len) {
					ans++;
				}
			}
		}
		
		// 정답을 출력
		System.out.println(ans);
		
		// bufferedReader 종료
		br.close();

	}

}
