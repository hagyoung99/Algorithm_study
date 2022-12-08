import java.io.*;
import java.util.*;

public class Lazy24060 {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] nk = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        MergeClass mergeClass = new MergeClass(nk[0], nk[1]);
        int[] arr = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i = 0 ; i < nk[0] ; i += 1) mergeClass.arr[i] = arr[i];
        mergeClass.mergeSort(0, nk[0] - 1);
        System.out.println(-1);
    }

    static class MergeClass {
        public int condition;
        public int cnt = 0;
        public int[] tmp;
        public int[] arr;

        public MergeClass(int n, int condition) {
            this.tmp = new int[n];
            this.arr = new int[n];
            this.condition = condition;
        }
        public void mergeSort(int front, int back) {
            if(front < back) {
                int mid = (front + back) / 2;
                mergeSort(front, mid);
                mergeSort(mid + 1, back);
                merge(front, mid, back);
            }
        }

        private void merge(int front, int mid, int back) {
            int i = front;
            int j = mid + 1;
            int t = 0;
            while(i <= mid && j <= back) {
                if(arr[i] <= arr[j]) tmp[t++] = arr[i++];
                else tmp[t++] = arr[j++];
            }
            while(i <= mid) tmp[t++] = arr[i++];
            while(j <= back) tmp[t++] = arr[j++];
            i = front; t = 0;
            while(i <= back) {
                arr[i++] = tmp[t++];
                cnt++;
                if(cnt == condition) {
                    System.out.println(arr[i - 1]);
                    System.exit(0);
                }
            }
        }
    }
}
