import java.io.*;

public class Q2750 {
    /*
        버블 정렬
        시간 복잡도 - O(N^2)

        정렬방법
        앞에서부터 시작해서 근접한 수 두개를 비교해 큰 값을 뒤로 밀어내는 방식
     */
    public static int[] bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    /*
        삽입 정렬
        시간 복잡도 - 최선 : O(N)
                   - 최악 : O(N^2)
        정렬방법
        index 1을 기준으로 시작해서 기존 숫자 앞의 숫자들과 비교해 기준 값보다 앞의 값이 크다면 뒤로 밀어내고, 작다면 멈춘 자리에 기준값을 넣는다.
     */
    public static int[] insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int tmp = arr[i];
            int j;
            for(j=i-1;j>=0;j--){
                if(arr[j] > tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());

        System.out.print("버블정렬 => ");
        for(int x: bubbleSort(arr)) System.out.print(x+" ");
        
        System.out.print("\n삽입정렬 => ");
        for(int x: insertionSort(arr)) System.out.print(x+" ");
    }    
}
