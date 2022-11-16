import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer[] orders = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
		Integer[] numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

		quickSort(numbers, 0, numbers.length - 1);
		System.out.println(numbers[orders[1] - 1]);
	}

	// 기준을 정하고 큰 쪽은 왼쪽으로, 작은 쪽은 오른 쪽으로 교체하는 과정 반복
	public static void quickSort(Integer[] arr, int start, int end) {

		if (start >= end) return;

		int pivot = partition(arr, start, end);

		quickSort(arr, start, pivot - 1); //  4. 왼쪽 작은 그룹 정렬
		quickSort(arr, pivot + 1, end);  // 5. 오른쪽 큰 그룹 정렬
	}

	private static int partition(Integer[] arr, int start, int end) {
		int left = start;
		int right = end;
		int pivot = arr[start];

		while (left < right) {
			while (left < right && arr[right] < pivot) right -= 1; // 1-1. 크거나 같은 수 탐색(오른쪽부터)
			while (left < right && arr[left] >= pivot) left += 1; // 1-2. 작은 수 탐색(왼쪽부터)

			swap(arr, left, right); // 2. 왼쪽 pivot보다 작은 값과 오른쪽 pivot보다 큰 값 교환
		}
		swap(arr, start, right); // 3. pivot보다 큰 값으로 교체된 마지막 index의 값과 pivot의 값 교환 (작음이 보장됨)
		return right;
	}

	private static void swap(Integer[] arr, int left, int right) {
		Integer tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
}
