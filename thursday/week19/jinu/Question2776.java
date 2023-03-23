package thursday.week19.jinu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Question2776 {
    static int note[];
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> noteMap;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int test = Integer.parseInt(st.nextToken());
        int n, m;

        for (int i = 0; i < test; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            note = new int[n];
            noteMap = new HashMap<>();

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                note[j] = num;
                if (!noteMap.containsKey(num))
                    noteMap.put(num, 1);
            }

            Arrays.sort(note);

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                binarySearch(num);
            }
        }

        System.out.print(sb);
    }

    // 1. noteSet에 수첩 1의 데이터를 저장
    // 2. 그다음에 noteSet을 배열로 만들고 정렬하기
    // 3. 수첩2의 데이터를 binarySearch 메소드에 한개씩 넣기
    // 4. sb에 1 또는 0을 넣기
    // -------------------------문제에서 int범위로 사용하기 때문에 set을 array로 바꾸지못함
    // -------------------------왜냐하면 set을 배열로 바꾸려고 하면 array 자료형이 Integer가 되어야함
    // 1. note 배열에 수첩1 데이터 저장
    // 2. noteMap에 note배열들의 자료들을 저장 --> 왜냐하면 중복이 있을 수 있으므로
    // 3. note 데이터를 정렬하고 binarySearch에 수첩2 데이터를 넣기
    // 3-1. binarySearch에는 인자로 들어있는 num이 noteMap에 포함되어있는 key라면 그 때 1을 반환하게 하면 됨.
    public static void binarySearch(int num) {
        int st, ed, mid;
        st = 0;
        ed = note.length - 1;
        while (st <= ed) {
            mid = (st + ed) / 2;
            if (noteMap.containsKey(num)) {
                sb.append(1 + "\n");
                return;
            } else if (note[mid] > num)
                ed = mid - 1;
            else
                st = mid + 1;
        }
        sb.append(0 + "\n");
    }
}