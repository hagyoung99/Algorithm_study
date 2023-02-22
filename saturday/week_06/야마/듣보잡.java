//문제
//        김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.
//
//        듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
//
//        출력
//        듣보잡의 수와 그 명단을 사전순으로 출력한다.
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        HashSet<String> hs = new HashSet();//듣도 못한사람 저장
        ArrayList<String> list = new ArrayList();

        for (int i = 0; i < N; i++) {
            hs.add(sc.next()); // 듣도 못한 사람 저장
        }

        int count = 0;
        for (int i = 0; i < M; i++) { // 입력 받는 값(보도 못한 사람)과 비교해서
            String s = sc.next();
            if(hs.contains(s)){
                list.add(s);
                count++;// 듣도 보도 못한 사람을 전부 list 저장 후
            }
        }
        Collections.sort(list);
        System.out.println(count);//크기
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)); // 듣도 보도 못한 사람의 이름을 정렬해서 출력
        }

    }
}
