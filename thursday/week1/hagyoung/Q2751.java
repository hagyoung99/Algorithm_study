import java.io.*;
import java.util.*;
/*
    자바의 collections.sort 는 timsort 알고리즘으로 정렬을 한다.
    timsort 알고리즘이란?
    합병정렬과 삽입정렬이 섞인 정렬 알고리즘으로 합병정렬을 기반으로 구현하지만, 일정 크기 이하의 리스트에서는 이진 삽입 정렬하는 방식이다.
    
 */
public class Q2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);
        for(int x:list) System.out.println(x);
    }
}
