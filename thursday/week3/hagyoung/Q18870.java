package thursday.week3.hagyoung;

/*
문제
    수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
    Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
    X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
입력
    첫째 줄에 N이 주어진다.
    둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
출력
    첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

좌표 압축이란?
순위가 중요한 알고리즘에서, 입력값의 갯수보다 입력값의 범위가 클 때 사용하는 방법
-> 주어진 값들을 정렬했을때 1번 인덱스의 값부터 N번까지를 0부터 N까지의 수로 표현한것을 의미한다.
입력예시
2 4 -10 4 -9 를 정렬하면 -10 -9 2 4 4 가 되고, 이 순서대로 0 1 2 3 3 이 되는데 이 숫자를 해당 인덱스에 넣으면 2 3 0 3 1 이 출력된다.
 */
import java.util.*;
import java.io.*;
public class Q18870{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] copy = new int[N];
        for(int i=0;i<N;i++) arr[i] = copy[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int x:copy){
            if(!map.containsKey(x)) {
                map.put(x,rank);
                rank++;
            }   
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) sb.append(map.get(arr[i])).append(' ');
        System.out.println(sb);
    }
}