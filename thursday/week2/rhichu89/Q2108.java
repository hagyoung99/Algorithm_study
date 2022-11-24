import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        int[] counts = new int[8001];

        int sum = 0;
        int max = -4000;
        int min = 4000;

        int modeMax = 0;
        int mode = 0;

        // 입력
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            counts[(arr[i] + 4000)]++;
            sum += arr[i];

            // 최대
            if (max < arr[i]) {
                max = arr[i];
            }
            // 최소
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        // 정렬
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<Integer>();

        // 최빈값
        for (int i = arr[0] + 4000; i <= arr[num - 1] + 4000; i++) {
            if (counts[i] != 0 && counts[i] >= modeMax) {
                if (counts[i] > modeMax) {
                    list.clear();
                }
                modeMax = counts[i];
                list.add(i - 4000);
            }
        }

        if (modeMax == 0) {
            mode = arr[1];
        } else if (list.size() > 1) {
            mode = list.get(1);
        } else {
            mode = list.get(0);
        }


        System.out.println(Math.round(sum * 1.0 / num));
        System.out.println(arr[arr.length / 2]);
        System.out.println(mode);
        System.out.println(max - min);
    }
}
