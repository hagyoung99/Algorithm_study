
// -- 두가지 접근 방법 --
// 1. 선형탐색   2.이진탐색
// 완.탐 -> for 루프나 iterater 등으로 모든 경우의 수를 탐색해보는 경우
// 이.탐 -> 정렬을 먼저 실시한 후, mid pivot을 기준으로 작은 경우는 왼쪽 인덱스 확인, 큰 경우 오른쪽 인덱스 확인

// 시간복잡도 중요시 -> 입출력 buffer 메모리 최적화 + 이진탐색
// 빠른 풀이 -> Scanner + 완전탐색 or 이진탐색 (sort()나 binary_search() 이용할 경우)
// C는 죄송합니다.. ㅠㅠ


import java.io.*;
import java.util.*;

public class Baekjoon_10815 {
    public static void main(String[] args) throws IOException {

        int m, n;
        // 유저카드 개수, 같은 숫자 확인할 덱의 카드 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // default로 선언 시 구분자 (\t, \n, " ") 기준으로 string을 tokenize(split)

        ArrayList<Integer> U_Card = new ArrayList<>(m);
        // 유저카드 입력받아 구성

        for (int i = 0; i < m; i++) {
            U_Card.add(Integer.parseInt(st.nextToken()));
        }

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer((br.readLine()));
        ArrayList<Integer> T_Card = new ArrayList<>(n);
        // 맞혀볼 카드 입력받아 구성

        for (int i = 0; i < n; i++) {
            T_Card.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        // string 객체는 불변이라 병합 시에 새 문자열이 생성, 이전 string은 가비지 콜렉터로 / 메모리 할당 및 해제 연산 up

        for (int i = 0; i < n; i++) {
            if (U_Card.contains(T_Card.get(i))) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}



