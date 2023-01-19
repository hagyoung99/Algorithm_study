package samsung01.jeensung;

import java.util.*;
public class BOJ1654 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int n = scan.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        for(int i = 0; i < k; i++)
            list.add(scan.nextLong());
        Collections.sort(list);
        long max = list.get(list.size() - 1);
        long answer = 0;
        long left = 1;
        long right = max + 1;
        long mid = 0;
        int count = 0;
        while (left < right){
            count = 0;
            mid = (left + right) / 2;
            for(int i = 0; i < list.size(); i++)
                count += list.get(i)/mid;
            if(count >= n){
                left = mid + 1;
                answer = Math.max(answer, mid);
            }else{
                right = mid;
            }
        }
        System.out.println(answer);
    }
}
