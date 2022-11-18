import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int len = Integer.parseInt(br.readLine());
        int[] arr = new int[len];
        
        for(int i = 0 ; i < len ; i++) arr[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
       
        // 평균과 중앙값
        int avg = 0;
        for(int i : arr) avg += i;
        System.out.println(Math.round(avg / 1.0 / arr.length));
        System.out.println(arr[arr.length / 2]);
        
        // 고난의 최빈값(2번째로 작은)
        boolean flag = false;
        int mode_max = 0;
        int mode = 10000;

        for(int i = 0; i < len ; i++) {
          int jump = 0;	 
          int count = 1;
          int i_value = arr[i];

          for(int j = i + 1; j < len ; j++){
            if(i_value != arr[j]) break;
            count++;
            jump++;
          }

          if(count > mode_max) {
            mode_max = count;
            mode = i_value;
            flag = true;
          } else if(count == mode_max && flag) {
            mode = i_value;
            flag = false;
          }
          i += jump;
        }
        System.out.println(mode);
        
        // 너무 쉬운 범위
        System.out.println(arr[arr.length - 1] - arr[0]);
    }
}
