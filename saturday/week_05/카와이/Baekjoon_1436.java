
// 종말의 수 예시 :  666, 1666, 2666, 3666, 4666, 5666, 6660, 6661, 6662, …


import java.util.*;
public class Baekjoon_1436 {
    static boolean func(int i){
        while(i > 0){
            if(i % 1000 == 666)
                return true;
            i /= 10;
        }
        // 맨 끝 3자리가 666인지 확인
        // 아니라면 1의 자리를 버리고 다시 재확인

        return false;
    }
    public static void main(String[]args){
        int cnt = 0;
        int num = 666;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(cnt < n){
            if (func(num)) cnt++;
            num++;
        }

        int ans = num-1;

        // while loop 진행 후 num이 1 더 증가되기에 이를 고려

        System.out.println(ans);
    }
}