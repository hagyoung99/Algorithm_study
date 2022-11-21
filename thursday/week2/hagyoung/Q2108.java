package thursday.week2.hagyoung;

import java.io.*;
import java.util.*;
public class Q2108 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int sum = 0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        Arrays.sort(arr);


        int mode = Integer.MIN_VALUE;
        for(int value:map.values()) mode = Math.max(value, mode);
        
        List<Integer> modeList = new ArrayList<>();
        for(int key:map.keySet()) if(map.get(key) == mode) modeList.add(key);
        
        Collections.sort(modeList);
        if(modeList.size()>=2) mode = modeList.get(1);
        else mode = modeList.get(0);
        
            

        System.out.println("산술평균 : " + (int)Math.round(((double)sum/N)));
        System.out.println("중앙값   : " + arr[N/2]);
        System.out.println("최빈값   : "+mode);
        System.out.println("범위     : "+(max - min));
    }
}
