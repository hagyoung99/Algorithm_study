import java.io.*;

public class Lazy1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        sort(arr, 0, arr.length - 1);
        System.out.println(String.valueOf(arr));
    }
    public static void sort(char[] arr, int left, int right) {
        if(left >= right) return;

        int pivot = partition(arr, left, right);
        sort(arr, left, pivot - 1);
        sort(arr, pivot + 1, right);
    }
    public static int partition(char[] arr, int left, int right) {
        int low = left;
        int high = right;
        char pivot = arr[left];
        while(low < high) {
            while(low < high && arr[high] < pivot) high -= 1;
            while(low < high && arr[low] >= pivot) low += 1;
            swap(arr, low, high);
        }
        swap(arr, left, low);
        return low;
    }
    public static void swap(char[] arr, int low, int high) {
        char tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }
}
