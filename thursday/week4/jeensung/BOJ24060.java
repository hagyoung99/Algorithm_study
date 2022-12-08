package jeensung;

import java.util.Scanner;

public class BOJ24060 {
    
        static int[] temp;
        static int count = 0;
        static int K;
        static int result = -1;
    
        public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];
        K = sc.nextInt();

        temp = new int[num];

        for(int i = 0 ; i < num ; i++){
            arr[i] = sc.nextInt();
        }

        sc.close();

        merge_sort(arr, 0, arr.length - 1);
        System.out.print(result);

      }

    static void merge_sort(int A[], int low, int high){

            if(low < high){
                int mid = (low + high) / 2;
                merge_sort(A, low, mid);
                merge_sort(A, mid + 1, high);
                merge(A, low, mid, high);
            }
        }

    static void merge(int A[], int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        int t = 0;
        
        while(i <= mid && j <= high){
            if(A[i] <= A[j]){
                temp[t++] = A[i++];
            }else{
                temp[t++] = A[j++];
            }
        }

        while(i <= mid){
            temp[t++] = A[i++];
        }

        while(j <= high){
            temp[t++] = A[j++];
        }

        t = 0;
        i = low;

        while(i <= high){
            count++;
            if(count==K){
                result = temp[t];
                break;
            }
            A[i++] = temp[t++];
        }     
   }
}