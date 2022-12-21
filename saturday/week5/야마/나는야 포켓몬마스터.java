// 입력: 들어오는 숫자는 반드시 1보다 크거나 같고, N보다 작거나 같고, 입력으로 들어오는 문자는 반드시 도감에 있는 포켓몬의 이름만 주어져. 
// 출력:첫째 줄부터 차례대로 M개의 줄에 각각의 문제에 대한 답을 말해줬으면 좋겠어!!!. 입력으로 숫자가 들어왔다면 그 숫자에 해당하는 포켓몬의 이름을, 문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력하면 돼.



//저는 key에 이름, value에는번호가 저장될 수 있도록 두개의hashmap을사용해서 문제를 해결하고자 하였습니다
//HashMap<String,Integer>로 문자열에 맞는 번호를 담고 Strin[]로 번호(인덱스)에 맞는 문자열을 담아 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> poketmonName = new HashMap<>();
		HashMap<Integer, String> poketmonNum = new HashMap<>();
    //어느것이 먼저 들어올지 몰라 두개들 만들었다.
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			poketmonName.put(name, i);
			poketmonNum.put(i, name);
		}
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
      //번호인지 포켓몬이름인지 확인해준다.
			if (isNumber(input)) {
				sb.append(poketmonNum.get(Integer.parseInt(input)) + "\n");//숫자
			} else {
				sb.append(poketmonName.get(input) + "\n");//문자
			}
		}
		
		System.out.println(sb);
	}
	
	static boolean isNumber(String s) {
    //숫자인지 아닌지 확인
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
